package Leetcode;

import Lecture_practice_problems._55_BinaryTree_Questions.TreeNode;
//https://leetcode.com/problems/search-in-a-binary-search-tree/description/
public class _39_SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        TreeNode left = searchBST(root.left, val);
        if(left != null){
            return left;
        }
        return searchBST(root.right, val);
    }
}
