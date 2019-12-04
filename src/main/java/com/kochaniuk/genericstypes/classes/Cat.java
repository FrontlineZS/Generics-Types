package com.kochaniuk.genericstypes.classes;

public class Cat extends Animal {
//public class Cat extends Animal implements Comparable<Cat> {
    // can not to redefine the implementation of the same interface in the entire inheritance tree
    private final Integer tailLength;

    public Cat(Integer pawSize, Integer tailLength) {
        super(pawSize);
        this.tailLength = tailLength;
    }

}
