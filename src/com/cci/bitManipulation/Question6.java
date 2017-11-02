package com.cci.bitManipulation;

public class Question6 {

    static int swap(int a){
        return (((a & 0xaaaaaaaa )>>>1)| ((a & 0x55555555)<<1));
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(swap(5)));
    }
}
