package com.cci.trees.implemenation;

public interface IHeap {

    void setRoot(Node root);

    Node getRoot();

    boolean insert(Integer value);

    boolean insertFix(Node node);

    Node getMinNode();

    Node getMaxNode();

    void swapNodes(Node n1, Node n2);

}
