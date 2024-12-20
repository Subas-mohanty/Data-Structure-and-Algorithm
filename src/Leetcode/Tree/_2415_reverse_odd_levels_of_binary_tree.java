package Leetcode.Tree;

import Leetcode.TreeNode;

import java.util.*;
//https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/?envType=daily-question&envId=2024-12-20
public class _2415_reverse_odd_levels_of_binary_tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(13);
        root.right.left = new TreeNode(21);
        root.right.right = new TreeNode(34);
        System.out.println(reverseOddLevels(root).val);
    }

    // TC : O(n + n)
    // SC : O(n + n)
    public static TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>(); // store all the levels
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode removed = q.poll();
                list.add(removed.val);
                if(removed.left != null) q.offer(removed.left);
                if(removed.right != null) q.offer(removed.right);
            }
            ans.add(list);
        }

        q.offer(root);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = ans.get(level); // get the corresponding level list
            for(int i = 0; i < size; i++){
                TreeNode removed = q.poll();
                if(level % 2 == 1){ // if it is an odd level change the value of the node, take values in the reverse order
                    removed.val = list.getLast();
                    list.removeLast();
                }
                if(removed.left != null) q.offer(removed.left);
                if(removed.right != null) q.offer(removed.right);
            }
            level++;
        }
        return root;
    }



    // instead of storing values of nodes in the list and then doing bfs again, we can directly store nodes in the list and we can swap the values of first and last node of the list
    public TreeNode reverseOddLevels2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            List<TreeNode> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode removed = q.poll();
                list.add(removed);
                if(removed.left != null) q.offer(removed.left);
                if(removed.right != null) q.offer(removed.right);
            }
            if(level % 2 == 1) swap(list);
            level++;
        }
        return root;
    }
    void swap(List<TreeNode> list){
        int s = 0;
        int e = list.size() - 1;
        while(s <= e){
            int temp = list.get(s).val;
            list.get(s).val = list.get(e).val;
            list.get(e).val = temp;
            s++;
            e--;
        }
    }
}
