package com.cci.RecursionAndDynamicProgramming;


import java.util.HashMap;
import java.util.Map;

public class ChangeCalc {

    public static void main(String[] args) {
        int ways = 0;
        int change =6;
        int[] changes = {25,10,5,1};

        HashMap<Integer,Integer> map = new HashMap<>();
        System.out.println(changeCalculator(change,ways,map,changes));
        System.out.println(map);

    }

    static int changeCalculator(int change, int ways, Map<Integer,Integer> changeWaysRegister,int[] changes){

        if (changeWaysRegister.containsKey(change)){
            return changeWaysRegister.get(change);
        }

        if(change==0){
            ways++;
            return ways;
        }else if (change<0){
            return ways;
        }

        for (int denom : changes){
            ways = changeCalculator(change-denom,ways,changeWaysRegister,changes);
//            if(changeWaysRegister.containsKey(change) && ways>changeWaysRegister.get(change)){
//                changeWaysRegister.put(change,ways);
//            }else {
//                changeWaysRegister.put(change,ways);
//            }


        }




        return ways;

    }
}
