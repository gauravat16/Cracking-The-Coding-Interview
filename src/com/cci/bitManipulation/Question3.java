package com.cci.bitManipulation;

/**
 * Created by gaurav on 27/10/17.
 */
public class Question3 {

    static int getIntVal(char val) {
        return Integer.parseInt(String.valueOf(val));
    }

    public static void main(String[] args) {
        int maxCurrent = 0;
        int maxTillNow = 0;
        boolean hasFlipped = false;
        int lastZeroPosition = -1;
        int number = 10;

        String bitString = Integer.toBinaryString(95433);

        for (int i = 0; i < bitString.length(); i++) {
            int curreVal = Integer.parseInt(String.valueOf(bitString.charAt(i)));
            if (curreVal == 1) {
                maxCurrent++;
                if (maxCurrent > maxTillNow) {
                    maxTillNow = maxCurrent;
                }
            } else {
                if (getIntVal(bitString.charAt(i - 1)) != 0 && getIntVal(bitString.charAt(i + 1)) != 0) {
                    if(!hasFlipped){
                        hasFlipped=true;
                        lastZeroPosition=i;
                        maxCurrent++;
                    }else {
                        maxCurrent=0;
                        hasFlipped=true;
                        maxCurrent=i-lastZeroPosition;
                    }
                }else {
                    maxCurrent=0;
                }
            }
        }


        System.out.println(maxTillNow);
    }
}
