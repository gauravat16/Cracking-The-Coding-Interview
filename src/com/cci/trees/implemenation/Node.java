package com.cci.trees.implemenation;

import java.util.ArrayList;
import java.util.List;

public class Node {

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    private boolean isVisited = false;

    public int getLeft_size() {
        return left_size;
    }

    public void setLeft_size(int left_size) {
        this.left_size = left_size;
    }

    int left_size;

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    Node parent, lChild, rChild;
    List<Node> childeren = new ArrayList<>();

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    Integer data;

    public Node(Integer data) {
        this.data = data;
    }


    public Node getlChild() {
        return lChild;
    }

    public void setlChild(Node lChild) {
        this.lChild = lChild;
    }

    public Node getrChild() {
        return rChild;
    }

    public void setrChild(Node rChild) {
        this.rChild = rChild;
    }

    public List<Node> getChilderen() {
        return childeren;
    }

    public void setChilderen(List<Node> childeren) {
        this.childeren = childeren;
    }

    public boolean isLeaf() {
        return null == this.lChild && null == this.rChild;
    }

    @Override
    public String toString() {
        return "data{" +
                data +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Node tempNode = new Node(this.getData());
        tempNode.setParent(this.parent);
        tempNode.setlChild(this.lChild);
        tempNode.setrChild(this.rChild);
        return tempNode;
    }
}
