package Lecture_practice_problems_kunal_kushwaha._36_Recursion_09;
import java.util.ArrayList;
import java.util.List;
// DSA-01: 27-01-2024
public class NQueens {
    public static void main(String[] args) {
//        boolean[][] board = {
//                {false, false, false, false},
//                {false, false, false, false},
//                {false, false, false, false},
//                {false, false, false, false},
//        };
        int n = 4;
        boolean [][] board = new boolean[n][n];
        System.out.println(queens(board,0));
        List<List<String>> ans = solveNQueens(4);
        for(List<String> list : ans){
            System.out.println(list);
        }
    }
    static int queens(boolean [][] board, int row){
        if(row == board.length){
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if(isSafe(board, row , col)){
                board[row][col] = true;
                count = count + queens(board, row+1);
                board[row][col] = false;
            }
            // when it is not safe to place a queen in [row][col] we are only incrementing the col with the loop, not calling any recursion until we found a safe place to place the queen, after placing it we are calling recursion
        }
        return count;
    }

    // look at the note to understand this function
    private static boolean isSafe(boolean [][] board, int row , int col) {
        // for going up
        for (int i = 0; i < row ; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        // for going left diagonal
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if(board[row-i][col-i]){
                return false;
            }
        }
        // for going right diagonal
        int maxRight = Math.min(row, board.length-col-1);
        for (int i = 1 ; i <= maxRight; i++) {
            if(board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }

    private static void display(boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j]){
                    System.out.print("Q ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        boolean [][] board = new boolean[n][n];
        queen(board, 0, list);
        return list;
    }
    static void queen(boolean [][] board, int row, List<List<String>> list){
        if(row == board.length){
            list.add(makeList(board));
        }
        for (int col = 0; col < board.length; col++) {
            if(isSafe(board, row , col)){
                board[row][col] = true;
                queen(board, row+1, list);
                board[row][col] = false;
            }
        }
    }

    private static List<String> makeList(boolean[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String p="";
            for (int j = 0; j < board.length; j++) {
                if(board[i][j]){
                    p=p+"Q";
                }
                else{
                    p=p+".";
                }
            }
            list.add(p);
        }
        return list;
    }
}
