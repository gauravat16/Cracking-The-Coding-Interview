package com.cci.RecursionAndDynamicProgramming;

import java.util.Scanner;

public class Steps {
    static int[] cache;

    static int stepCounter(int totalSteps) {

        if (totalSteps < 0)
            return 0;
        if (totalSteps == 0)
            return 1;
        if (cache[totalSteps] == 0) {
            cache[totalSteps] = stepCounter(totalSteps - 1) + stepCounter(totalSteps - 2) + stepCounter(totalSteps - 3);

        }
        return cache[totalSteps];
    }


    public static void main(String[] args) {
        int n = 0;

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        cache = new int[n + 1];

        stepCounter(n);
        for (int i : cache) {
            System.out.println(i);
        }


    }
}
