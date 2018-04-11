package com.cci.trees.questions;

import com.cci.trees.implemenation.BinarySearchTree;
import com.cci.trees.implemenation.ITree;
import com.cci.trees.implemenation.Node;

/*
*Get successor of a node
*
*/
public class Q6 {

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

        System.out.println(getSuccessor(binaryTree.getRoot()));

    }


    static Node getSuccessor(Node n) {
        if (null == n) {
            return null;
        }




        if (n.getrChild() == null) {
            Node currNode = n;
            Node currParent = n.getParent();

            while (null != currParent && currParent.getlChild() != currNode) {
                currNode = currParent;
                currParent = currNode.getParent();
            }

            return currNode;
        } else {
            return getLeftChild(n.getrChild());
        }


    }


    static Node getLeftChild(Node n) {
        if (null == n) {
            return null;
        }

        if (n.getlChild() != null) {
            n = getLeftChild(n.getlChild());
        }

        return n;
    }
}
