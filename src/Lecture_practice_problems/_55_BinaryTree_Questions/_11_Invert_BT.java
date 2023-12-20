package Lecture_practice_problems._55_BinaryTree_Questions;

//https://leetcode.com/problems/invert-binary-tree/description/
public class _11_Invert_BT {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;

        return root;
    }
}
