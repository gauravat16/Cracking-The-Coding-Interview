package com.cci.Sorting.questions;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Q8 {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(2);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        integers.add(9);
        integers.add(10);
        integers.add(12);
        integers.add(13);
        integers.add(14);
        integers.add(15);
        integers.add(1);
        integers.add(10);

        printDuplicates(integers);
    }


    static void printDuplicates(List<Integer> data) {
        //Size 4KB
        BitSet bitSet = new BitSet(data.size());
        for (int i = 0; i < data.size(); i++) {

            if (bitSet.get(data.get(i))) {
                System.out.println(data.get(i));
            } else {
                bitSet.set(data.get(i));
            }

        }


    }
}
