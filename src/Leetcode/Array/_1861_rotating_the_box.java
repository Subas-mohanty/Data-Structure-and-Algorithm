package Leetcode.Array;

import java.util.Arrays;
//https://leetcode.com/problems/rotating-the-box/description/?envType=daily-question&envId=2024-11-23

public class _1861_rotating_the_box {

    public static void main(String[] args) {
        char[][] box = {
                {'#', '.', '*', '.'},
                {'#', '#', '*', '.'}
        };
        char [][] ans = rotateTheBox(box);
        for(char [] a : ans){
            System.out.println(Arrays.toString(a));
        }
    }

    // TC : O(n * m * m)
    // SC : O(n*m) --> asked in the question
    public static char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;

        for(int i = 0; i < n; i++){
            for(int j = m-1; j >= 0; j--){
                // when we get a leaf, move to the right most possible place
                if(box[i][j] == '#') moveRight(i, j, box);
            }
        }


        char [][] ans = new char[m][n];
        // rotate the box by 90 degree,
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // changing the row and col
                ans[j][n - i - 1] = box[i][j];
            }
        }
        return ans;
    }
    static void moveRight(int row, int col, char [][] box){
        int m = box[0].length;
        int i = col+1; // start from the next col, in which the leaf is present
        if(i < m){
            if(box[row][i] == '#' || box[row][i] == '*') return; // if the next col is either another leaf or stone then we can't move it right anymore, because we are moving the leaves from right side of the box, so for any leaf , leaves on its right side will be correctly placed
            while(i < m && box[row][i] == '.') i++; // if next place is blank then move further
            // change the value, the index the leaf should present is marked with '#" and the place it was, marked with '.' means it becomes blank now
            box[row][i-1] = '#';
            box[row][col] = '.';
//            break; // after placing it in its right place, no need to go further
        }
    }}
