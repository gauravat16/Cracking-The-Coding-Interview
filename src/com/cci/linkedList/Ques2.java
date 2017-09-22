package com.cci.linkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ques2 {

	
	public static void main(String[] args) {
		int k =5;
		LinkedList<String> linkedList = new LinkedList<>();
		String[] arrData = { "a", "b", "c", "d", "e", "a", "f", "k", "b","z" };
		for (String s : arrData) {
			linkedList.add(s);
		}

		System.out.println(linkedList);
		
		//Method-1 
		
		ArrayList<String> buffer = new ArrayList<>();
		int index=0;
		for(String s : linkedList){
			buffer.add(s);
			index++;
		}
		
		System.out.println(buffer.get(buffer.size()-k));
		
		
	}
}
