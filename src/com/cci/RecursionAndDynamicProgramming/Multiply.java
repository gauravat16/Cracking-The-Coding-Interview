package com.cci.RecursionAndDynamicProgramming;

public class Multiply {


    public static void main(String[] args) {

        System.out.println(multiplyNums(999999, 8769687, 0));


    }


    static int multiplyNums(int a, int b, int sum) {

        if (b == 0) {
            return sum;
        }

        sum += a;

        return multiplyNums(a, b - 1, sum);
    }
}
