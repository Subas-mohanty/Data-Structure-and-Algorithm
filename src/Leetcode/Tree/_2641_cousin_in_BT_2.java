package Leetcode.Tree;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import Leetcode.TreeNode;

// https://leetcode.com/problems/cousins-in-binary-tree-ii/?envType=daily-question&envId=2024-10-23

public class _2641_cousin_in_BT_2 {

    // TC : O(n + n)
    // SC : O(n + h) --> queue + list
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        q.offer(root);

        // doing bfs and storing all level sums in list
        list.add(root.val);
        while(!q.isEmpty()){
            int n = q.size();
            int sum = 0;
            for(int i = 0; i < n; i++){
                TreeNode removed = q.poll();
                if(removed.left != null){
                    sum += removed.left.val;
                    q.offer(removed.left);
                }
                if(removed.right != null){
                    sum += removed.right.val;
                    q.offer(removed.right);
                }
            }
            list.add(sum);
        }

        root.val = 0; // setting root value to 0
        // again doing a bfs to update the values in the nodes
        q.offer(root);
        int level = 0;
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0; i < n; i++){
                int sum = 0;
                TreeNode removed = q.poll();
                // finding the sibling sum of each node, for example, at every node, finding sum of its left and right node and then subtracting it from the total sum to get the cousin sum
                // sibling sum 
                if(removed.left != null){
                    sum += removed.left.val;
                }
                if(removed.right != null){
                    sum += removed.right.val;
                }
                int cousinSum = list.get(level + 1) - sum; 

                // updating the cousin sum and adding left and right node to the queue again
                if(removed.left != null){
                    removed.left.val = cousinSum;
                    q.offer(removed.left);
                }
                if(removed.right != null){
                    removed.right.val = cousinSum;
                    q.offer(removed.right);
                }
            }
            level++;
        }
        return root;
    }



    // one pass

    // TC : O(n)
    // SC : O(n)

    public TreeNode replaceValueInTree2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int levelSum  = root.val;

        while (!q.isEmpty()) {
            int n = q.size();
            int nextLevelSum = 0;
            for (int i = 0; i < n; i++) {
                TreeNode removed = q.poll();
                // update current node value
                removed.val = levelSum - removed.val;

                // find sibling sum
                int siblingSum = (removed.left != null ? removed.left.val : 0) +
                        (removed.right != null ? removed.right.val : 0);

                if (removed.left != null) {
                    nextLevelSum += removed.left.val;
                    removed.left.val = siblingSum; // storing sibling sum in the node itself
                    q.offer(removed.left);
                }
                if (removed.right != null) {
                    nextLevelSum += removed.right.val;
                    removed.right.val = siblingSum;
                    q.offer(removed.right);
                }
            }
            levelSum = nextLevelSum;
        }
        return root;
    }
}
