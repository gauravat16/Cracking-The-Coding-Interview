package com.cci.trees.questions;

import com.cci.trees.implemenation.BinarySearchTree;
import com.cci.trees.implemenation.ITree;
import com.cci.trees.implemenation.Node;

import java.util.ArrayList;
import java.util.Stack;

public class Q8 {


    public static void main(String[] args) {
        ITree binaryTree = new BinarySearchTree();
        binaryTree.insert(22);
        binaryTree.insert(32);
        binaryTree.insert(31);
        binaryTree.insert(45);
        binaryTree.insert(2);
        binaryTree.insert(12);
        binaryTree.insert(21);
        binaryTree.insert(98);
        Node n2 = binaryTree.insert(42);
        Node n1 = binaryTree.insert(52);

        System.out.println(getCommonAncestor(binaryTree.getRoot(), n1, n2));

    }


    static public Node getCommonAncestor(Node root, Node n1, Node n2) {
        if (root.equals(n1) || root.equals(n2)) {
            return null;
        }

        Stack<Node> nodeStack1 = new Stack<>();
        Stack<Node> nodeStack2 = new Stack<>();

        if (!hasNode(root, n1) || !hasNode(root, n2)) {
            return null;
        }

        boolean n1inLeft = hasNode(root.getlChild(), n1);
        boolean n2inLeft = hasNode(root.getlChild(), n2);

        if (n1inLeft != n2inLeft) {
            return root;
        }

        if (n1inLeft && n2inLeft) {
            getCommonPaths(root.getlChild(), n1, nodeStack1);
            getCommonPaths(root.getlChild(), n2, nodeStack2);

        } else {
            getCommonPaths(root.getrChild(), n1, nodeStack1);
            getCommonPaths(root.getrChild(), n2, nodeStack2);
        }

        Node lastStack1 = null, lastStack2 = null;

        ArrayList<Node> nodes1 = new ArrayList<>(nodeStack1);
        ArrayList<Node> nodes2 = new ArrayList<>(nodeStack2);


        int minSize = (nodes1.size() <= nodes2.size()) ? nodes1.size() : nodes2.size();

        Node commonTillNow = null;
        for (int i = 0; i < minSize; i++) {
            if (nodes1.get(i).equals(nodes2.get(i))) {
                commonTillNow = nodes1.get(i);
            }
        }


        return commonTillNow;


    }


    public static Stack<Node> getCommonPaths(Node root, Node n, Stack<Node> nodeStack) {

        if (null == root) {

            return nodeStack;
        }


        nodeStack.add(root);

        if (root.equals(n)) {
            return nodeStack;
        }

        if (!(hasNode(root.getlChild(), n) || hasNode(root.getrChild(), n))) {

            nodeStack.pop();
        }

        nodeStack = getCommonPaths(root.getlChild(), n, nodeStack);

        nodeStack = getCommonPaths(root.getrChild(), n, nodeStack);

        return nodeStack;
    }


    static boolean hasNode(Node root, Node node) {
        if (root == null) {
            return false;
        }

        if (root.equals(node)) {
            return true;
        }

        return hasNode(root.getlChild(), node) || hasNode(root.getrChild(), node);
    }
}
