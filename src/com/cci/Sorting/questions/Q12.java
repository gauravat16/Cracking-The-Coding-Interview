package com.cci.Sorting.questions;

import java.util.Arrays;

public class Q12 {

    public static Integer[] peaksAndValleySort(Integer[] intArr) {
        for (int i = 1; i < intArr.length; i = i + 2) {
            int maxIndex = getIndexWLargestValue(intArr, i - 1, i, i + 1);
            swap(intArr, i, maxIndex);
        }

        return intArr;

    }

    static int getIndexWLargestValue(Integer[] intArr, int a, int b, int c) {

        int aVal = (a < intArr.length && a >= 0) ? intArr[a] : Integer.MIN_VALUE;
        int bVal = (b < intArr.length && b >= 0) ? intArr[b] : Integer.MIN_VALUE;
        int cVal = (c < intArr.length && c >= 0) ? intArr[c] : Integer.MIN_VALUE;

        int max = Math.max(aVal, Math.max(bVal, cVal));

        if (max == aVal) {
            return a;
        } else if (max == bVal) {
            return b;
        } else {
            return c;
        }

    }

    static void swap(Integer[] ints, int a, int b) {
        int temp = ints[a];
        ints[a] = ints[b];
        ints[b] = temp;
    }

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{5, 3, 1, 2, 3};
        System.out.println(Arrays.deepToString(ints));
        System.out.println(Arrays.deepToString(peaksAndValleySort(ints)));

    }
}
