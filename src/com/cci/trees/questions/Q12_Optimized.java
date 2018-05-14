package com.cci.trees.questions;

import com.cci.trees.implemenation.Node;

import java.util.HashMap;

public class Q12_Optimized {

    static int getPathCount(int targetSum, Node root) {
        return getPathCount(targetSum, 0, root, new HashMap<Integer, Integer>());

    }


    static int getPathCount(int targetSum, int runnnigSum, Node root, HashMap<Integer, Integer> pathMap) {

        if (root == null) {
            return 0;
        }

        runnnigSum += root.getData();
        int sum = runnnigSum - targetSum;
        int totalCount = pathMap.getOrDefault(sum, 0);

        if (runnnigSum == targetSum) {
            totalCount++;
        }

        incrementHashMap(pathMap, runnnigSum, 1);
        totalCount += getPathCount(targetSum,runnnigSum, root.getlChild(),pathMap);
        totalCount += getPathCount(targetSum,runnnigSum, root.getrChild(),pathMap);

        incrementHashMap(pathMap, runnnigSum, -1);

        return totalCount;
    }


    static void incrementHashMap(HashMap<Integer, Integer> pathMap, int key, int delta) {
        int value = pathMap.getOrDefault(key, 0) + delta;

        if (value == 0) {
            pathMap.remove(key);
        } else {
            pathMap.put(key, value);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(12);
        root.setlChild(new Node(-7));
        root.setrChild(new Node(-5));
        root.getlChild().setlChild(new Node(9));
        root.getlChild().setrChild(new Node(4));
        root.getrChild().setrChild(new Node(3));
        root.getrChild().setlChild(new Node(2));

        System.out.println(getPathCount(9, root));
    }

}
