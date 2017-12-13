package com.cci.RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;

public class Permutations {

    public static void main(String[] args) {

        ArrayList<String> data = getPermutations("abcd", 0);
        System.out.println(data);


    }

    static ArrayList<String> getPermutations(String s, int index) {

        if (index == s.length() - 1) {
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(String.valueOf(s.charAt(index)));
            return temp;
        }

        ArrayList<String> permutations = getPermutations(s, index + 1);
        ArrayList<String> tempList = new ArrayList<>();


        for (String p : permutations) {
            for (int i = 0; i < p.length() + 1; i++) {
                if (i == 0) {
                    tempList.add(s.charAt(index) + p);

                } else if (i >= p.length()) {
                    tempList.add(p + s.charAt(index));

                } else {
                    tempList.add(p.substring(0, i) + s.charAt(index) + p.substring(i, p.length()));

                }
            }
        }
        permutations = tempList;

        return permutations;
    }
}
