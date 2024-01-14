package Leetcode;
import Lecture_practice_problems._55_BinaryTree_Questions.TreeNode;
//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

public class _43_BST_from_preorder {
    public TreeNode bstFromPreorder(int[] preorder) {
//        the array is only used for passing the index
        return helper(preorder, Integer.MAX_VALUE, new int[]{0});
    }
    TreeNode helper(int [] preorder, int bound, int [] index){
        // base case
//        the base states that when we are checking for the values in the preorder array if the index get out of bound then return null or if at any point of time the value at the index is greater than the bound then also return null
        if(index[0] == preorder.length || preorder[index[0]] > bound){
            return null;
        }
        TreeNode root = new TreeNode(preorder[index[0]]);
        index[0]++;

//        when going left the bound or the max value is that node's value but for right the max value is it's previous node's value and for root it is Integer.MAX because in right the value can be anthing bigger than the node's value , but in left the value can't be greater than that node's value
        root.left = helper(preorder, root.val, index);
        root.right = helper(preorder, bound, index);

        return root;
    }
}
