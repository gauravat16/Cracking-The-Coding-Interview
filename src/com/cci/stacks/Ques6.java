package com.cci.stacks;

import java.util.LinkedList;
import java.util.Queue;

public class Ques6 {
	static Queue<String> mainQueue = new LinkedList<>();
	static Queue<String> catQueue = new LinkedList<>();
	static Queue<String> dogQueue = new LinkedList<>();

	public static void main(String[] args) {
		for (int i = 1; i<99; i++) {
			if(i%2==0){
				enqueue("cat"+i);
			}else{
				enqueue("dog"+i);
			}
			
		}
		System.out.println(mainQueue);
		System.out.println(catQueue);
		System.out.println(dogQueue);
		dequeue();
		catDequeue();
		dogDequeue();
		

	}

	static void enqueue(String k) {
		mainQueue.add(k);

		if (k.contains("cat")) {
			catQueue.add(k);
		} else {
			dogQueue.add(k);
		}
	}

	static void dequeue() {
		String temp = mainQueue.remove();

		if (temp.contains("cat")) {
			catQueue.remove(temp);
		} else {
			dogQueue.remove(temp);
		}

		System.out.println(temp);
	}

	static void catDequeue() {
		String temp = catQueue.remove();

		mainQueue.remove(temp);
		System.out.println(temp);

	}

	static void dogDequeue() {
		String temp = dogQueue.remove();

		mainQueue.remove(temp);
		System.out.println(temp);

	}
	
	

}
