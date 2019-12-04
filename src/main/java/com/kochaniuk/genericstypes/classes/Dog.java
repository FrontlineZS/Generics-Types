package com.kochaniuk.genericstypes.classes;

public class Dog extends Animal {
//public class Dog extends Animal implements Comparable<Dog> {
    // can not to redefine the implementation of the same interface in the entire inheritance tree
    private final Integer bristleLength;

    public Dog(Integer pawSize, Integer bristleLength) {
        super(pawSize);
        this.bristleLength = bristleLength;
    }

}
