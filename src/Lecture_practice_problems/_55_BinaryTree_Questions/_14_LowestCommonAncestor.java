package Lecture_practice_problems._55_BinaryTree_Questions;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class _14_LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {

        // use this type of bitwise operator for faster time complexity
        // in the root if we find p or q then we will directly return because it will be the ancenstor of the other element no matter where it is present
        if(node == null || node== p || node == q){
            return node;
        }
        TreeNode left = lowestCommonAncestor(node.left, p, q);
        TreeNode right = lowestCommonAncestor(node.right, p, q);

        // this means we find both p and q , in left and right of the node so the ancestor is that node, it is the answer
        if(left != null && right != null){
            return node;
        }
        // after traversing the whole tree
        // if left is null means the other node is in below subtree of right so the answer is right
        // if right is null that means the other node is in the below subtree of left so left is the answer
        return left==null? right:left;
    }
}
