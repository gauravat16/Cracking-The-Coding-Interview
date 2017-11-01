package com.cci.bitManipulation;

public class Question4 {

    static int closestLargest(int number){
        int trailingOnes=0;
        int trailingZeros=0;
        int switchBitPosition=-1;
        int temp=number;
        while ((temp & 1)==0 && temp!=0){
            temp>>=1;
            trailingZeros++;
        }
        while ((temp & 1) ==1){
            temp>>=1;
            trailingOnes++;
        }
        if(trailingOnes+trailingZeros==31 || trailingOnes+trailingZeros==0){
            return -1;
        }





        switchBitPosition=trailingOnes+trailingZeros;
        int mask=((1<<switchBitPosition));
        number|=mask;
        mask=~((1<<trailingOnes)-1);
        number&=mask;
        mask=(1<<trailingOnes-1)-1;
        number|=mask;
        return number;


    }

    static int closestSmallest(int number){
        int trailingOnes=0;
        int trailingZeros=0;
        int switchBitPosition=-1;
        int temp=number;
        while ((temp & 1) ==1){
            temp>>=1;
            trailingOnes++;
        }
        if(temp==0){
            return -1;
        }

        while ((temp & 1)==0 && temp!=0){
            temp>>=1;
            trailingZeros++;
        }

        switchBitPosition=trailingOnes+trailingZeros;

        int mask=((~0<<switchBitPosition+1));
        number&=mask;
        mask=((1<<trailingOnes+1)-1);
        number|=mask << (trailingZeros-1);
        return number;

    }


    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(137));
        System.out.println(Integer.toBinaryString(~0));

        System.out.println(Integer.toBinaryString(closestLargest(137)));
        System.out.println(Integer.toBinaryString(closestSmallest(137)));
        System.out.println(closestSmallest(137));
        System.out.println(closestLargest(137));

    }
}
