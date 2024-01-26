package Lecture_practice_problems._35_Recursion_08;

import java.util.Arrays;

public class _02_MazeAllPaths {
    public static void main(String[] args) {
        boolean [][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true},
        };
        int [][] path = new int[maze.length][maze[0].length];
         int [] count = {0};
//        int count =0;
        printPathAll("", maze, 0, 0, path, 1, count);
         System.out.println(Arrays.toString(count));
//        System.out.println(count);
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
        if (r > 0) {
            pathAll(p+'U',maze,r-1,c);
        }
        if (c>0) {
            pathAll(p+'L',maze,r,c-1);
        }
        // after every path we have to restore the maze for the next path so the changes we have made need to be reverted like this. This is backtracking
        maze[r][c]=true;

    }

    static void printPathAll(String p, boolean [][] maze, int r, int c, int [][] ans, int step, int[] count){
        if(r == maze.length-1 && c == maze[0].length-1){
            // if the end one is false then there is no path exist so, we are checking is when at the base condition or at the destination if that is false printing No path found and returning from there
            if(!maze[r][c]){
                System.out.println("No path found");
                return;
            }
            ans[r][c] = step;
            for(int [] element: ans){
                System.out.println(Arrays.toString(element));
            }
            System.out.println(p);
            System.out.println();
             count[0]=count[0]+1;
//            count = count +1; // this is not going to work as it is primitive and for the previous call it will be 0 so the final output will be 0
            return;
        }
        if(!maze[r][c]){
            return;
        }

        // the paths we are visiting we make the shells as false so we can't go back in that shell in that path
        maze[r][c] = false;
        ans[r][c] = step;
        // we have to do all the stuffs for this call
        // left
        if(c > 0){
            printPathAll(p + "L",maze,r, c-1, ans, step+1,count);
        }
        // right
        if(c < maze[0].length-1){
            printPathAll(p + "R",maze,r, c+1, ans, step+1, count);
        }
        // up
        if(r > 0){
            printPathAll(p + "U",maze,r-1, c, ans, step+1, count);
        }
        // down
        if(r <  maze.length-1){
            printPathAll(p + "D",maze,r+1, c, ans, step+1, count);
        }
        // we don't have to do step-1 because for the previous function call the step will be same
        // after every path we have to restore the maze for the next path so the changes we have made need to be reverted like this. This is backtracking
        maze[r][c] = true;
        ans[r][c] = 0;
    }
}
