package com.cci.bitManipulation;

/**
 * Created by gaurav on 25/10/17.
 */
public class BitFunctions {

    static int getBit(int number, int position) {

        boolean isOne = isOne(Integer.toBinaryString(number & (1 << position)));

        if (isOne) {
            return 1;
        } else {
            return 0;
        }

    }

    static int setBit(int number, int position){
        return number | (1<<position);
    }

    static int clearBitAtPositon(int number, int position){
        return number & ~(1<<position);
    }

    static int clearBitsAfterPostion(int number, int position){
        return number&((-1<<position+1));
    }

    static int clearBitsBeforePostion(int number, int position){
        return number&((1<<position) -1);
    }




    static boolean isOne(String binaryString) {
        for (int i = 0; i < binaryString.length(); i++) {
            if (Integer.parseInt(String.valueOf(binaryString.charAt(i))) == 0) {
                return false;

            } else {
                return true;
            }
        }
        return false;
    }



//    public static void main(String[] args) {
//        System.out.println(getBit(5, 2));
//        System.out.println(setBit(5,1));
//        System.out.println(clearBitAtPositon(5,0));
//        System.out.println(clearBitsAfterPostion(5,2));
//        System.out.println(clearBitsBeforePostion(5,1));
//
//    }
}
