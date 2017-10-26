package com.cci.bitManipulation;

/**
 * Created by gaurav on 26/10/17.
 */
public class Question1 {

    public static void main(String[] args) {
        int N=195;
        int M=5;
        int i =2;
        int j =4;
        int allOnes=~0;

        //Create right side mask after j
        int rMask= allOnes << j+1;

        //Create left side mask; before i
        int lMask= ((1<<i)-1);

        //Merge Masks
        int mask=lMask|rMask;

        int insertedNumber = (N & mask) | (M<<i);
        System.out.println(Integer.toBinaryString(N));
        System.out.println(Integer.toBinaryString(M));

        System.out.println(Integer.toBinaryString(insertedNumber));

    }
}
