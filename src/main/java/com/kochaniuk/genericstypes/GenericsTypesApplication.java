package com.kochaniuk.genericstypes;

import com.kochaniuk.genericstypes.components.PseudoRandomList;

public class GenericsTypesApplication {

    public static void main(String[] args) {
        PseudoRandomList<Integer> integerPseudoRandomList = new PseudoRandomList<>();
        integerPseudoRandomList.add(5);
        integerPseudoRandomList.add(12);
        integerPseudoRandomList.add(2020);

        System.out.println(integerPseudoRandomList.getPseudoRandomElement());

        PseudoRandomList<String> stringPseudoRandomList = new PseudoRandomList<>();
        stringPseudoRandomList.add("string");
        stringPseudoRandomList.add("hello");
        stringPseudoRandomList.add("world");

        System.out.println(stringPseudoRandomList.getPseudoRandomElement());

        stringPseudoRandomList.sort();

        PseudoRandomList<java.sql.Date> datePseudoRandomList = new PseudoRandomList<>();
        datePseudoRandomList.sort();
    }

}
