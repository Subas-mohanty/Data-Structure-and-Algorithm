package Lecture_practice_problems._55_BinaryTree_Questions;
//https://leetcode.com/problems/binary-tree-maximum-path-sum/
// DSA-01 : 25-12-2023
public class _17_MaxPathSum {
    int ans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }
    public int helper(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);

        // this is to ignore the negative numbers
        // when we have -ve number in the node, we have to ignore them otherwise they will reduce the max sum in their respective path so we have to make them 0
        left=Math.max(left,0);
        right = Math.max(right, 0);

        int pathSum = left + right + node.val;
        ans = Math.max(ans, pathSum);

        return node.val + Math.max(left, right);
    }
}
