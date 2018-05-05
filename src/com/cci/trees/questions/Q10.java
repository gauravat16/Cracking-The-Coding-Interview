package com.cci.trees.questions;

import com.cci.trees.implemenation.BinarySearchTree;
import com.cci.trees.implemenation.ITree;
import com.cci.trees.implemenation.Node;

public class Q10 {

    public static void main(String[] args) {
        ITree binaryTree = new BinaryTreeQ10();
        binaryTree.insert(22);
        binaryTree.insert(32);
        binaryTree.insert(31);
        binaryTree.insert(45);
        binaryTree.insert(2);
        binaryTree.insert(12);
        binaryTree.insert(21);
        binaryTree.insert(98);
        binaryTree.insert(42);
        binaryTree.insert(52);


        ITree binaryTree2 = new BinaryTreeQ10();

        binaryTree2.insert(2);
        binaryTree2.insert(12);
        binaryTree2.insert(21);


        System.out.println(isSubTree(binaryTree, binaryTree2));
    }


    static boolean isSubTree(ITree tree1, ITree tree2) {
        return tree1.traverseTree(ITree.PRE_ORDER).contains(tree2.traverseTree(ITree.PRE_ORDER));
    }


}


class BinaryTreeQ10 extends BinarySearchTree {

    @Override
    public Node insert(Integer data) {
        Node tempNode = super.insert(data);

        tempNode.setlChild(new Node(Integer.MIN_VALUE));
        tempNode.setrChild(new Node(Integer.MIN_VALUE));

        return tempNode;


    }
}


