package com.kochaniuk.genericstypes;

import java.util.ArrayList;
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

    private static <T> void print(T object) {
        System.out.println(object);
    }

    private static <T> void reverse(List<T> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            T element = list.get(i);

            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, element);
        }
    }

    private static <T extends Number> double sumOfTheFirst(List<T> first, List<T> second) {
        return first.get(0).doubleValue() +
            second.get(0).doubleValue();
    }

    public static void main(String[] args) {
        List<Integer> integerList = Utilities.getIntegersList();

        System.out.println(
            countSum(integerList)
        );

        System.out.println(
            middleOne(integerList)
        );

        print("\nstring");
        print(5);
        print(null);
        print(new ArrayList<>());

        print("\n" + integerList);
        reverse(integerList);
        print(integerList);

        print("\n" + sumOfTheFirst(Utilities.getNumbersList(), new ArrayList<Number>() {{
            add(100);
            add(1);
        }}));
    }

}
