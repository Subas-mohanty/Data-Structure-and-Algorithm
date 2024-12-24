package Lecture_practice_problems_kunal_kushwaha._35_Recursion_08;

import java.util.ArrayList;

//https://leetcode.com/problems/unique-paths/
public class _01_Maze {
    public static void main(String[] args) {
//        System.out.println(count(51,9));
//        printPath("",3,3);
//        System.out.println(pathRet("",3,3));
        System.out.println(pathRetDiagonal("",3,3));
        boolean [][] maze={
                {true,true,true},
                {true,false,true},
                {true,true,true},
        };
//        pathRestrictions("",maze,0,0);
    }
    static int count(int row, int col){
        if (row == 1 || col == 1) {
            return 1;
        }
        int left=count(row-1,col);
        int right=count(row,col-1);
        return left+right;
    }
    static void printPath(String p, int r, int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }
        if (r > 1) {
            printPath(p+'D',r-1,c);
        }
        if (c > 1) {
            printPath(p+'R',r,c-1);
        }
    }
    static ArrayList<String> pathRet(String p,int r, int c){
        if(r==1 && c==1){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list=new ArrayList<>();
        if (r > 1) {
            list.addAll(pathRet(p+'D',r-1,c));
        }
        if (c > 1) {
            list.addAll(pathRet(p+'R',r,c-1));
        }
        return list;
    }
    static ArrayList<String> pathRetDiagonal(String p,int r, int c){
        ArrayList<String> list=new ArrayList<>(); // instead of writing it in two places we can do it like this
        if(r==1 && c==1){
//            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
//        ArrayList<String> list=new ArrayList<>();
//        if (c > 3) {
//            list.addAll(pathRetDiagonal(p+'L',r,c+1));
//        }
        // this is for diagonal , we can't move diagonally if we are at last row or col , so row and col both should be greater than 1
        if (r > 1 && c > 1) {
            list.addAll(pathRetDiagonal(p+'d',r-1,c-1));
        }
        if (r > 1) {
            list.addAll(pathRetDiagonal(p+'D',r-1,c));
        }
        if (c > 1) {
            list.addAll(pathRetDiagonal(p+'R',r,c-1));
        }
        return list;
    }
    static void pathRestrictions(String p, boolean [][] maze, int r, int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if (!maze[r][c]) {
            return;
        }
        if (r <maze.length-1) {
            pathRestrictions(p+'D', maze, r+1,c);
        }
        if (c < maze[0].length-1) {
            pathRestrictions(p+'R',maze,r,c+1);
        }
    }
}
