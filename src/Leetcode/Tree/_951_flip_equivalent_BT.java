package Leetcode.Tree;
import Leetcode.TreeNode;

public class _951_flip_equivalent_BT {
    // TC : O(n)
    // SC : O(2*n)
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;

        // normal case, if the tree is not flipped then check for normal case, whether left and right subtrees are equal or not
        boolean isSame = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        if(isSame) return true;

        // flip case
        // if left and right are not equal then check for flipped case
        return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
    }
}
