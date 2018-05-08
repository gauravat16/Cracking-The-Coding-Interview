package com.cci.trees.implemenation;

import java.util.Random;

public class BinarySearchTree implements ITree {

    Node root = null;

    private static int TREE_SIZE;

    @Override
    public Node insert(Integer data, Node node) {



        if (node.data >= data) {
            if (node.lChild != null) {
                node.setLeft_size(node.getLeft_size() + 1);

                return insert(data, node.lChild);
            } else {
                TREE_SIZE++;

                node.lChild = new Node(data);
                node.lChild.setParent(node);
                node.setLeft_size(node.getLeft_size() + 1);

                return node.lChild;
            }
        } else {
            if (node.rChild != null) {

                node.setRight_size(node.getRight_size() + 1);

                return insert(data, node.rChild);
            } else {
                TREE_SIZE++;

                node.rChild = new Node(data);
                node.rChild.setParent(node);
                node.setRight_size(node.getRight_size() + 1);

                return node.rChild;
            }


        }


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


    public int getRank(Integer data) {
        if (root == null) {
            return -1;
        }
        if (root.data == data) {
            return root.getLeft_size();
        }

        return getRank(data, root);

    }

    public int getRank(Integer data, Node node) {
        if (node.data == data) {
            return node.getLeft_size();
        }

        if (node.data > data) {
            if (node.lChild == null)
                return -1;
            return getRank(data, node.lChild);
        } else {

            int rightRank;

            if (node.rChild == null) {
                return -1;
            } else {
                rightRank = getRank(data, node.rChild);
            }
            if (rightRank == -1) {
                return rightRank;
            } else {
                return rightRank + node.getLeft_size() + 1;

            }
        }


    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    @Override
    public Node depthFirstSearch(Integer data) {
        if (null != getRoot()) {
            return depthFirstSearch(data, root);
        } else {
            return null;
        }
    }

    @Override
    public Node breadthFirstSearch(Integer data) {
        if (null != getRoot()) {
            return breadthFirstSearch(data, root);
        } else {
            return null;
        }
    }

    @Override
    public Node depthFirstSearch(Integer data, Node node) {
        if (null == node) {
            return null;
        }

        Node tempNode = null;
        if (node.data.equals(data)) {
            return node;
        } else {
            if (node.isLeaf()) {
                if (null != node.parent.rChild && node.parent.rChild.data.equals(data)) {
                    return node.parent.rChild;
                } else if (null != node.parent.lChild && node.parent.lChild.data.equals(data)) {
                    return node.parent.lChild;
                }
            } else {
                tempNode = (null != depthFirstSearch(data, node.lChild)) ? depthFirstSearch(data, node.lChild) : depthFirstSearch(data, node.rChild);
            }


            return tempNode;


        }


    }

    @Override
    public Node breadthFirstSearch(Integer data, Node node) {

        if (node == null) {
            return null;
        }

        Node tempNode = null;
        if (node.data.equals(data)) {
            return node;
        } else {
            if (null != node.lChild && node.lChild.data.equals(data)) {
                tempNode = node.lChild;

            } else if (null != node.rChild && node.rChild.data.equals(data)) {
                tempNode = node.rChild;
            }

            if (null == tempNode) {
                tempNode = (null != breadthFirstSearch(data, node.lChild)) ? breadthFirstSearch(data, node.lChild) : breadthFirstSearch(data, node.rChild);
            }


            return tempNode;


        }
    }

    @Override
    public Node search(Integer mode, Integer data) {

        switch (mode) {
            case ITree.BREADTH_FIRST:
                return breadthFirstSearch(data);
            case ITree.DEPTH_FIRST:
                return depthFirstSearch(data);

        }
        return null;
    }

    @Override
    public String traverseTree(int mode) {
        switch (mode) {
            case ITree.PRE_ORDER:
                return preorderTraversal(getRoot(), null);
            case ITree.POST_ORDER:
                return postorderTraversal(getRoot(), null);
            case IN_ORDER:
                return inorderTraversal(getRoot(), "");

        }
        return null;
    }

    @Override
    public String preorderTraversal(Node node, String treeData) {
        if (null == node) {
            return treeData;
        }

        if (node.isLeaf()) {
            treeData = " " + node.data;
            return treeData;


        }
        String leftData = "", rightData = "";
        if (null != node.lChild) {
            leftData = preorderTraversal(node.lChild, treeData);

        }
        treeData = node.data + " " + leftData;

        if (null != node.rChild) {
            rightData = preorderTraversal(node.rChild, treeData);

        }

        treeData += " " + rightData;


        return treeData;
    }

    @Override
    public String postorderTraversal(Node node, String treeData) {
        if (null == node) {
            return treeData;
        }

        if (node.isLeaf()) {
            treeData = " " + node.data;
            return treeData;


        }
        String leftData = "", rightData = "";
        if (null != node.lChild) {
            leftData = postorderTraversal(node.lChild, treeData);

        }
        treeData = leftData;

        if (null != node.rChild) {
            rightData = postorderTraversal(node.rChild, treeData);

        }

        treeData += " " + rightData + " " + node.data + " ";


        return treeData;
    }

    @Override
    public String inorderTraversal(Node node, String treeData) {

        if (null == node) {
            return treeData;
        }

        if (node.isLeaf()) {
            treeData = " " + node.data;
            return treeData;


        }
        String leftData = "", rightData = "";
        if (null != node.lChild) {
            leftData = inorderTraversal(node.lChild, treeData);

        }
        treeData = leftData + " " + node.data;

        if (null != node.rChild) {
            rightData = inorderTraversal(node.rChild, treeData);

        }

        treeData += " " + rightData;


        return treeData;
    }

    @Override
    public void addChild(Node root, Node child) {

    }

    public Node getRandomNode() {
        return getRandomNode(getRoot());

    }

    public Node getRandomNode(Node node) {
        if (node == null) {
            return null;
        }

        Random random = new Random();

        int index = random.nextInt(node.getLeft_size()+node.getRight_size()+1);

        if (index < node.getLeft_size()) {
            return getRandomNode(node.getlChild());
        } else if (index == node.getLeft_size()) {
            return node;
        } else {
            return getRandomNode(node.getrChild());
        }

    }


    public static void main(String[] args) {
        ITree binaryTree = new BinarySearchTree();
        binaryTree.insert(22);
        binaryTree.insert(2);
        binaryTree.insert(32);
        binaryTree.insert(12);
        binaryTree.insert(21);
        binaryTree.insert(98);
        binaryTree.insert(2);
        binaryTree.insert(32);
        binaryTree.insert(42);
        binaryTree.insert(52);


        for (int i =0; i<100;i++){
            System.out.print(((BinarySearchTree) binaryTree).getRandomNode()+"\t");

        }


    }

}
