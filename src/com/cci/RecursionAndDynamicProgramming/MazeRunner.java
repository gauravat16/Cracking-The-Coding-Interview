package com.cci.RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;

class MazeRunner {

    static boolean getPath(boolean[][] maze, HashMap<Point, Boolean> cache, ArrayList<Point> path, int r, int c) {

        boolean SUCCESS = false;

        if (r < 0 || c < 0 || !maze[r][c]) {
            return false;
        }

        Point p = new Point(r, c);

        if (cache.containsKey(p)) {
            return cache.get(p);
        }

        boolean isAtOrigin=(r==0) && (c==0);

        if (isAtOrigin || getPath(maze, cache, path, r - 1, c) || getPath(maze, cache, path, r, c - 1)) {
            System.out.println(p.toString());
            path.add(p);
            SUCCESS = true;
        }

        cache.put(p, SUCCESS);
        return SUCCESS;
    }

    public static void main(String[] args) {

        boolean[][] maze = new boolean[][]{
                {true, true, true, true, true, true},
                {true, true, true, true, true, true},
                {true, true, true, true, true, true},
                {true, true, true, true, true, true},
                {true, true, true, true, true, true}
        };

        HashMap<Point, Boolean> cache = new HashMap<>();
        ArrayList<Point> path = new ArrayList<>();
        getPath(maze,cache,path,maze.length -1,maze[0].length -1);
        for (Point p : path){

            //System.out.println(p.toString()+"\t");
        }

    }


}


class Point {

    int r, c;

    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public String toString() {
        return "("+this.r+","+this.c+")";
    }

    @Override
    public boolean equals(Object obj) {
        Point comparedPoint = (Point) obj;
        return (comparedPoint.c == this.c && comparedPoint.r == this.r) ? true : false;
    }
}
