package com.kochaniuk.genericstypes;

import java.util.List;

public class GenericsTypesApplication {
    private static final String PRINT_FORMAT = "Class: %s, value: %s";

    // if getListSize would be List<? super Integer>
    //
    // then we can invokes getListSize with:
    // getListSize( List<Integer> )
    // getListSize( List<Number> )
    // getListSize( List<Object> )
    //
    // in this case when we gets element
    // required type reference is Object
    private static int getListSize(List<? extends Number> list) {
        Number n = list.get(0);
        Double d = (Double) list.get(1);
        Float f = (Float) list.get(2);

        System.out.println(String.format(PRINT_FORMAT, n.getClass(), n));
        System.out.println(String.format(PRINT_FORMAT, d.getClass(), d));
        System.out.println(String.format(PRINT_FORMAT, f.getClass(), f));

        return list.size();
    }

    public static void main(String[] args) {
        List<Number> numberList = Utilities.getNumbersList();

        // GenericsTypesApplication::getListSize expect List with Number reference type
        // or inherits from Number, e.g. Integer, Float, Double, Long
//        System.out.println(getListSize(stringList);

        System.out.println(
            getListSize(numberList)
        );

    }

}
