package com.cci.linkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class Ques1 {

	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<>();
		String[] arrData = { "a", "b", "c", "d", "e", "a", "f", "k", "b" };
		for (String s : arrData) {
			linkedList.add(s);
		}

		System.out.println(linkedList);

		HashMap<String, Object> map = new HashMap<>();

		int index = 0;
		ArrayList<Integer> arrayList = new ArrayList<>();

		for (String s : linkedList) {
			if (map.containsKey(s)) {
				arrayList.add(index);
				continue;
			}
			map.put(s, null);

			index++;

		}

		for (int i : arrayList) {
			linkedList.remove(i);

		}

		System.out.println(linkedList);

	}

}
