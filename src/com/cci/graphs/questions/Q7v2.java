package com.cci.graphs.questions;

import com.cci.graphs.implementation.Graph;
import com.cci.graphs.implementation.IGraph;
import com.cci.trees.implemenation.Node;

import javax.xml.stream.events.Characters;
import java.util.Stack;

public class Q7v2 {

    public static void main(String[] args) {
        IGraph graph = new Graph();
        Node a = graph.insert((int) 'a');
        Node b = graph.insert((int) 'b');
        Node c = graph.insert((int) 'c');
        Node d = graph.insert((int) 'd');
        Node e = graph.insert((int) 'e');
        Node f = graph.insert((int) 'f');

        Stack<Node> nodeStack = new Stack<>();
        nodeStack.add(a);
        nodeStack.add(b);
        nodeStack.add(c);
        nodeStack.add(d);
        nodeStack.add(e);
        nodeStack.add(f);

        graph.addChild(c, d);
        graph.addChild(d, b);
        graph.addChild(d, a);
        graph.addChild(b, f);
        graph.addChild(a, f);
        nodeStack = getPath(nodeStack);
        while (nodeStack.size()>0){
            System.out.println((char)Integer.parseInt(nodeStack.pop().getData().toString()));
        }


    }

    static Stack<Node> getPath(Stack<Node> nodeStack) {
        Stack<Node> path = new Stack<>();
        for (Node node : nodeStack) {
            if (node.getState().equals(Node.States.BLANK)) {
                if (!doDepthFirst(node, path)) {
                    return null;
                }
            }
        }

        return path;
    }


    static boolean doDepthFirst(Node node, Stack<Node> nodeStack) {

        if (node.getState().equals(Node.States.PARTIAL)) {
            return false;
        }

        if (node.getState().equals(Node.States.BLANK)) {
            node.setState(Node.States.PARTIAL);


            for (Node child : node.getChilderen()) {

                if (!doDepthFirst(child, nodeStack)) {
                    return false;
                }

            }

            node.setState(Node.States.COMPLETE);
            nodeStack.push(node);
        }

        return true;
    }


}


