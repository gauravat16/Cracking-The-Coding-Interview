package com.cci.trees.questions;

import com.cci.trees.implemenation.BinarySearchTree;
import com.cci.trees.implemenation.ITree;
import com.cci.trees.implemenation.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q3 {

    static List<LinkedList<Node>> makeDepthLinkedList(ITree tree) {

        List<LinkedList<Node>> result = new ArrayList<>();

        LinkedList<Node> current = new LinkedList<>();

        if (null != tree.getRoot()) {
            current.add(tree.getRoot());
        }


        while (current.size() > 0) {
            result.add(current);
            LinkedList<Node> parents = current;
            current = new LinkedList<>();
            for (Node parent : parents) {
                if (null != parent.getlChild()) {
                    current.add(parent.getlChild());
                }

                if (null != parent.getrChild()) {
                    current.add(parent.getrChild());

                }
            }
        }

        return result;
    }


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

        System.out.println(makeDepthLinkedList(binaryTree));

    }

}
