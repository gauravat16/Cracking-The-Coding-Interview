package com.cci.RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class Subsets {

    public static void main(String[] args) {
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(8);
        testList.add(3);
        testList.add(4);

        System.out.println(getSubsets(testList, 0));


    }


    static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {

        ArrayList<ArrayList<Integer>> allSubsets;

        if (set.size() == index) {
            allSubsets = new ArrayList<>();
            allSubsets.add(new ArrayList<Integer>());
        } else {
            allSubsets = getSubsets(set, index + 1);
            Integer item = set.get(index);
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
            for (ArrayList<Integer> subset : allSubsets) {
                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            allSubsets.addAll(moreSubsets);
        }

        return allSubsets;

    }
}
