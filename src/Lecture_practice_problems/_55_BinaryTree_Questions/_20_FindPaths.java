package Lecture_practice_problems._55_BinaryTree_Questions;

import java.util.ArrayList;
import java.util.List;

public class _20_FindPaths {

    // put in a list
    List<List<Integer>> findPaths(TreeNode node, int target) {
        List<List<Integer>> paths = new ArrayList<>(); // adding all the path list in the ans list , one object and same reference so this object will be modified
        List<Integer> path = new ArrayList<>(); // same for this
        helper(node, target, path, paths);
        return paths; // at the end returning the ans list
    }
    void helper(TreeNode node, int target, List<Integer> path, List<List<Integer>> paths) {
        if(node == null) {
            return;
        }
        path.add(node.val);

        // when we find that the sum is node.val which means from root to that leaf node there is a path then we create a new list with path and then add it to the paths(ans list)
        if (node.val == target && node.left == null && node.right == null) {
            paths.add(new ArrayList<>(path));
        } else {
            // everytime we go to left and right we subtract node.val from sum to check when we are at the leaf node we got our path or not
            helper(node.left, target-node.val, path, paths);
            helper(node.right, target-node.val, path, paths);
        }

        // backtrack
        path.remove(path.size() - 1);
    }
}
