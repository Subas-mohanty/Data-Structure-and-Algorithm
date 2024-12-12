package Leetcode.DP;
//https://leetcode.com/problems/unique-binary-search-trees/
public class _96_unique_BST {
    public int numTrees(int n) {
        Integer [] dp = new Integer[n + 1];
        // return helper(n, dp);

        int [] d = new int[n + 1];
        d[0] = 1;
        d[1] = 1;
        for(int i = 2; i <= n; i++){
            int count = 0;
            for(int j = 1; j <= n; j++){
                int left = d[j - 1];
                int right = 1;
                if(i >= j) right = d[i - j];
                count += left * right;
            }
            d[i] = count;
        }
        return d[n];
    }
    // this is problem to find the catalan number
    // formula is f(n) = sum of[f(i - 1) * f(n-i)] , i goes from 1 to n
    // but we will find why it will work here
    // for BST, if we take any number i as the root then there will be exactly i-1 nodes on the left and n- i nodes on right, now to find the total number of combinations, we can multiply them
    // we can make every value from 1 to n as root and find its left subtree ans and right subtree ans by recursion
    // TC : O(N^2) --> n for loop and n for recursion
    // SC : O(N)
    int helper(int n, Integer [] dp){
        if(n <= 1) return 1;

        if(dp[n] != null) return dp[n];
        int count = 0;
        for(int i = 1; i <= n; i++){
            int left = helper(i - 1, dp);
            int right = helper(n - i, dp);
            count += left * right;
        }
        return dp[n] = count;
    }
}
