package com.cci.Sorting.questions;

public class Q3 {

    static boolean modifiedBinarySearch(int[] arr, int left, int right, int toSearch) {

        if (left < right) {
            int middle = (left + right) / 2;

            if (arr[middle] == toSearch) {
                return true;
            }

            if (arr[middle] < arr[right] && arr[right] > toSearch) {
                return modifiedBinarySearch(arr, middle + 1, right, toSearch);
            } else {
                return modifiedBinarySearch(arr, left, middle, toSearch);
            }
        } else {
            return false;

        }


    }


    public static void main(String[] args) {
        int[] a = {7, 8, 9, 10, 1, 2, 3, 4, 5, 6};
        System.out.println(modifiedBinarySearch(a, 0, a.length - 1, 8));

    }
}
