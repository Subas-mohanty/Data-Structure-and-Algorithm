package Lecture_practice_problems._55_BinaryTree_Questions;

//https://leetcode.com/problems/validate-binary-search-tree/
public class _13_Valid_BST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    // for every node we are storing the minimum value and maximum value, for left subtree the node value shouldn't be greater than the max and for right subtree the node value shouldn't be less than the min
    private boolean helper(TreeNode node, Integer min, Integer max){
        if(node == null){
            return true;
        }
        // min is actually the root element and it is for right calls, which means any right element should not be lesser than the min and if so then return false
        if(min!= null && node.val <= min){
            return false;
        }
        // max is actually the root element and it is for left calls, which means any right element should not be lesser than the min and if so then return false
        if(max!= null && node.val >= max){
            return false;
        }
        boolean left=helper(node.left, min, node.val);
        boolean right = helper(node.right, node.val, max);

        return left && right;
    }
}
