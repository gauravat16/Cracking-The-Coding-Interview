package com.cci.bitManipulation;

import java.util.Scanner;

/**
 * Created by gaurav on 26/10/17.
 */
public class Question2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Double dblNum = in.nextDouble();
        int intNum = dblNum.intValue();
        float fltNum = dblNum.floatValue()-intNum;

        String intPart ="";

        int q=intNum;
        int r=0;
        while (q!=0){
            q=q/2;
            r=q%2;
            intPart+=r;
        }

        float fp=fltNum;
        String decPart="";
        while (fp-Double.valueOf(fp).intValue()>0){
            decPart+=Double.valueOf(fp*2).intValue();
            int tempVal=Double.valueOf(fp*2).intValue();
            fp=Math.abs((fp*2) - tempVal);

        }

        System.out.println(intPart+"."+decPart);



    }
}
