package com.cci.graphs.questions;

import com.cci.graphs.implementation.Graph;
import com.cci.trees.implemenation.Node;

import java.util.LinkedList;

public class Q1 extends Graph {

    /*
    * Check if 2 nodes of a graph are connected or not
    * */

    public static void main(String[] args) {
        Q1 graph = new Q1();
        Node n1 = graph.insert(1);
        Node n2 = graph.insert(2);
        Node n3 = graph.insert(3);
        Node n4 = graph.insert(4);
        Node n5 = graph.insert(5);
        Node n6 = graph.insert(6);
        Node n7 = graph.insert(7);

        graph.addChild(n1, n2);
        graph.addChild(n1, n4);
        graph.addChild(n2, n6);
        graph.addChild(n5, n3);
        graph.addChild(n1, n5);

        System.out.println(graph.checkIfNodesAreConnected(n1, n7));

    }


    boolean checkIfNodesAreConnected(Node node1, Node node2) {

        java.util.Queue<Node> nodeQueue = new LinkedList<>();

        nodeQueue.add(node1);

        while (!nodeQueue.isEmpty()) {
            Node tempNode = nodeQueue.remove();
            if (tempNode.equals(node2)) {
                return true;
            }
            for (Node child : tempNode.getChilderen()) {
                if (!child.isVisited()) {
                    nodeQueue.add(child);
                }
            }
        }


        return false;

    }
}
