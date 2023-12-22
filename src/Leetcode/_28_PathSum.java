package Leetcode;

import Lecture_practice_problems._55_BinaryTree_Questions.TreeNode;
//https://leetcode.com/problems/path-sum/
public class _28_PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val=5;
        root.left = new TreeNode();
        root.left.val=4;
        root.right = new TreeNode();
        root.right.val=8;
        root.left.left = new TreeNode();
        root.left.left.val=11;
        root.right.left = new TreeNode();
        root.right.left.val=13;
        root.right.right = new TreeNode();
        root.right.right.val=4;
        root.left.left.left = new TreeNode();
        root.left.left.left.val=7;
        root.left.left.right = new TreeNode();
        root.left.left.right.val=2;
        root.right.right.right = new TreeNode();
        root.right.right.right.val=1;

        boolean ans = hasPathSum(root, 22);
        System.out.println(ans);
    }
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum , 0);
    }
    public static boolean helper(TreeNode node, int target, int sum ){
        if(node == null){
            return false;
        }
        if(node.left == null && node.right == null){
            if((sum + node.val)==target){
                return true;
            }
            return false;
        }
        return helper(node.left, target, sum+node.val) || helper(node.right, target, sum+node.val);
    }
}
