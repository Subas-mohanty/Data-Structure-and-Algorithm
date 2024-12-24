package Leetcode.Tree;

import Leetcode.TreeNode;

// https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/description/

public class _2096_directions_between_two_nodes_in_tree {
    public String getDirections(TreeNode root, int startValue, int destValue) {

        // sortest path in tree will go through the LCA(lowest common ancestors)
        // finding the length from lca to start and the path from lca to desti
        // then adding "U", length(lca to start) number of times
        // appending path from lca to desti to the ans

        StringBuilder path_to_s = new StringBuilder();
        StringBuilder path_to_d = new StringBuilder();
        TreeNode lca = LCA(root, startValue, destValue);
        findPath(lca, startValue, path_to_s);
        findPath(lca, destValue, path_to_d);
        int length = path_to_s.length();

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < length; i++){
            ans.append("U");
        }
        // for(int i = 0; i < path_to_d.length(); i++){
        //     ans.append(path_to_d.charAt(i));
        // }
        ans.append(path_to_d);
        return ans.toString();
    }
    public boolean findPath(TreeNode root, int target, StringBuilder sb){
        if(root == null) return false;
        if(root.val == target) return true;

        sb.append("L");
        if(findPath(root.left, target, sb)) return true;
        sb.setLength(sb.length() - 1); // deleting last character

        sb.append("R");
        if(findPath(root.right, target, sb)) return true;
        sb.setLength(sb.length() - 1); // deleting last character

        return false;
    }


    public TreeNode LCA(TreeNode root, int p, int q){
        if(root == null || root.val == p || root.val == q){
            return root;
        }
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);

        if(left != null && right != null){
            return root;
        }
        return left == null? right : left;
    }
}
