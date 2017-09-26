package com.cci.stacks;

import java.util.Stack;

public class Ques4 {
	
	static Stack<Integer> main = new Stack<>();
	static Stack<Integer> buffer = new Stack<>();

	static void push(int k){
		main.push(k);
		
	}
	
	static void pop(){
		while (!main.isEmpty()) {
			buffer.push(main.pop());
			
			
		}
		
		System.out.println(buffer.pop());
		while (!buffer.isEmpty()) {
			main.push(buffer.pop());
			
			
		}
		
	}
	
	public static void main(String[] args) {
		for (int i = 99; i < 999; i++) {
			push(i);
		}
		
		pop();
		pop();
	}

}
