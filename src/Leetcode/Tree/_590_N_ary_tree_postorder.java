package Leetcode.Tree;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/?envType=daily-question&envId=2024-08-26
public class _590_N_ary_tree_postorder {

    // TC : O(n)
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        if(root != null) list.add(root.val);
        return list;
    }
    // this function will not gonna add the root of the tree, because we are adding all the children inside the loop and the root will never be a children so it will not gonna be in the list
    void helper(Node root, List<Integer> list){
        if(root == null) return;

        for(Node node : root.children){
            helper(node, list);
            list.add(node.val);
        }
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
