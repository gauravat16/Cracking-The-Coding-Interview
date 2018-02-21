package com.cci.Sorting.questions;

import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.BitSet;
import java.util.concurrent.ThreadLocalRandom;

public class Q7 {


    static BitSet generateRawData() {

        Integer index = Integer.MAX_VALUE;
        BitSet bitSet = new BitSet(Integer.MAX_VALUE);

        int progress = Integer.MAX_VALUE / 100;

        while (index > 0) {

            if (index % progress == 0 && index >= progress) {
                System.out.println((index / progress) + "% ..... remaining");
            }

            Integer random = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);

            bitSet.set(random);


            index--;
        }
        return bitSet;
    }


    public static void main(String[] args) {
        BitSet bitSet = generateRawData();


        for (int i = 0; i <Integer.MAX_VALUE; i++) {
            if (!bitSet.get(i)) {
                System.out.println(i);
                break;
            }
        }

        }
}
