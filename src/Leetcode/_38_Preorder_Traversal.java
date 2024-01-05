package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/binary-tree-preorder-traversal/
//TC:O(N) - traversing all nodes once
//SC: O(N) - for stack
public class _38_Preorder_Traversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> preorderTraversal(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if(node == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode currentNode = stack.pop();
            list.add(currentNode.val);
            if(currentNode.right != null){
                stack.push(currentNode.right);
            }
            if(currentNode.left != null){
                stack.push(currentNode.left);
            }
        }
        return list;
    }

/*  // Recursive approach
    public List<Integer> preorderTraversal(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        preOrder(node,list);
        return list;
    }
    public void preOrder(TreeNode node, List<Integer> list){
        if(node==null){
            return;
        }
        list.add(node.val);
        preOrder(node.left,list);
        preOrder(node.right,list);
    }
*/
}
