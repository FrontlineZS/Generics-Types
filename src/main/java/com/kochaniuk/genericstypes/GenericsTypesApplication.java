package com.kochaniuk.genericstypes;

import com.kochaniuk.genericstypes.interfaces.FirstInterface;
import com.kochaniuk.genericstypes.interfaces.SecondInterface;

public class GenericsTypesApplication implements FirstInterface<String>, SecondInterface<Number> {

	public static void main(String[] args) {
    }

	@Override
	public void someMethod(String argument) {
	}

	@Override
	public void someMethod(Number argument) {
	}

	/*
		unfortunately, in this case compiler informs both interfaces generate an identical method after erasing the types
		it looks like:

		---
		public class GenericsTypesApplication implements FirstInterface, SecondInterface {
		---

		---
		@Override
		public void someMethod(Object argument) {
		---

		---
		@Override
		public void someMethod(Object argument) {
		---

		now we go different interfaces but methods are identically which is not acceptable

		the solution is to check at least one interface, and set the limit for the parametric type

		e.g:
		---
		public interface FirstInterface<E>
		---
		to
		---
		public interface FirstInterface<E extends String> or public interface FirstInterface<E extends Comparable<E>>
		---

		now there are no two methods with an identical prototype
	 */
}
