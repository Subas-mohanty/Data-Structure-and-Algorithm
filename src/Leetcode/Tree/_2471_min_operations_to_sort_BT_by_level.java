package Leetcode.Tree;

import Leetcode.TreeNode;

import java.util.Collections;
import java.util.*;
// https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/?envType=daily-question&envId=2024-12-23

public class _2471_min_operations_to_sort_BT_by_level {

    // TC : O(n + n log * (level size)  + level size) --> bfs + sorting + traversing
    // SC : O(n + 2 * level size)
    public int minimumOperations(TreeNode root) {
        return helper(root);
    }
    public int countMinSwapsToSort(List<Integer> level){
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> sorted = new ArrayList<>(level);
        Collections.sort(sorted);
        int count = 0;
        for(int i = 0; i < level.size(); i++) map.put(level.get(i), i);

        for(int i = 0; i < level.size(); i++){
            int ele = level.get(i);

            // the element is in correct postion, no need to swap
            if(ele == sorted.get(i)) continue;
            else {
                // swap max element with its correct place
                count++;
                int swapIndex = map.get(sorted.get(i));
                map.put(ele, swapIndex);
                map.put(level.get(swapIndex), i);
                Collections.swap(level, i, swapIndex);
            }
        }
        return count;
    }

    int helper(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode removed = q.poll();
                list.add(removed.val);
                if(removed.left != null) q.offer(removed.left);
                if(removed.right != null) q.offer(removed.right);
            }
            count += countMinSwapsToSort(list);
        }
        return count;
    }


    // this is only using O(N^2) to sort which is done by n log * level size in the optimal approach
    List<List<Integer>> list = new ArrayList<>(); // storing all levels in this list
    public int minimumOperations2(TreeNode root) {
        helper2(root);
        int count = 0;
        for(int i = 1; i < list.size(); i++){
            count += sortLevel(list.get(i));
        }
        return count;
    }
    // calculating how much min swaps needed to sort this level
    public int sortLevel(List<Integer> level){
        int count = 0;
        for(int i = 0; i < level.size(); i++){
            int [] max = new int[2];
            for(int j = 0; j < level.size() - i; j++){
                if(level.get(j) > max[0]){
                    max[0] = level.get(j);
                    max[1] = j;
                }
            }
            // index of max element, if it is present in the correct place
            if(max[1] == level.size() - 1 - i) continue;
            else {
                // swap max element with its correct place
                count++;
                swap(level, max[1], level.size() - 1 - i);
            }
        }
        return count;
    }
    void swap(List<Integer> l, int start, int end){
        int temp = l.get(start);
        l.set(start, l.get(end));
        l.set(end, temp);
    }
    // bfs --> O(n)
    void helper2(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> t = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode removed = q.poll();
                t.add(removed.val);
                if(removed.left != null) q.offer(removed.left);
                if(removed.right != null) q.offer(removed.right);
            }
            list.add(t);
        }
    }
}
