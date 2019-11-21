package com.kochaniuk.genericstypes;

import com.kochaniuk.genericstypes.componnets.Chunk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericsTypesApplication {

	private static void dangerousListModification(List list) {
		list.add("another string");
		list.add(5);
	}

    public static void main(String[] args) {
    	/*
    	 * Mechanism of types erasing cause of
    	 * maintaining backward compatibility
    	 */
    	List<String> genericCollection = new ArrayList<>();
		// verified collection to get information about wrong element
		// good to use in debugging not as something common
//		genericCollection = Collections.checkedList(new ArrayList<>(), String.class);

    	genericCollection.add("string");
    	dangerousListModification(genericCollection);

    	// print
    	for (String s : genericCollection) {
			System.out.println(s);
		}

    	// interface Comparable
		Chunk chunk1 = new Chunk(3);
		Chunk chunk2 = new Chunk(5);

		System.out.println(chunk1);
		System.out.println(chunk2);

		System.out.println(chunk1.compareTo(chunk2));

		Comparable<Chunk> chunkComparable1 = new Chunk(15);
		Comparable chunkComparable2 = new Chunk(15);
		String chunk3 = "stringChunk";

		System.out.println(chunkComparable1.compareTo(chunk3));
		System.out.println(chunkComparable2.compareTo(chunk3));
    }

}
