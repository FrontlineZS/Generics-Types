package com.kochaniuk.genericstypes;

import com.kochaniuk.genericstypes.interfaces.ExampleInterface;

public class GenericsTypesApplication implements ExampleInterface<String>, ExampleInterface<Number> {

    public static void main(String[] args) {
    }

    @Override
    public void someMethod(String argument) {

    }

    @Override
    public void someMethod(Number argument) {

    }

/*
	 duplicated class 'com.kochaniuk.genericstypes.interfaces.ExampleInterface.java'
     can not implement twice the same generic interfaces even with different parametrized types

     why ?

     the reason is the type erasure mechanism
     at compile time, type arguments will be removed to:

     ---
     public class GenericsTypesApplication implements ExampleInterface, ExampleInterface
	 ---

     and additionally type argument placed in methods also:

     ---
	 @Override
     public void someMethod(Object argument) {

     @Override
     public void someMethod(Object argument) {
     ---

	 as a result, the class implements two methods with the same signature
 */
}
