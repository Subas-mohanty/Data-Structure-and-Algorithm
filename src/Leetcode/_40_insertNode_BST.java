package Leetcode;

import Lecture_practice_problems._55_BinaryTree_Questions.TreeNode;
//https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
public class _40_insertNode_BST {
    public TreeNode insert(TreeNode root, int val){
        if(root == null) {
            return new TreeNode(val);
        }
        if(val < root.val){
            root.left = insert(root.left, val);
        }
        if(val > root.val){
            root.right = insert(root.right, val);
        }
        return root;
    }
}
