package com.cci.bitManipulation;

public class Question8 {

    static byte[] draw(int x1, int x2, int w, int y, byte[] pixels) {
        int start_offset = x1 % 8;
        int first_full_byte = x1 / 8;

        if (start_offset != 0) //Not at the end of a byte
        {
            first_full_byte++;
        }

        int end_offset = x2 % 8;
        int last_full_byte = x2 / 8;

        if (end_offset != 7) {
            last_full_byte--;
        }

        //set the full bytes

        for (int i = first_full_byte; i <= last_full_byte; i++) {
            pixels[w / 8 * y + i] = (byte) 0xFF;
        }

        //MASKS
        int start_mask = (byte) 0xFF >> start_offset;
        int end_mask = (byte) (0xFF >> (end_offset + 1));

        if (x1 / 8 == x2 / 8) {
            //Same byte
            int mask = start_mask & end_mask;
            pixels[(w / 8 * y) + x1 / 8] |= mask;
        } else {
            if (start_offset != 0) {

                pixels[(w / 8 * y) + first_full_byte - 1] |= start_mask;

            }
            if (end_offset != 7) {
                pixels[(w / 8 * y) + last_full_byte + 1] |= end_mask;


            }


        }

        return pixels;
    }

    public static void main(String[] args) {
        byte[] b = draw(10,20,2,2,new byte[]{0,0,0,0,0,0,0,0,0,0,0});
        for(byte by : b){
            System.out.println(Integer.toBinaryString(by));
        }
    }
}
