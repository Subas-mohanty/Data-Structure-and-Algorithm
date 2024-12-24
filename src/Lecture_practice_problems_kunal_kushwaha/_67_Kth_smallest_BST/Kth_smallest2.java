package Lecture_practice_problems_kunal_kushwaha._67_Kth_smallest_BST;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class Kth_smallest2 {

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
}
