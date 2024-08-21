package Leetcode.DP.Game_Strategy;

import java.util.Arrays;
//https://leetcode.com/problems/stone-game-ii/description
//https://www.youtube.com/watch?v=9f1vzDFVnGA
public class _1140_stone_game_2 {
    int n;
    int [][][] dp = new int[2][101][101];
    public int stoneGameII(int[] piles) {
        n = piles.length;
        for(int [][] arr : dp){
            for(int [] a : arr) Arrays.fill(a, -1);
        }
        return solve(piles, 1, 1, 0, dp);
    }
    int solve(int [] arr, int person, int m, int ind, int [][][] dp){
        if(ind >= n) return 0;

        int total = 0;
        // taking the max value depending on alice and bob
        int max = (person == 1) ? -1 : Integer.MAX_VALUE;

        if(dp[person][m][ind] != -1) return dp[person][m][ind];
        // going from 1 to 2 * m, said in the question, and the ind + x is for out of bound
        for(int x = 1; x <= m*2 && ind + x <= n; x++){

            // finding the total value a player can make
            // we took x number of elements, so we are at index = index + x, but for 0 based indexing we are subtracting 1 from it
            total += arr[ind + x - 1];

            // in game strategy we try to maximize the point of ours and minimize the points of opponent, that's what we are doing here
            // maximizing result for alice while minimizing for bob
            // for alice we are taking the total value because we want the max result
            if(person == 1) { // Alice
                // updating m as max(m, x), told in the question
                // updating index to index + x, because when we take x, this means we can take x number of elements and we will reach at ind = ind + x
                // after taking it for alice we are changing the person to bob
                max = Math.max(max, total + solve(arr, 0, Math.max(m, x), ind + x, dp));
            }

            // for bob we are not taking the total , because we want min result
            else{ // Bob
                max = Math.min(max, solve(arr, 1, Math.max(m, x), ind + x, dp));
            }
        }
        return dp[person][m][ind] = max;
    }
}
