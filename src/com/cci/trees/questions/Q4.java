package com.cci.trees.questions;

import com.cci.trees.implemenation.BinarySearchTree;
import com.cci.trees.implemenation.ITree;
import com.cci.trees.implemenation.Node;

public class Q4 {


    public static void main(String[] args) {
        ITree binaryTree = new BinarySearchTree();
        binaryTree.insert(22);
        binaryTree.insert(2);
        binaryTree.insert(32);
        binaryTree.insert(12);
        binaryTree.insert(21);
        binaryTree.insert(98);
        binaryTree.insert(2);
        binaryTree.insert(32);
        binaryTree.insert(42);
        binaryTree.insert(52);

        System.out.println(isBalanced(binaryTree));
    }


    static int getHeight(Node node) {

        if (null == node) {
            return -1;
        }

        int lHeight = getHeight(node.getlChild());
        if (lHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        int rHeight = getHeight(node.getrChild());
        if (rHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if (Math.abs(lHeight - rHeight) > 0) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(getHeight(node.getlChild()), getHeight(node.getrChild())) + 1;
        }


    }

    static boolean isBalanced(ITree tree) {
        return getHeight(tree.getRoot())!=Integer.MIN_VALUE;

    }
}
