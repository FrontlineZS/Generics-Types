package com.kochaniuk.genericstypes.components;

import java.util.ArrayList;

public class Extender<T> extends ArrayList<T> {

    public void extension() {
        System.out.println("Extending functionality any class");
    }
}
