package com.cci.Sorting.basics;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    private static int partition(List<Integer> list, int left, int right) {

        int pivot = list.get(right);
        int j = left-1;
        int i = left;
        for (;i < right; i++) {
            if (list.get(i) <= pivot) {
                j++;

                swapAtPos(i,j,list);

            }
        }

        swapAtPos(right,j+1,list);
        return j+1;
    }

    private static void  swapAtPos(int i, int j, List<Integer> list) {
        if(i >=list.size() || j>=list.size()){
            return;
        }
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static List<Integer> quickSort(List<Integer> list, int left, int right){
        if(left<right){
            int pivot = partition(list,left,right);
            quickSort(list,left,pivot-1);
            quickSort(list,pivot+1,right);

        }

        return list;
    }

    public static List<Integer> quickSort(List<Integer> list){
        return quickSort(list,0,list.size()-1);
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



        System.out.println(quickSort(list));

    }
}
