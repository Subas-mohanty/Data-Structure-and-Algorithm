package Lecture_practice_problems._55_BinaryTree_Questions;

//https://leetcode.com/problems/symmetric-tree/
public class _09_SymmetricBT {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
    private boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        return (
                (left.val == right.val) && helper(left.left, right.right) && helper(left.right, right.left)
        );
    }
}
