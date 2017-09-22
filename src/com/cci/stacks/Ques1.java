package com.cci.stacks;

import java.util.Stack;


public class Ques1 {

	static Stack<Integer> stack = new Stack<>();
	static Stack<Integer> minStack = new Stack<>();

	public static void main(String[] args) {

		push(9);
		push(4);
		push(7);
		push(3);
		push(8);
		push(2);
		push(6);
		push(4);
		push(1);
		push(2);

		popPrint();
		popPrint();
		popPrint();
		popPrint();
		popPrint();
		popPrint();
		popPrint();
		popPrint();
		popPrint();

	}

	static void push(int val) {
		stack.push(val);
		if (minStack.isEmpty()) {
			minStack.add(val);
		} else {
			if (val <= minStack.peek()) {
				minStack.add(val);
			}
		}

	}

	static void pop() {
		if (stack.pop().equals(minStack.peek())) {
			minStack.pop();
		}
	}

	static void getMin() {
		System.out.println(minStack.peek());

	}

	static void popPrint() {
		pop();
		System.out.println(stack);
		getMin();

	}

}
