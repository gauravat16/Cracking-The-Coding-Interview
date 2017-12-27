package com.cci.RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;

public class PermutaionsDup {

   static HashMap<Character, Integer> getTally(String s){
        HashMap<Character, Integer> tallyMap = new HashMap<>();

        for (char c : s.toCharArray()){
            if(tallyMap.containsKey(c)){
                tallyMap.put(c,tallyMap.get(c)+1);
            }else {
                tallyMap.put(c,1);
            }

        }

        return tallyMap;
    }


   static ArrayList<String> getPermuations(int limit, HashMap<Character,Integer> tallyMap, ArrayList<String> permutations, String prefix){
        if(limit==0){
             permutations.add(prefix);
             return permutations;
        }

        for (char c : tallyMap.keySet()){
            if(tallyMap.get(c)>0){
                tallyMap.put(c,tallyMap.get(c)-1);
                getPermuations(limit-1,tallyMap,permutations,prefix+c);
                tallyMap.put(c,tallyMap.get(c)+1);


            }
        }

        return permutations;
    }

    public static void main(String[] args) {
       String s = "aab";
        System.out.println(getPermuations(s.length(),getTally(s),new ArrayList<String>(),""));
    }
}
