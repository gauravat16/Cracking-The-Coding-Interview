package com.cci.trees.implemenation;

public class MinHeap implements IHeap {

    private Node root = null;

    private Node rightMostNode = null;

    @Override
    public boolean insert(Integer data) {

        if (null == getRoot()) {
            setRoot(new Node(data));
            setRightMostNode(getRoot());
            return true;
        }

        Node node = new Node(data);
        if (null != getRightMostNode().getlChild()) {
            node.setParent(getRightMostNode());
            getRightMostNode().setrChild(node);
            setRightMostNode(node);
        } else {
            node.setParent(getRightMostNode());
            getRightMostNode().setlChild(node);
        }


        insertFix(node);


        return false;
    }

    @Override
    public boolean insertFix(Node node) {
        if (null == node || getRoot().data == node.data) {
            return false;
        }

        if (node.data < node.parent.data) {
            swapNodes(node, node.parent);
            insertFix(node.parent);
        }

        return false;
    }

    @Override
    public Node getMinNode() {
        return null;
    }

    @Override
    public Node getMaxNode() {
        return null;
    }

    @Override
    public void setRoot(Node root) {
        this.root = root;
    }

    @Override
    public Node getRoot() {
        return this.root;
    }

    public Node getRightMostNode() {
        return rightMostNode;
    }

    public void setRightMostNode(Node rightMostNode) {
        this.rightMostNode = rightMostNode;
    }

    @Override
    public void swapNodes(Node n1, Node n2) {
        int tempData = n1.data;
        n1.data = n2.data;
        n2.data = tempData;

    }

    public static void main(String[] args) {
        IHeap heap = new MinHeap();
        heap.insert(2);
        heap.insert(3);
        heap.insert(1);
        heap.insert(6);
        heap.insert(7);
        heap.insert(8);
        heap.insert(5);

    }
}
