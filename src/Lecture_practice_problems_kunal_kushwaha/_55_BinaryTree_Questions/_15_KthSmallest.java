package Lecture_practice_problems_kunal_kushwaha._55_BinaryTree_Questions;

import java.util.ArrayList;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/submissions/
public class _15_KthSmallest {
//    TC: O(N) -- for recursion
//    SC: O(1)
    private int k;
    private int ans=0;
    public int kthSmallest(TreeNode node, int k) {
        this.k=k;
        helper(node);
        return ans;
    }
    // inorder traversal to sort the BST, and store the values in a minHeap
    private void helper(TreeNode node){
        if(node==null){
            return;
        }
        helper(node.left);
        // after reaching at the smallest element we started reducing the k value with 1 so that when the k value will be 0 , we will be at our answer
        k--;
        if(k==0){
            ans=node.val;
        }

        helper(node.right);
    }

//    TC: O(N) -- for recursion
//    SC: O(N) -- for arraylist
    public int kthSmallest2(TreeNode node, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(node, list);
        return list.get(k-1);
    }
    public void helper(TreeNode node, ArrayList<Integer> list ){
        if(node == null){
            return;
        }
        // inorder traversal
        helper(node.left, list);
        list.add(node.val);
        helper(node.right, list);
    }
}
