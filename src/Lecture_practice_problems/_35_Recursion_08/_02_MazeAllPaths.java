package Lecture_practice_problems._35_Recursion_08;

import java.util.Arrays;

public class _02_MazeAllPaths {
    public static void main(String[] args) {
        boolean [][] maze={
                {true,true,true},
                {true,true,true},
                {true,true,true},
        };
        int [][] path=new int[maze.length][maze[0].length];
        printPathAll("",maze,0,0, path,1);
    }
    static void pathAll(String p, boolean [][] maze, int r, int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if (!maze[r][c]) {
            return;
        }
        // the paths we are visiting we make the shells as false so we can't go back in that shell in that path
        maze[r][c]=false;

        if (r <maze.length-1) {
            pathAll(p+'D', maze, r+1,c);
        }
        if (c < maze[0].length-1) {
            pathAll(p+'R',maze,r,c+1);
        }
        if (r>0) {
            pathAll(p+'U',maze,r-1,c);
        }
        if (c>0) {
            pathAll(p+'L',maze,r,c-1);
        }
        // after every path we have to restore the maze for the next path so the changes we have made need to be reverted like this
        maze[r][c]=true;

    }

    static void printPathAll(String p, boolean [][] maze, int r, int c, int[][] path, int step){
        if(r==maze.length-1 && c==maze[0].length-1){
            path[r][c]=step;
            for (int []element:path){
                System.out.println(Arrays.toString(element));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if (!maze[r][c]) {
            return;
        }
        // the paths we are visiting we make the shells as false so we can't go back in that shell in that path
        maze[r][c]=false;
        path[r][c]=step;

        if (r <maze.length-1) {
            printPathAll(p+'D', maze, r+1,c, path, step+1);
        }
        if (c < maze[0].length-1) {
            printPathAll(p+'R',maze,r,c+1, path, step+1);
        }
        if (r>0) {
            printPathAll(p+'U',maze,r-1,c, path, step+1);
        }
        if (c>0) {
            printPathAll(p+'L',maze,r,c-1, path, step+1);
        }
        // after every path we have to restore the maze for the next path so the changes we have made need to be reverted like this
        maze[r][c]=true;
        path[r][c]=0;

    }
}
