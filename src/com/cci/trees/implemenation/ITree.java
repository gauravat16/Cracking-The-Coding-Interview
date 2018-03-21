package com.cci.trees.implemenation;

public interface ITree {

    int BREADTH_FIRST=0;
    int DEPTH_FIRST=1;


    boolean insert(Integer data, Node node);

    boolean insert(Integer data);

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


}
