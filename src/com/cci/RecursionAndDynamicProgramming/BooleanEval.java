package com.cci.RecursionAndDynamicProgramming;

import java.util.HashSet;

public class BooleanEval {


    public static void main(String[] args) {

//        String exp = "1^0|0|1";
        String exp = "0&0&0&1^1|0";

        int count = 0;
        for (int i = 0; i < exp.length(); i = i + 2) {
            System.out.println("i - " + i);

            count += (countEval(exp, i, i + 2, true, new HashSet<String>()));

            System.out.println(i+"'s count"+count);
        }

//        count += countEval(exp, 0, 0, false, new HashSet<String>());
        System.out.println(count);
    }


    static int countEval(String expression, int startPosition, int endPosition, boolean result,HashSet<String> tempSet) {


        if(expression.length()==1){
            if (result == getBoolean(expression)) {

                return 1;
            } else {
                return 0;
            }
        }


        if (endPosition >= expression.length()) {
            return 0;
        }


        int currentData = getInt(calcPartExpression(expression.substring(startPosition, endPosition + 1)));
        if(startPosition==0){

            expression = String.valueOf(currentData) + expression.substring(endPosition + 1, expression.length());
            System.out.println("Expression - " + expression);

        }else {
            expression = expression.substring(0,startPosition) +String.valueOf(currentData) + expression.substring(endPosition + 1, expression.length());
            System.out.println("Expression - " + expression);

        }
        int tempCount = 0;

        for (int i = 0; i < expression.length(); i = i + 2) {
            tempCount += countEval(expression, i, i + 2, result,tempSet);

        }

        return tempCount;
    }


    static boolean calcPartExpression(String partExpression) {
        boolean a = partExpression.charAt(0) == '1';
        boolean b = partExpression.charAt(2) == '1';
        char operation = partExpression.charAt(1);

        switch (operation) {
            case '^':
                return a ^ b;
            case '&':
                return a & b;
            case '|':
                return a | b;
        }

        return false;
    }

    static boolean getBoolean(String val) {
        return (val.equals("1"));
    }

    static int getInt(boolean val) {
        return (val) ? 1 : 0;
    }
}
