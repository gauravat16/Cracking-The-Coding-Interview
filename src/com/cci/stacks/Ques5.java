package com.cci.stacks;

import java.util.Stack;

public class Ques5 {
	
	static void sort(Stack<Integer> stack){
		Stack<Integer> buffer = new Stack<>();
		buffer.push(stack.pop());
		while (!stack.isEmpty()){
			int temp = stack.pop();
			while(!buffer.isEmpty() && buffer.peek()>temp){
				stack.push(buffer.pop());
			}
			
			buffer.push(temp);
		}
		
		while(!buffer.isEmpty()){
			stack.push(buffer.pop());
		}
		
		System.out.println(stack);
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		for (int i = 1; i<99; i++) {
			s.push(i);
		}
		
		System.out.println(s);
		
		sort(s);
	}

}
