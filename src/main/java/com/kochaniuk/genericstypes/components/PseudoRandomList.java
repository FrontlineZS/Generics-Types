package com.kochaniuk.genericstypes.components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PseudoRandomList<T extends Comparable<? super T>> {
    private List<T> list = new ArrayList<>();
    private Random rand = new Random();

    public void add(T element) {
        list.add(element);
    }

    public T getPseudoRandomElement() {
        return list.get(
            rand.nextInt(list.size())
        );
    }

    public void sort() {
        Collections.sort(list);
    }

}
