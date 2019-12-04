package com.kochaniuk.genericstypes.interfaces;

public interface FirstInterface<E extends Comparable<E>> {
    void someMethod(E argument);
}
