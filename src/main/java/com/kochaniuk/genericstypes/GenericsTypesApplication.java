package com.kochaniuk.genericstypes;

import java.util.List;

public class GenericsTypesApplication<E> {

    // ## CLASS CONTEXT ##
    // can be used in every non-static construction
    // * non-static methods
    // * non-static initializers
    // * nested classes
    private E first = null;
    public E second = null;

    public E method(E argument) {
        return argument;
    }

    {
        E temporary = null;
    }

    protected class NestedClass {
        private E first = null;
        public E second = null;
        protected E third = null;

        public E method(E argument) {
            return argument;
        }
    }

    // ## METHOD CONTEXT ##
    // visibility of parametrized type in entire block of method
    // regardless of whether the method is static or not
    // same in nested classes defined within the method
    public static <T> T staticMethod(T argument) {
        List<T> list = null;
        T temporary = null;

        class NestedClass {
            List<T> list = null;
            T temporary = null;

            public void method(T arg) {
            }
        }

        return argument;
    }

    public <T> T nonStaticMethod(T argument) {
        List<T> list = null;
        T temporary = null;

        class NestedClass {
            List<T> list = null;
            T temporary = null;

            public void test(T arg) {
            }
        }

        return argument;
    }

    // When type parameters can not occur
    public static E staticField = null;

    static {
        E temporary = null;
    }

    private static E invalidMethod(E argument) {
        return argument;
    }

    static class StaticNestedClass {
        public E field = null;
    }

    enum SomeEnum {
        ONE, TWO;

        public void checkSomething(E element) {
        }
    }

    public interface NestedInterface {
        void interfaceMethod(E argument);
    }

    public static void main(String[] args) {
    }
}
