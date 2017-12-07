package com.cci.RecursionAndDynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MagicIndex {


    public static void main(String[] args) {

        int[] arr = {1,3,1,2,3,4,6,7,8,9};
        System.out.println( hasMagicIndex(arr,arr.length/2));

    }

    static boolean hasMagicIndex(int[] array, int pivot){
        pivot= array.length/2;



        if(array.length == 0){
            return false;
        }

        if(array[pivot]==pivot){
            return true;
        }else if(pivot==0){
            return false;
        }


        return (hasMagicIndex(Arrays.copyOfRange(array,0,pivot),pivot) || hasMagicIndex(Arrays.copyOfRange(array,pivot+1,array.length),pivot));
    }
}
