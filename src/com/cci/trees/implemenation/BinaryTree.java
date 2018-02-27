package com.cci.trees.implemenation;

public class BinaryTree implements ITree {

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    Node root = null;

    @Override
    public boolean insert(Integer data, Node node) {


        if (node.data >= data) {
            if (node.lChild != null) {
                node.setLeft_size(node.getLeft_size() + 1);
                return insert(data, node.lChild);
            } else {
                node.lChild = new Node(data);
                node.lChild.setParent(node);
                node.setLeft_size(node.getLeft_size() + 1);

                return true;
            }
        } else {
            if (node.rChild != null) {
                return insert(data, node.rChild);
            } else {
                node.rChild = new Node(data);
                node.rChild.setParent(node);
                return true;
            }
        }


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


    public static void main(String[] args) {
        ITree binaryTree = new BinaryTree();
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

        System.out.println(binaryTree.getRoot());

        System.out.println(binaryTree.getRank(98));
    }

}
