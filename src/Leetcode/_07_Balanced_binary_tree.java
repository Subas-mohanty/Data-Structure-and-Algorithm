package Leetcode;
import Lecture_practice_problems._49_BinaryTree_01.BinaryTree.Node;

public class _07_Balanced_binary_tree {
    public static void main(String[] args) {

    }
    class Solution {
        public boolean isBalanced(Node root) {
            if (root == null) {
                return true;
            }
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        // function to calculate the height
        public int height(Node node) {
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
