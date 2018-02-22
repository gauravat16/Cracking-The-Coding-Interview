package com.cci.Sorting.questions;

import java.awt.*;

public class Q10 {

    public static void main(String[] args) {


        int[][] mat = { {15, 20, 70, 85},
                        {20, 35, 80, 95},
                        {30, 55, 95, 105},
                        {40, 80, 100, 120} };

        System.out.println("For a value that exists - " + searchForValue(mat,95));
        System.out.println("For a value that doesn't exist - " + searchForValue(mat,5));
    }


    static Point searchForValue(int[][] mat, int val) {
        int row = 0;
        int col = mat[mat.length - 1].length - 1;

        while (row < mat.length && col >= 0) {
            if (mat[row][col] == val) {
                return new Point(row, col);
            }

            if (mat[row][col] > val) {
                col--;
            } else {
                row++;
            }
        }

        return new Point(-1, -1);
    }
}
