package Leetcode.Tree;

import Leetcode.TreeNode;
import java.util.*;

//https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/?envType=daily-question&envId=2024-10-22

public class _2583_kth_largest_sum_in_BT {

    // TC : O(n + h log(h) ) --> for list, h = log n, height or no. of levels in the tree
    // TC : O(n + log h) --> for heap, heap operation takes log n, and here n = h = log n
    // SC : O(log n) --> height of tree

//    List<Long> list = new ArrayList<>();
    PriorityQueue<Long> list = new PriorityQueue<>((a,b) -> Long.compare(b,a));
    public long kthLargestLevelSum(TreeNode root, int k) {
        helper(root);
//        Collections.sort(list, (a, b) -> Long.compare(b,a));
        if(k >= list.size()) return -1;
//        return list.(k-1);
        while(k-- > 1) list.poll();
        return list.peek();
    }
    void helper(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        list.add((long)root.val);
        while(!q.isEmpty()){
            int n = q.size();
            long sum = 0;
            for(int i = 0; i < n; i++){
                TreeNode removed = q.poll();
                if(removed.left != null){
                    q.offer(removed.left);
                    sum += removed.left.val;
                }
                if(removed.right != null){
                    q.offer(removed.right);
                    sum += removed.right.val;
                }
            }
            list.add(sum);
        }
    }
}
