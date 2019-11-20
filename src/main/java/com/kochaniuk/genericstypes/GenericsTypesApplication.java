package com.kochaniuk.genericstypes;

import java.util.List;

public class GenericsTypesApplication {

    private static double countSum(List<Integer> list) {
        int sum = 0;

        for (int element : list) {
            sum += element;
        }

        return sum;
    }

    // returns Object cause of wildcard as List type reference
    private static Object middleOne(List<?> list) {
        if (list.size() > 0) {
            return list.get(list.size() / 2);
        }

        return null;
    }

    public static void main(String[] args) {
        List<Integer> integerList = Utilities.getIntegersList();

        System.out.println(
            countSum(integerList)
        );

        System.out.println(
            middleOne(integerList)
        );
    }

}
