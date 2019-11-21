package com.kochaniuk.genericstypes.componnets;

public class Chunk implements Comparable<Chunk> {
    private final Integer someSize;

    public Chunk(int someSize) {
        this.someSize = someSize;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Some size: " + this.someSize;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(Chunk o) {
        return someSize.compareTo(o.someSize);
    }

}
