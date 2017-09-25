package com.cci.stacks;

import java.util.ArrayList;
import java.util.Stack;

public class Ques3 {

	static Stack<Integer> currentStack = null;
	static ArrayList<Stack<Integer>> arrayOfStack = new ArrayList<>();
	static int limit = 10;

	static void push(int k) {
		if (currentStack == null) {
			currentStack = new Stack<>();
			currentStack.push(k);
			arrayOfStack.add(currentStack);
			return;
		}

		if (currentStack.size() == limit) {
			currentStack = new Stack<>();
			currentStack.push(k);

			arrayOfStack.add(currentStack);
		} else {
			currentStack.push(k);

		}
	}

	static void pop() {

		currentStack.pop();

	}

	static void pop(int index) {
		arrayOfStack.get(index).pop();
	}

	static void print() {
		for (Stack<Integer> stack : arrayOfStack) {
			System.out.println(stack);
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {

		for (int i = 0; i < 999; i++) {
			push(i);
		}

		print();

		pop();

		pop(0);
		print();

	}

}
