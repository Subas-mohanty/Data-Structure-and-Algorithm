package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/create-binary-tree-from-descriptions/submissions/1321863803/?envType=daily-question&envId=2024-07-15
public class _2196_create_binary_tree_from_array {
    public TreeNode createBinaryTree(int[][] descriptions) {
        // store every value and it's treenode
        HashMap<Integer, TreeNode> map = new HashMap<>();

        // to store all the child node
        Set<Integer> children = new HashSet<>();

        for(int [] arr : descriptions){
            int parent = arr[0];
            int child = arr[1];
            int isLeft = arr[2];

            // Get or create TreeNode for parent node
            TreeNode parentNode = map.getOrDefault(parent, new TreeNode(parent));
            TreeNode childNode = map.getOrDefault(child, new TreeNode(child));


            if(isLeft == 1) parentNode.left = childNode;
            else parentNode.right = childNode;

            // Update the graph HashMap with parent and child nodes
            map.put(parent, parentNode);
            map.put(child, childNode);

            // Add child node to children set
            children.add(child);
        }

        // Find the root node (node with no parent, but exists in the graph)
        for(int node : map.keySet()){

            // returning the node which is present in map but not in children set, this means it is the root node
            if(!children.contains(node)){
                return map.get(node);
            }
        }
        return null;
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
