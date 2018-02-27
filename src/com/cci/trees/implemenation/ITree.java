package com.cci.trees.implemenation;

public interface ITree {

    boolean insert(Integer data, Node node);

    boolean insert(Integer data);

    boolean remove(Integer data);

    Node getRoot();

    int getRank(Integer data);

    int getRank(Integer data, Node node);

}
