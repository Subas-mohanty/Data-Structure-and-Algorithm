package Leetcode.Tree;

import Leetcode.TreeNode;

// https://leetcode.com/problems/balanced-binary-tree/description/

public class _110_Balanced_binary_tree {
    public static void main(String[] args) {

    }
    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        // function to calculate the height
        public int height(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int leftHeight = 1 + height(node.left);
            int rightHeight = 1 + height(node.right);
            ;

            return Math.max(leftHeight, rightHeight);
        }
    }
}
