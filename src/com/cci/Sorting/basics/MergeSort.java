package com.cci.Sorting.basics;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {


    static void merge(List<Integer> list, int left, int right, int middle) {

        List<Integer> temp_left = new ArrayList<>();
        List<Integer> temp_right = new ArrayList<>();

        int lSize = middle - left + 1;
        int rSize = right - middle;

        for (int i = 0; i < lSize; i++) {
            temp_left.add(i, list.get(left + i));
        }

        for (int i = 0; i < rSize; i++) {
            temp_right.add(i, list.get(middle+1+ i));
        }

        int i = 0, j = 0, k = left;

        while (i < lSize && j < rSize) {

            if (temp_left.get(i) <= temp_right.get(j)) {
                list.set(k, temp_left.get(i));
                i++;
            } else {
                list.set(k, temp_right.get(j));
                j++;
            }
            k++;

        }

        while (i < lSize) {
            list.set(k, temp_left.get(i));
            i++;
            k++;

        }
        while (j < rSize) {
            list.set(k, temp_right.get(j));
            j++;
            k++;

        }


    }

    static void mergeSort(List<Integer> list, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(list, left, middle);
            mergeSort(list, middle + 1, right);
            merge(list, left, right, middle);
        }
    }

    static void mergeSort(List<Integer> list){
        mergeSort(list,0,list.size()-1);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(13);
        list.add(19);
        list.add(9);
        list.add(5);
        list.add(12);
        list.add(8);
        list.add(7);
        list.add(4);
        list.add(21);
        list.add(2);
        list.add(6);
        list.add(11);


        mergeSort(list);
        System.out.println(list);

    }
}
