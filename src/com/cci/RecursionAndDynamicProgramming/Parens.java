package com.cci.RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;

public class Parens {

    public static void main(String[] args) {
        HashMap<String, Integer> tally = new HashMap<>();
        tally.put("(", 3);
        tally.put(")", 3);
        System.out.println(getCombinations(tally, new ArrayList<String>(), 3, 3, ""));

    }

    static ArrayList<String> getCombinations(HashMap<String, Integer> tally, ArrayList<String> combinations, int closing_len, int opening_len, String prefix) {

        if (closing_len == 0 && opening_len == 0) {
            combinations.add(prefix);
            return combinations;
        }

        for (String bracket : tally.keySet()) {
            int count = tally.get(bracket);

            if (count > 0) {
                tally.put(bracket, count - 1);
                if (bracket.equals("(")) {
                    opening_len -= 1;
                } else if (bracket.equals(")")) {
                    closing_len -= 1;
                }

                getCombinations(tally, combinations, closing_len, opening_len, prefix + bracket);

                tally.put(bracket, count);
            }
        }

        return combinations;
    }
}
