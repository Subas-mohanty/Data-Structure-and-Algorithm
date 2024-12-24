package Lecture_practice_problems_kunal_kushwaha._55_BinaryTree_Questions;

//https://leetcode.com/problems/diameter-of-binary-tree/
public class _10_Diametre_BT {
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
    int diametre=0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diametre-1;
    }
    // calculating height of the tree
    private int height(TreeNode node){
        if(node == null){
            return 0;
        }
        int left=height(node.left);
        int right=height(node.right);

        int dia= left+right+1;
        // diametre is equal to longest path so it is left+right+1, 1 for that node
        diametre=Math.max(diametre, dia);

        return Math.max(left, right) +1;
    }
}
