package com.cci.RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;

public class Parens {

    public static void main(String[] args) {
        int val =8;
        HashMap<String, Integer> tally = new HashMap<>();
        tally.put("(", val);
        tally.put(")", val);
        System.out.println(getCombinations(tally, new ArrayList<String>(), val, val, ""));

    }

    static ArrayList<String> getCombinations(HashMap<String, Integer> tally, ArrayList<String> combinations, int closing_len, int opening_len, String prefix) {

        if (closing_len == 0 && opening_len == 0) {
            if(isvalidCombination(prefix)){
                combinations.add(prefix);

            }
            return combinations;
        }

        for (String bracket : tally.keySet()) {
            int count = tally.get(bracket);

            if (count > 0) {
                tally.put(bracket, count - 1);
                if (bracket.equals("(")) {
                    opening_len = tally.get(bracket);
                } else if (bracket.equals(")")) {
                    closing_len = tally.get(bracket);
                }

                getCombinations(tally, combinations, closing_len, opening_len, prefix + bracket);

                tally.put(bracket, count);
            }
        }

        return combinations;
    }

    static  boolean  isvalidCombination(String prefix){
        int opening_len=0;
        int closing_len=0;
        if(prefix.charAt(0)==')'){
            return false;
        }
        for(char c : prefix.toCharArray()){
            if(c=='('){
                opening_len++;
            }else {
                opening_len--;
                if(opening_len<0){
                    return false;
                }

            }

        }

        return opening_len==closing_len;
    }
}
