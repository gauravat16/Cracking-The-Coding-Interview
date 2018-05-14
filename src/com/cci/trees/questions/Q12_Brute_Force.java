package com.cci.trees.questions;

import com.cci.trees.implemenation.Node;

public class Q12_Brute_Force {

    static int getPathCount(int targetSum, Node root) {

        if (root == null) {
            return 0;
        }

        int pathCountRoot = getPathCountForNode(targetSum, 0, root);

        int leftCount = getPathCount(targetSum, root.getlChild());
        int rightCount = getPathCount(targetSum, root.getrChild());


        return pathCountRoot + leftCount + rightCount;
    }


    static int getPathCountForNode(int targetSum, int currSum, Node root) {

        if (root == null) {
            return 0;
        }

        int totalCount = 0;
        currSum += root.getData();
        if (targetSum == currSum) {
            totalCount++;
        }

        totalCount += getPathCountForNode(targetSum, currSum, root.getlChild());
        totalCount += getPathCountForNode(targetSum, currSum, root.getrChild());

        return totalCount;

    }

    public static void main(String[] args) {
        Node root = new Node(12);
        root.setlChild(new Node(-7));
        root.setrChild(new Node(-5));
        root.getlChild().setlChild(new Node(9));
        root.getlChild().setrChild(new Node(4));
        root.getrChild().setrChild(new Node(3));
        root.getrChild().setlChild(new Node(2));

        System.out.println(getPathCount(9,root));
    }
}