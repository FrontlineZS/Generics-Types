package com.kochaniuk.genericstypes;

import java.util.List;

public class GenericsTypesApplication {

    private static int getListSize(List<?> list) {
        // By default getting element without casting mechanism
        // requires Object type
        Object o = list.get(0);

        // However we can try to cast element on any reference type
        // but compiler can not guarantee casting will run without throwing ClassCastException
        Number n = (Number) list.get(1);

        // We can not add any element to list marked with wildcard
//        list.add(2F);
//        list.add("string");

        // the only one exception in adding null
        list.add(null);

        return list.size();
    }

    public static void main(String[] args) {
        List<Integer> integerList = Utilities.getIntegersList();
        List<Float> floatList = Utilities.getFloatsList();

        System.out.println(getListSize(
            integerList
        ));
        System.out.println(getListSize(
            floatList
        ));


    }

}
