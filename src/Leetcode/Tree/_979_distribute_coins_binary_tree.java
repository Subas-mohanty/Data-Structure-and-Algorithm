package Leetcode.Tree;

import Leetcode.TreeNode;

//https://leetcode.com/problems/distribute-coins-in-binary-tree/description/?envType=daily-question&envId=2024-05-18
public class _979_distribute_coins_binary_tree {
    private int move = 0;
    public int distributeCoins(TreeNode root) {
        helper(root);
        return move;
    }
    // TC : O(n) --> for the DFS traversal
    // SC : O(n) --> recursion stack space
    public int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);

        // move = how many coins we need/have extra on left + how many coins we need/have extra on right
        move += Math.abs(left) + Math.abs(right);
        // returning the total number of coins needed for its child nodes + current node value - 1, this -1 is for, we will not take the current node's 1 coin into consideration
        return left + right + root.val -1;
    }
}
