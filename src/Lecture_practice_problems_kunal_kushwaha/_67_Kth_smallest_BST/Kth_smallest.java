package Lecture_practice_problems_kunal_kushwaha._67_Kth_smallest_BST;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class Kth_smallest {
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
    public int kthSmallest(TreeNode node, int k) {
        int ans=0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        helper(node,k,minHeap);

        //for kth element
        for(int i=0;i<k;i++){
            ans=minHeap.poll();
        }
        return ans;

    }
    // inorder traversal to sort the BST, and store the values in a minHeap
    private void helper(TreeNode node, int k, PriorityQueue<Integer> minHeap){
        if(node==null){
            return;
        }
        helper(node.left,k,minHeap);

        minHeap.offer(node.val);

        helper(node.right,k,minHeap);
    }
}
