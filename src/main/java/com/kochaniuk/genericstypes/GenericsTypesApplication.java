package com.kochaniuk.genericstypes;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenericsTypesApplication {
    private static <T> void print(T argument) {
        System.out.println(argument);
    }

    public static void main(String[] args) {
        print("string");
        print(5);
//        this.<String>print("string"); requires main non-static

        List<List<?>> heterogeneousList = new ArrayList<>();
        heterogeneousList.add(new ArrayList<String>());
        heterogeneousList.add(new LinkedList<Integer>());
        heterogeneousList.add(new ArrayQueue<>(3));

        List<? extends List<?>> list = new ArrayList<>();
        list = new ArrayList<List<String>>();
        list = new ArrayList<List<Number>>();

        List<List<?>> referencja1;
        List<? extends List<?>> referencja2;

        referencja1 = heterogeneousList;
        referencja1 = list;

        referencja2 = heterogeneousList;
        referencja2 = list;
    }


}
