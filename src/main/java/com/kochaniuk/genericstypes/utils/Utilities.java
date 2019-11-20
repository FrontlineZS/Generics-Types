package com.kochaniuk.genericstypes.utils;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class Utilities {

    public static List<Integer> getIntegersList() {
        return new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
            }
        };
    }

    public static List<Float> getFloatsList() {
        return new ArrayList<Float>() {
            {
                add(1F);
                add(2F);
                add(3F);
                add(4F);
                add(5F);
            }
        };
    }

    public static List<Number> getNumbersList() {
        return new ArrayList<Number>() {
            {
                add(1);
                add(2D);
                add(3F);
                add(4L);
                add(5);
            }
        };
    }

    public static List<String> getStringsList() {
        return new ArrayList<String>() {
            {
                add("one");
                add("two");
                add("three");
                add("four");
                add("five");
            }
        };
    }

}
