package Leetcode;

import Lecture_practice_problems._55_BinaryTree_Questions.TreeNode;

// https://leetcode.com/problems/delete-leaves-with-a-given-value/description/?envType=daily-question&envId=2024-05-17

public class _1325_delete_leaves_with_given_value {
  public TreeNode removeLeafNodes(TreeNode root, int target) {
    if(root == null) return null;

    root.left = removeLeafNodes(root.left, target);
    root.right = removeLeafNodes(root.right, target);

    if(root.left == null && root.right == null) return root.val == target ? null : root;
    return root;
  }
}
