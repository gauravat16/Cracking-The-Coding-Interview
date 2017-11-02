package com.cci.bitManipulation;

public class Question5 {

    static int bitEnumerator(int num1, int num2) {
        int count = 0;

        int numsXOR = num1 ^ num2;
        while (numsXOR != 0) {
            System.out.println(Integer.toBinaryString(numsXOR));

            numsXOR >>= 1;
            count += numsXOR & 1;
        }

        return count;
    }

    static int bitEnumerator2(int num1, int num2) {
        int count = 0;

        int numsXOR = num1 ^ num2;
        for (; numsXOR != 0; numsXOR &= numsXOR - 1) {
            System.out.println(Integer.toBinaryString(numsXOR));
            System.out.println(Integer.toBinaryString(numsXOR-1));


            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(bitEnumerator(29, 15));
        System.out.println(bitEnumerator2(29, 15));
    }
}
