package com.cci.graphs.implementation;

import com.cci.trees.implemenation.Node;

public interface IGraph {

    int BREADTH_FIRST = 0;
    int DEPTH_FIRST = 1;
    int IN_ORDER = 1;
    int POST_ORDER = 2;
    int PRE_ORDER = 3;


    Node insert(Integer data, Node node);

    Node insert(Integer data);

    void addChild(Node root, Node child);

    boolean remove(Integer data);

    Node getRoot();

    int getRank(Integer data);

    int getRank(Integer data, Node node);

    void setRoot(Node root);

    Node depthFirstSearch(Integer data);

    Node breadthFirstSearch(Integer data);

    Node depthFirstSearch(Integer data, Node node);

    Node breadthFirstSearch(Integer data, Node node);

    Node search(Integer mode, Integer data);

    String traverseTree(int mode);

    String preorderTraversal(Node node, String treeData);

    String postorderTraversal(Node node, String treeData);

    String inorderTraversal(Node node, String treeData);
}
