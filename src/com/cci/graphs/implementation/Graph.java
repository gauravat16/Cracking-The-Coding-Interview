package com.cci.graphs.implementation;

import com.cci.trees.implemenation.Node;

public class Graph implements IGraph {

    private Node root;

    @Override
    public Node insert(Integer data, Node childNode) {

        Node nNode = new Node(data);
        nNode.getChilderen().add(childNode);

        if (null == getRoot()) {
            setRoot(nNode);
        }
        return nNode;
    }

    @Override
    public Node insert(Integer data) {
        Node nNode = new Node(data);

        if (null == getRoot()) {
            setRoot(nNode);
        }
        return nNode;
    }

    @Override
    public boolean remove(Integer data) {
        return false;
    }

    @Override
    public Node getRoot() {
        return root;
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
    public void setRoot(Node root) {
        this.root = root;
    }

    @Override
    public Node depthFirstSearch(Integer data) {
        if (null == getRoot()) {
            return null;
        } else {
            return depthFirstSearch(data, getRoot());
        }
    }

    @Override
    public Node breadthFirstSearch(Integer data) {
        return null;
    }

    @Override
    public Node depthFirstSearch(Integer data, Node node) {
        if (null == node) {
            return null;
        }

        node.setVisited(true);

        if (node.getData().equals(data)) {
            return node;
        }
        Node resNode = null;
        for (Node child : node.getChilderen()) {
            if (!child.isVisited()) {
                resNode = depthFirstSearch(data, child);
            }
        }


        return resNode;
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
    public String traverseTree(int mode) {
        return null;
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
        root.getChilderen().add(child);
    }

    public static void main(String[] args) {
        IGraph graph = new Graph();
        Node n1 = graph.insert(1);
        Node n2 = graph.insert(2);
        Node n3 = graph.insert(3);
        Node n4 = graph.insert(4);
        Node n5 = graph.insert(5);
        Node n6 = graph.insert(6);

        graph.addChild(n1, n2);
        graph.addChild(n1, n4);
        graph.addChild(n2, n6);
        graph.addChild(n5, n3);
        graph.addChild(n1, n5);

        System.out.println(graph.depthFirstSearch(5));


    }
}
