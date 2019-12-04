package com.kochaniuk.genericstypes.classes;

public class Animal implements Comparable<Animal> {
    private final Integer pawSize;

    public Animal(Integer pawSize) {
        this.pawSize = pawSize;
    }

    @Override
    public int compareTo(Animal o) {
        return pawSize.compareTo(o.pawSize);
    }

}
