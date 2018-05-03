package com.cci.trees.questions;

import com.cci.trees.implemenation.BinarySearchTree;
import com.cci.trees.implemenation.ITree;
import com.cci.trees.implemenation.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q9 {

    public static void main(String[] args) {
        ITree binaryTree = new BinarySearchTree();
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

        System.out.println(getAllCombinations(binaryTree.getRoot()));


    }


    static List<LinkedList<Node>> getAllCombinations(Node root) {

        List<LinkedList<Node>> lists = new ArrayList<>();

        if (root == null) {
            lists.add(new LinkedList<Node>());

            return lists;
        }


        LinkedList<Node> prefix = new LinkedList<>();


        prefix.add(root);

        List<LinkedList<Node>> leftSeq = getAllCombinations(root.getlChild());
        List<LinkedList<Node>> rightSeq = getAllCombinations(root.getrChild());

        for (LinkedList<Node> lSeq : leftSeq) {
            for (LinkedList<Node> rSeq : rightSeq) {
                List<LinkedList<Node>> weaved = new ArrayList<>();
                weaveLists(lSeq, rSeq, weaved, prefix);
                lists.addAll(weaved);
            }
        }


        return lists;
    }


    static void weaveLists(LinkedList<Node> first, LinkedList<Node> second, List<LinkedList<Node>> results, LinkedList<Node> prefix) {


        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Node> result = (LinkedList<Node>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);

            return;


        }

        Node headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        Node headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);


    }

}
