package Leetcode;

import Lecture_practice_problems._55_BinaryTree_Questions.TreeNode;
//https://leetcode.com/problems/delete-node-in-a-bst/description/
public class _41_deleteNode_BST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        // found the node to be deleted
        if(root.val == key){
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                // if left or right is present then find the greater element than the root by going to right and then to the bottom left then make its left as current node's left and then return right of root , which will get connected to its previous node by recursion
                TreeNode temp = root.right;
                while(temp.left != null){
                    temp = temp.left;
                }
                // the smallest greater element than the root's left is connected to root's left
                temp.left = root.left;
                return root.right;
            }
        }
        if(root.val > key){
            // the value to be deleted lies in the left hand side so left recursion call
            root.left = deleteNode(root.left, key);
        }
        else{
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}
