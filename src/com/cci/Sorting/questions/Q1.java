package com.cci.Sorting.questions;

import java.util.Arrays;

public class Q1 {

    static Integer[] mergeArrays(Integer[] a, Integer[] b, int lastA, int lastB){
        int indexA = lastA-1;
        int indexB = lastB-1;
        int mergedArrIndex = lastA+lastB-1;

        while (indexB>=0){

            if(indexA>=0 && a[indexA]>b[indexB]){
                a[mergedArrIndex]=a[indexA];
                indexA--;
            }else {
                a[mergedArrIndex]=b[indexB];
                indexB--;

            }

            mergedArrIndex--;
        }

        return a;

    }

    public static void main(String[] args) {
        Integer[] a = {1,4,9,15,17,0,0,0,0};
        Integer[] b = {2,7,8,10};
        System.out.println(Arrays.deepToString(mergeArrays(a,b,5,4)));
    }
}
