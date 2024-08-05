package Leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/filling-bookcase-shelves/?envType=daily-question&envId=2024-07-31
public class _1105_filling_bookcase_shelves {
    int totalWidth;
    public int minHeightShelves(int[][] books, int shelfWidth) {
        totalWidth = shelfWidth;
        return helper(0, books, shelfWidth, 0);
    }
    public int helper(int i, int [][] books, int shelfWidth, int shelfHeight){

        int bookWidth = books[i][0];
        int bookHeight = books[i][1];
        int maxHeight = Math.max(shelfHeight, bookHeight);
        // base case
        if(i == books.length - 1){
            // if we can put that in the same shelf
            if(bookWidth <= shelfWidth) return maxHeight;
            // put the book in a new shelf
            return shelfHeight + bookHeight;
        }
        int sameShelf = (int)1e9;
        if(bookWidth <= shelfWidth){
            sameShelf = helper(i+1, books, shelfWidth - bookWidth, maxHeight);
        }
        // we are calculating the height of every shell not the whole shelves that's why in this recursion call the last parameter will be only bookHeight not shelfHeight + bookHeight
        int newShelf = shelfHeight + helper(i+1, books, totalWidth - bookWidth, bookHeight);
        return Math.min(sameShelf, newShelf);
    }



    // memoization
//    int totalWidth;
    public int minHeightShelves2(int[][] books, int shelfWidth) {
        totalWidth = shelfWidth;
        int [][] dp = new int[books.length][shelfWidth+1];
        for(int [] arr : dp){
            Arrays.fill(arr, -1);
        }
        return helper(0, books, shelfWidth, 0, dp);
    }
    public int helper(int i, int [][] books, int shelfWidth, int shelfHeight, int [][] dp){

        int bookWidth = books[i][0];
        int bookHeight = books[i][1];
        int maxHeight = Math.max(shelfHeight, bookHeight);
        // base case
        if(i == books.length - 1){
            // if we can put that in the same shelf
            if(bookWidth <= shelfWidth){
                return maxHeight;
            }
            // put the book in a new shel
            return shelfHeight + bookHeight;
        }
        if(dp[i][shelfWidth] != -1) return dp[i][shelfWidth];
        int sameShelf = (int)1e9;
        if(bookWidth <= shelfWidth){
            sameShelf = helper(i+1, books, shelfWidth - bookWidth, maxHeight, dp);
        }
        int newShelf = shelfHeight + helper(i+1, books, totalWidth - bookWidth, bookHeight, dp);
        return dp[i][shelfWidth] = Math.min(sameShelf, newShelf);
    }


//    int totalWidth;
    public int minHeightShelves3(int[][] books, int shelfWidth) {
        totalWidth = shelfWidth;
        int [][] dp = new int[books.length][shelfWidth+1];
        return helper2(books, shelfWidth, 0, dp);
    }
    public int helper2(int [][] books, int shelfWidth, int shelfHeight, int [][] dp){

        int n = books.length;
        dp[books.length][0] = 0;

        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j <= shelfWidth; j++){
                int bookWidth = books[i][0];
                int bookHeight = books[i][1];
                if(bookWidth <= j){
                    dp[i][j] = Math.min(dp[i][j], dp[i+1][j-bookWidth] + bookWidth);
                }
                dp[i][0] = Math.min(dp[i][0], dp[i + 1][shelfWidth] + bookHeight);
            }
        }
        return dp[0][0];
    }
}
