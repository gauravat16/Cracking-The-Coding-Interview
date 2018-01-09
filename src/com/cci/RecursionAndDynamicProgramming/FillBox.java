package com.cci.RecursionAndDynamicProgramming;


public class FillBox {

    public static void main(String[] args) {

        boolean pixels[][] = {{false,false,false},{false,false,false},{false,false,false}};
        fillPixels(new Pixel(1,2),pixels);
        for (int i = 0;i<pixels.length;i++){
            for(int j=0;j<pixels[i].length;j++){
                System.out.print(pixels[i][j]+",");
            }
            System.out.println();

        }

    }

    static void fillPixels(Pixel pixel, boolean[][] pixels) {

        if(pixel.getX()< 0 || pixel.getX() >= pixels.length || pixel.getY()< 0 || pixel.getY() >= pixels.length){
            return;
        }

        if (pixels[pixel.getX()][pixel.getY()]) {
            return;
        }

        pixels[pixel.getX()][pixel.getY()] = true;
        int currx = pixel.getX();
        int curry = pixel.getY();
        Pixel p1 = new Pixel(currx-1, curry);
        Pixel p2 = new Pixel(currx+1, curry);
        Pixel p3 = new Pixel(currx, curry-1);
        Pixel p4 = new Pixel(currx, curry+1);

        fillPixels(p1,pixels);
        fillPixels(p2,pixels);
        fillPixels(p3,pixels);
        fillPixels(p4,pixels);


    }
}


class Pixel {

    private int x, y;

    Pixel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
