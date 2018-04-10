package com.cci.trees.questions;

import com.cci.trees.implemenation.BinarySearchTree;
import com.cci.trees.implemenation.ITree;
import com.cci.trees.implemenation.Node;

public class Q5 {

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


        Node root = new Node(2);
        Node n1 = new Node(3);
        Node n2 = new Node(4);
        Node n3 = new Node(5);
        Node n4 = new Node(6);
        Node n5 = new Node(7);
        Node n6 = new Node(8);

        root.setlChild(n1);
        root.setrChild(n2);
        n1.setlChild(n3);
        n1.setrChild(n4);
        n3.setlChild(n5);
        n5.setrChild(n6);


        System.out.println(isBST(binaryTree.getRoot()));
        System.out.println(isBST(root));

    }

    static boolean isBST(Node node) {
        return isBST(node, null, null);
    }


    static boolean isBST(Node node, Integer min, Integer max) {

        if (null == node) {
            return true;
        }

        if ((null != min && node.getData() <= min) || (null != max && node.getData() > max)) {
            return false;
        }

        if (!isBST(node.getlChild(), min, node.getData()) || !isBST(node.getrChild(), node.getData(), max)) {
            return false;
        }

        return true;
    }


}
