package Leetcode.Tree;
import Lecture_practice_problems._55_BinaryTree_Questions.TreeNode;
// https://leetcode.com/problems/evaluate-boolean-binary-tree/?envType=daily-question&envId=2024-05-16
public class _2331_evaluate_boolean_binaryTree {
  public boolean evaluateTree(TreeNode root) {
    if(root.left == null && root.right == null) return root.val == 1;
    // inorder traversal will be used
    boolean left = evaluateTree(root.left);
    int val = root.val;
    boolean right = evaluateTree(root.right);

    if(val == 2) return left || right;
    return left && right;
    }
}
