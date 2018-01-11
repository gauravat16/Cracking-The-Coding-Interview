package com.cci.RecursionAndDynamicProgramming;

import java.util.Arrays;

public class EightQueens {

    /**
     * Sample output
     *
     [[2, 1, 1, 1, 1, 1, 1, 1],
     [1, 1, 2, 1, 1, 1, 1, 1],
     [1, 1, 1, 1, 2, 1, 1, 1],
     [1, 2, 1, 1, 1, 1, 1, 1],
     [1, 1, 1, 2, 1, 1, 1, 1],
     [1, 1, 1, 1, 1, 1, 1, 1],
     [1, 1, 1, 1, 1, 1, 1, 1],
     [1, 1, 1, 1, 1, 1, 1, 1]]
     */

    static int MARKED = 1;
    static int QUEEN = 2;

    public static void main(String[] args) {
        int[][] chessboard = {{0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}};


        for (int row = 0;row<chessboard.length;row++){
            for (int col = 0;col<chessboard[row].length;col++){
                placeQueen(new Pixel(row, col), chessboard);

            }

        }
      System.out.println(Arrays.deepToString(chessboard));


    }

    static void placeQueen(Pixel pixel, int[][] chessboard) {
        if (pixel.getX() < 0 || pixel.getY() < 0) {
            return;
        }
        if (chessboard[pixel.getX()][pixel.getY()] == MARKED || chessboard[pixel.getX()][pixel.getY()] == QUEEN) {
            return;
        }


        chessboard[pixel.getX()][pixel.getY()] = QUEEN;

        chessboard = markRowsAndCols(pixel, chessboard);
        chessboard = markDiagA(pixel, chessboard);
        chessboard = markDiagB(pixel, chessboard);



    }


    static int[][] markRowsAndCols(Pixel p, int[][] chessboard) {
        for (int i = 0; i < chessboard[0].length; i++) {
            if (chessboard[p.getX()][i] != QUEEN) {
                chessboard[p.getX()][i] = MARKED;
            }

            if (chessboard[i][p.getY()] != QUEEN) {
                chessboard[i][p.getY()] = MARKED;
            }

        }

        return chessboard;
    }


    static int[][] markDiagA(Pixel p, int[][] chessboard) {

        int rows = p.getX();
        int col = p.getY();
        while (rows >= 0 && col >= 0) {
            if (chessboard[rows][col] != QUEEN) {
                chessboard[rows][col] = MARKED;

            }
            rows--;
            col--;
        }

        rows = p.getX();
        col = p.getY();

        while (rows < chessboard.length && col < chessboard[rows].length) {
            if (chessboard[rows][col] != QUEEN) {
                chessboard[rows][col] = MARKED;

            }
            rows++;
            col++;
        }

        return chessboard;

    }


    static int[][] markDiagB(Pixel p, int[][] chessboard) {

        int rows = p.getX();
        int col = p.getY();
        while (rows < chessboard.length && col >= 0) {
            if (chessboard[rows][col] != QUEEN) {
                chessboard[rows][col] = MARKED;

            }
            rows++;
            col--;
        }

        rows = p.getX();
        col = p.getY();

        while (rows >= 0 && col < chessboard[rows].length) {
            if (chessboard[rows][col] != QUEEN) {
                chessboard[rows][col] = MARKED;

            }
            rows--;
            col++;
        }

        return chessboard;

    }


}
