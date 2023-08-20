package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _03_N_queens {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
    static List<List<String>> solveNQueens(int n) {
        List<List<String>> list=new ArrayList<>();
        char[][] board=new char[n][n];
        return helper(list,board,0);
    }
    static List<List<String>> helper(List<List<String>> list,char[][] board,int row){
        if(row==board.length){
            saveBoard(list,board);
            return list;
        }
        for(int col=0; col<board.length; col++) {
            if(isSafe(board,row, col)) {
                board[row][col] = 'Q';
                helper(list,board, row+1);
                board[row][col] = '.';
            }
        }
        return list;
    }

    private static void saveBoard(List<List<String>> list, char[][] board) {
        List<String> localList=new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String p="";
            for (int j = 0; j < board.length; j++) {
                if(board[i][j]=='Q'){
                    p+='Q';
                }
                else{
                    p+='.';
                }
            }
            localList.add(p);
        }
        list.add(localList);
    }

    // function to check the position we want to put the queen is safe or not
    private static boolean isSafe(char[][] board, int row, int col) {
        // for vertical
        for (int i = 0; i <= row; i++) {
            if(board[i][col]=='Q'){
                return false;
            }
        }
        
        // for diagonal left
        int maxLeft=Math.min(row,col);
        for (int i = 0; i <= maxLeft ; i++) {
            if(board[row-i][col-i]=='Q'){
                return false;
            }
        }

        // for diagonal right
        int maxRight=Math.min(row,board.length-col-1);
        for (int i = 0; i <= maxRight ; i++) {
            if(board[row-i][col+i]=='Q'){
                return false;
            }
        }
        return true;
    }
}
