package Leetcode.Tree;
import Leetcode.TreeNode;
//https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/description/?envType=daily-question&envId=2024-10-26
public class _2458_height_after_subtree_removal {

    // TC : O(m * n)
    // SC : O(m + n) --> ans array + recursion stack
    int max;
    public int[] treeQueries2(TreeNode root, int[] queries) {
        int [] arr = new int[queries.length];
        int ind = 0;
        for(int a : queries){
            max = 0;
            // finding height for each node in the queries array after removing it
            helper(root, a, 0);
            arr[ind++] = max;
        }
        return arr;
    }
    void helper(TreeNode root, int target, int height){
        if(root == null) return;

        if(root.val == target){
            max = Math.max(max, height-1);
            return;
        }
        if(root.left == null && root.right == null){
            max = Math.max(max, height);
            return;
        }

        helper(root.left, target, height+1);
        helper(root.right, target, height + 1);
    }


    // TC : O(n)
    // SC : O(m + n) --> ans array + recursion stack

    int [] level = new int[100001];
    int [] height = new int[100001];
    int [] levelMax = new int[100001];
    int [] levelSecondMax = new int[100001];
    public int[] treeQueries(TreeNode root, int[] queries) {
        int [] arr = new int[queries.length];
        int ind = 0;
        helper(root, 0);
        for(int a : queries){
            int L = level[a];
            // -1 is for 0 based height, because we are storing no. of nodes as the height of the tree, but the question asks height as number of edges so subtracting -1 from the height
            int max = L + (levelMax[L] == height[a] ? levelSecondMax[L] : levelMax[L]) - 1;
            arr[ind++] = max;
        }
        return arr;
    }
    // finding height of each node
    // storing level for each node value
    // finding max and second max height of the node at each level
    // so whenever we delete a node we can find its level and max/secondMax height at that level and by adding them we can find our answer for that query
    int helper(TreeNode root, int l){
        if(root == null) return 0;

        // storing the level
        level[root.val] = l;
        // finding height
        height[root.val] = Math.max(helper(root.left, l + 1) , helper(root.right, l+1)) + 1;

        // updating max and second max height
        if(levelMax[l] < height[root.val]){
            levelSecondMax[l] = levelMax[l];
            levelMax[l] = height[root.val];
        }
        // updating second max height
        else if(levelSecondMax[l] < height[root.val]) {
            levelSecondMax[l] = height[root.val];
        }
        return height[root.val];
    }
}
