package Lecture_practice_problems_kunal_kushwaha._55_BinaryTree_Questions;
//https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class _16_SumRoot_to_leaf {
    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        node.val=1;
        node.left = new TreeNode();
        node.left.val =0;
        System.out.println(sumNumbers(node));
    }
    public static int sumNumbers(TreeNode root) {
        int sum =0;
        return helper(root, sum);
    }
    public static int helper(TreeNode node, int sum){
        if(node == null ){
            return 0; // don't use sum here , because when right is null it will add the sum that we don't want
        }
        sum=(sum*10)+node.val;
        if(node.left == null && node.right == null){
            return sum;
        }
//        int left = helper(node.left, sum);
//        int right = helper(node.right, sum);
//        sum=left+right;
//        return sum;
        return helper(node.left, sum) + helper(node.right, sum);
    }
}
