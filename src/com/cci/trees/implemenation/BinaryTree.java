package com.cci.trees.implemenation;

public class BinaryTree implements ITree {

    private boolean isBalanced;

    private Node root;

    public BinaryTree(boolean isBalanced) {
        this.isBalanced = isBalanced;
    }

    @Override
    public boolean insert(Integer data, Node node) {

        return false;
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
    public boolean insert(Integer data) {
        if (root == null) {
            root = new Node(data);
            root.setData(data);
            root.setParent(null);
            return true;
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
}
