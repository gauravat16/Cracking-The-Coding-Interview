package com.cci.Sorting.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q2 {


    static String[] sortAnagrams(String[] strArr) {

        HashMap<String, ArrayList<String>> keyAnagramMap = new HashMap<>();

        for (String word : strArr) {
            String unsortedWord = word;
            String sortedWord = sortChars(word);
            if (keyAnagramMap.get(sortedWord) != null) {
                keyAnagramMap.get(sortedWord).add(unsortedWord);
            } else {
                ArrayList<String> tempList = new ArrayList<>();
                tempList.add(unsortedWord);
                keyAnagramMap.put(sortedWord, tempList);
            }
        }
        int i = 0;
        for (Map.Entry<String, ArrayList<String>> entry : keyAnagramMap.entrySet()) {
            for (String w : entry.getValue()) {
                strArr[i] = w;
                i++;

            }

        }


        return strArr;
    }


    static String sortChars(String word) {


        char[] wordArr = word.toCharArray();
        Arrays.sort(wordArr);
        return new String(wordArr);
    }

    public static void main(String[] args) {
        String[] arr = {"adv", "vsa", "vad", "sav", "bulbasaur"};
        System.out.println(Arrays.deepToString(sortAnagrams(arr)));
    }
}
