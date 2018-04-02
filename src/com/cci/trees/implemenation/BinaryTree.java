package com.cci.trees.implemenation;

public class BinaryTree implements ITree {

    private boolean isBalanced;

    private Node root;

    public BinaryTree(boolean isBalanced) {
        this.isBalanced = isBalanced;
    }

    @Override
    public Node insert(Integer data, Node node) {

        return null;
    }

    @Override
    public Node depthFirstSearch(Integer data) {
        return null;
    }

    @Override
    public Node breadthFirstSearch(Integer data) {
        return null;
    }

    @Override
    public String traverseTree(int mode) {
        return null;
    }

    @Override
    public Node depthFirstSearch(Integer data, Node Node) {
        return null;
    }

    @Override
    public Node breadthFirstSearch(Integer data, Node node) {
        return null;
    }

    @Override
    public Node search(Integer mode, Integer data) {
        return null;
    }

    @Override
    public Node insert(Integer data) {
        if (root == null) {
            root = new Node(data);
            root.setData(data);
            root.setParent(null);
            return root;
        }

        return insert(data, root);
    }

    @Override
    public boolean remove(Integer data) {
        return false;
    }

    @Override
    public void setRoot(Node root) {

    }

    @Override
    public Node getRoot() {
        return null;
    }

    @Override
    public int getRank(Integer data) {
        return 0;
    }

    @Override
    public int getRank(Integer data, Node node) {
        return 0;
    }

    @Override
    public String preorderTraversal(Node node, String treeData) {
        return null;
    }

    @Override
    public String postorderTraversal(Node node, String treeData) {
        return null;
    }

    @Override
    public String inorderTraversal(Node node, String treeData) {
        return null;
    }

    @Override
    public void addChild(Node root, Node child) {

    }
}
