package com.kochaniuk.genericstypes;

import com.kochaniuk.genericstypes.classes.Cat;
import com.kochaniuk.genericstypes.classes.Dog;

public class GenericsTypesApplication {

    public static void main(String[] args) {
        Cat cat = new Cat(5, 10);
        Dog dog = new Dog(6, 15);

        System.out.println(cat.compareTo(dog));
        System.out.println(dog.compareTo(cat));
    }
}
