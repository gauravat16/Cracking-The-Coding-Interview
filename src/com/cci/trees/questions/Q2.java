package com.cci.trees.questions;

import com.cci.trees.implemenation.BinarySearchTree;
import com.cci.trees.implemenation.ITree;
import com.cci.trees.implemenation.Node;

public class Q2 {


    static Node makeTree(Node node, Integer[] intArr, int start, int end, BinarySearchTree binarySearchTree) {

        if (start > end) {
            return null;
        }

        int midIndex = (start + end) / 2;

        if (midIndex >= intArr.length) {
            return null;
        }
        int midVal = intArr[midIndex];

        if (null == binarySearchTree.getRoot()) {
            binarySearchTree.setRoot(new Node(midVal));
            node = binarySearchTree.getRoot();
        } else {
            node = new Node(midVal);
        }

        node.setlChild(makeTree(node, intArr, start, midIndex - 1, binarySearchTree));
        node.setrChild(makeTree(node, intArr, midIndex + 1, end, binarySearchTree));

        return node;


    }

    public static void main(String[] args) {
        Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8};

        BinarySearchTree tree = new BinarySearchTree();

        makeTree(null, data, 0, data.length, tree);

        System.out.println(tree.traverseTree(ITree.IN_ORDER));
    }
}
