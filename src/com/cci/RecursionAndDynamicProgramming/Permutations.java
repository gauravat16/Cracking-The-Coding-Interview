package com.cci.RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class Permutations {

    public static void main(String[] args) {

        System.out.println(getPermutations("abcd", 0));


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
            for (int i = 0; i < p.length() +1; i++) {
                if (i == 0) {
                    tempList.add(s.charAt(index) + p);

                } else if (i > p.length()) {
                    tempList.add(p + s.charAt(index));

                } else {
                    tempList.add(p.substring(0, i - 1) + s.charAt(index) + p.substring(i, p.length()));

                }
            }
        }
        permutations = tempList;

        permutations.addAll(tempList);
        return permutations;
    }
}
