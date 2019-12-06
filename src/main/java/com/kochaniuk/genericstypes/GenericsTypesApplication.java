package com.kochaniuk.genericstypes;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

public class GenericsTypesApplication<E extends Number & Comparable> {

    /*
        Static information are related to the method of declaring class fields, method or call arguments
        they are retained during program execution and can be accessed
        additionally are returned in one of the classes implementing the Type interface __ therefore they are not erased at all
     */
    private static List<String> astrings = new ArrayList<>();
    private static List bstrings = new ArrayList<String>();
    private static List cstrings = new ArrayList();
    private static ArrayList<String> dstrings = new ArrayList<String>();

    private static String string = "string";

    /*
        GenericsTypesApplication made generic
     */
    private E field;

    public <K, V> E genericMethod() {
        return field;
    }

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        System.out.println("\nClasses");

        Class<?> aClass = astrings.getClass();
        System.out.println(aClass);

        Class<?> bClass = bstrings.getClass();
        System.out.println(bClass);

        Class<?> cClass = cstrings.getClass();
        System.out.println(cClass);

        Class<?> dClass = dstrings.getClass();
        System.out.println(dClass);

        Class<?> stringClass = string.getClass();

        isClazzParametrized(aClass); // Type class java.util.ArrayList is parametrized, name: ArrayList
        isClazzParametrized(bClass); // Type class java.util.ArrayList is parametrized, name: ArrayList
        isClazzParametrized(cClass); // Type class java.util.ArrayList is parametrized, name: ArrayList
        isClazzParametrized(dClass); // Type class java.util.ArrayList is parametrized, name: ArrayList
        isClazzParametrized(stringClass);

        isTypeParametrized(GenericsTypesApplication.class.getDeclaredField("astrings").getGenericType(), "astrings");
        isTypeParametrized(GenericsTypesApplication.class.getDeclaredField("bstrings").getGenericType(), "bstrings");
        isTypeParametrized(GenericsTypesApplication.class.getDeclaredField("cstrings").getGenericType(), "cstrings");
        isTypeParametrized(GenericsTypesApplication.class.getDeclaredField("dstrings").getGenericType(), "dstrings");

        /*
            GenericsTypesApplication made generic
        */
        Method genericMethod = GenericsTypesApplication.class.getMethod("genericMethod"); // must be public
        Type type = genericMethod.getGenericReturnType();
        System.out.println("\n" + type);
        System.out.println("toString() - " + genericMethod.toString());
        System.out.println("toGenericString() - " + genericMethod.toGenericString());

        TypeVariable[] parameters = genericMethod.getTypeParameters();
        for (TypeVariable parameter : parameters) {
            System.out.println("\ntype parameter: " + parameter);
        }

        GenericsTypesApplication<SomeNumberClass> ourClassParametrizedAsInteger = new GenericsTypesApplication<>();
        Class<?> clazz = ourClassParametrizedAsInteger.getClass();

        for (TypeVariable parameter : clazz.getTypeParameters()) {
            System.out.println("\nParameter name: " + parameter.getName());
            System.out.println("Parameter generic declaration: " + parameter.getGenericDeclaration());

            Type[] bounds = parameter.getBounds();
            for (Type t : bounds) {
                System.out.println("\n" + t);
            }
        }

    }

    private static void isClazzParametrized(Class clazz) {
        if (clazz.getTypeParameters().length > 0) {
            System.out.println(String.format("\nType %s is parametrized", clazz));
        }
    }

    private static void isTypeParametrized(Type type, String declaredFieldName) {
        if (type instanceof ParameterizedType) {
            System.out.println(String.format(
                "\nType %s called %s - is parametrized",
                declaredFieldName,
                type.getTypeName())
            );
        } else {
            System.out.println(String.format(
                "\nType %s called %s - is row type",
                declaredFieldName,
                type.getTypeName())
            );
        }
    }

}
