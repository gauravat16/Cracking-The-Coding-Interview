package com.cci.trees.questions;

import com.cci.trees.implemenation.BinarySearchTree;
import com.cci.trees.implemenation.ITree;
import com.cci.trees.implemenation.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q8 {


    public static void main(String[] args) {
        ITree binaryTree = new BinarySearchTree();
        binaryTree.insert(22);
        binaryTree.insert(2);
        binaryTree.insert(32);
        Node n2 = binaryTree.insert(12);
        Node n1 =binaryTree.insert(21);
        binaryTree.insert(98);
        binaryTree.insert(2);
         binaryTree.insert(32);
        binaryTree.insert(42);
        binaryTree.insert(52);

        System.out.println(getCommonAncestor(binaryTree.getRoot(), n1, n2));

    }


    static public Node getCommonAncestor(Node root, Node n1, Node n2) {
        if (root.equals(n1) || root.equals(n2)) {
            return null;
        }

        Stack<Node> nodeQueueLeft = new Stack<>();
        Stack<Node> nodeQueueRight = new Stack<>();
        nodeQueueLeft.add(root);
        nodeQueueRight.add(root);

        getCommonPaths(root.getlChild(), n1, n2, nodeQueueLeft);
        getCommonPaths(root.getrChild(), n1, n2, nodeQueueRight);

        Node lastCommon = null;
        while (nodeQueueLeft.size() > 0 || nodeQueueRight.size() > 0) {
            Node right, left;

            right = nodeQueueRight.pop();
            left = nodeQueueLeft.pop();

            if (right.equals(left)) {
                lastCommon = right;
            } else {
                continue;
            }


        }

        return lastCommon;

    }


    public static Stack<Node> getCommonPaths(Node root, Node n1, Node n2, Stack<Node> nodeQueue) {

        if (null == root) {

            return nodeQueue;
        }


        nodeQueue.add(root);

        if (!(hasNode(root.getlChild(), n1) || hasNode(root.getrChild(), n1) || hasNode(root.getlChild(), n2) || hasNode(root.getrChild(), n2))) {

            nodeQueue.pop();
        }

        nodeQueue = getCommonPaths(root.getlChild(), n1, n2, nodeQueue);

        nodeQueue = getCommonPaths(root.getrChild(), n1, n2, nodeQueue);

        return nodeQueue;
    }


    static boolean hasNode(Node root, Node node) {
        if (root == null) {
            return false;
        }

        if (root == node) {
            return true;
        }

        return hasNode(root.getlChild(), node) || hasNode(root.getrChild(), node);
    }
}
