package com.cci.bitManipulation;

public class Question4 {

    static int closestLargest(int number){
        String inBits=Integer.toBinaryString(number);
        int firstZero=-1;
        int firstOne=-1;
        for (int i=inBits.length()-1;i>=0;i--){
            int current=Integer.parseInt(String.valueOf(inBits.charAt(i)));
            if(current==0 && firstOne!=-1){
                firstZero=i;
            }

            if(current==1){
                firstOne=i;
            }

            if(firstOne !=-1 && firstZero!=-1){
                break;
            }
        }
       return BitFunctions.updateBits(BitFunctions.updateBits(number,1,firstZero),0,firstOne);

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
        mask=((1<<trailingOnes)-1);
        number|=mask << (trailingZeros-trailingOnes);
        return number;

    }


    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(101));
        System.out.println(Integer.toBinaryString(~0));

        System.out.println(Integer.toBinaryString(closestLargest(101)));
        System.out.println(Integer.toBinaryString(closestSmallest(101)));

    }
}
