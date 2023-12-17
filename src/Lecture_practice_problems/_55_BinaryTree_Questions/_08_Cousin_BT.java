package Lecture_practice_problems._55_BinaryTree_Questions;
//https://leetcode.com/problems/cousins-in-binary-tree/
public class _08_Cousin_BT {

    // find the x and y nodes and then check whether they are sibling or not , if yes return false otherwise return true
    public boolean isCousins(TreeNode node, int x, int y) {
        TreeNode xx = findNode(node,x);
        TreeNode yy = findNode(node,y);

        return (
                (level(node,xx,0) == level(node,yy,0) && !isSibling(node,xx,yy))
        );
    }

    boolean isSibling(TreeNode node, TreeNode xx, TreeNode yy){
        if(node == null){
            return false;
        }
        return (
                (node.left==xx && node.right==yy) || (node.left==yy && node.right==xx) || (isSibling(node.left,xx,yy)) ||(isSibling(node.right,xx,yy))
        );
    }

    int level(TreeNode node,TreeNode xx, int lev){
        if(node == null){
            return 0;
        }
        if(node == xx){
            return lev;
        }
        int l=level(node.left, xx, lev+1);
        if(l!=0){
            return l;
        }
        return level(node.right, xx, lev+1);
    }

    public TreeNode findNode(TreeNode node, int x){
        if(node == null){
            return null;
        }
        if(node.val==x){
            return node;
        }
        // return findNode(node.left,x); // we can't do this because the next statement will be unreachable so we did something like this
        // this is only to avoid the error occuring previously
        // if the node is not present in the left hand side then at the leaf it will be null so the if condition will not be exucuted
        TreeNode n= findNode(node.left,x);
        if(n!=null){
            return n;
        }
        return findNode(node.right,x);
    }
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
}
