package com.kochaniuk.genericstypes;

import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;

public class GenericsTypesApplication {

    private static ArrayList<String> nonGenericMethodCreatingArrayList() {
        return new ArrayList<>();
    }

    /*
    	Ad. #1 __
    	it is not optimal because it must have an object of this type
    	in addition, casting is necessary
     */
    @SuppressWarnings("unchecked")
    private static <T> T methodCreatingCustomObjectFromExistingOne(T existingObject) throws IllegalAccessException, InstantiationException {
        return (T) existingObject.getClass().newInstance();
    }

    /*
        Ad. #3 __
        here we pass object Class
        in addition, casting is unnecessary
     */
    private static <T> T methodCreatingCustomObjectFromClassTypeInformation(Class<T> type) throws IllegalAccessException, InstantiationException {
        return type.newInstance();
    }

	/**
	 *
	 * @param type
	 * @param object
	 * @param <T>
	 * @return {@see null} if could not cast object
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	/*
        Ad. #3 __
        here we pass object Class and some Object
        in addition, casting is unnecessary
     */
    private static <T> T methodCreatingCustomObjectFromClassTypeInformationAndObject(Class<T> type, Object object) throws IllegalAccessException, InstantiationException {
        // if (object instanceof T) {} cannot use this so other way:

        if (type.isInstance(object)) {
            return type.cast(object);
        }

        return null;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ArrayList<String> strings = nonGenericMethodCreatingArrayList();

        /*
        	ArrayList<Number> numbers = nonGenericMethodCreatingArrayList();
        	String object = nonGenericMethodCreatingArrayList();

        	it would be great if you could create any parameterization for the ArrayList class

        	for e.g.

			private static <T> T genericMethodCreatingArrayList() {
				return new T();  UNFORTUNATELY __ we cannot create new instance using 'new' keyword if the parameter is type parameter ( T )
			}

			but there are so other ways to do this:

			1. we can pass the final object of the expected type, but this is a waste because it is not used anywhere
			2. an alternative is to pass an array built with elements of this type and a similar situation because we don't need de facto objects, only type information
			3. it seems the most sensible to use a Class object parameterized by some type. It is generic type introduced in Java 5
         */

        ArrayList<String> strings2 = methodCreatingCustomObjectFromExistingOne(new ArrayList<>());
        ArrayList<Number> numbers = methodCreatingCustomObjectFromExistingOne(new ArrayList<>());
        String string = methodCreatingCustomObjectFromExistingOne(Strings.EMPTY);
        String string2 = methodCreatingCustomObjectFromExistingOne("Some string");

        /*
        	Ad. #3 examples
         */
        ArrayList<String> stringsFromClassType = methodCreatingCustomObjectFromClassTypeInformation(ArrayList.class);
        ArrayList<Number> numbersFromClassType = methodCreatingCustomObjectFromClassTypeInformation(ArrayList.class);
        String stringFromClassType = methodCreatingCustomObjectFromClassTypeInformation(String.class);

		/*
			instanceof do not work well with generics types __ actually is worthless
		 */
		ArrayList<String> stringsFromClassTypeAndObject = methodCreatingCustomObjectFromClassTypeInformationAndObject(ArrayList.class, new Object());
		ArrayList<Number> numbersFromClassTypeAndObject = methodCreatingCustomObjectFromClassTypeInformationAndObject(ArrayList.class, new Object());
		String stringFromClassTypeAndObject = methodCreatingCustomObjectFromClassTypeInformationAndObject(String.class, new Object());
    }

}
