package Leetcode.Tree;

import Leetcode.TreeNode;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
public class _106_construct_BT_from_inorder_and_postorder {
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;
        index = n - 1; // going from left to right, as it is a postorder
        for(int i = 0; i< n; i++){
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, n - 1, map);
    }
    TreeNode helper(int [] in, int [] post, int left, int right, Map<Integer, Integer> map){
        // no left or right is present
        if(left > right) return null;
        int curr = post[index--];
        // find the current node's index in the inorder array, stored in a map to get in O(1) time
        int inIndex = map.get(curr);
        TreeNode node = new TreeNode(curr);
        // if this is the single node
        if(left == right) return node;

        // first processing right, because for post order, we have left-right-node, so we will get node then right and then left, and we are going from right to left, so processing right first
        node.right = helper(in, post, inIndex + 1, right, map);
        node.left = helper(in, post, left, inIndex - 1, map);

        return node;
    }
}
