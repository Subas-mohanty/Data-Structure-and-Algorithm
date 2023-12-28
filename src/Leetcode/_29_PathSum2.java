package Leetcode;

import Lecture_practice_problems._55_BinaryTree_Questions.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

//https://leetcode.com/problems/path-sum-ii/
public class _29_PathSum2 {
//    TC: O(N)
//    SC: O(logN) because in the path list , in the worst case there will be height of tree numbers of element will be there
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        List<Integer> path = new ArrayList<>();
        helper(root, targetSum, list, path);
        return list;
    }
    public void  helper(TreeNode node, int target, List<List<Integer>> list, List<Integer> path){
        if(node == null){
            return;
        }
        path.add(node.val);

        if(node.left == null && node.right == null && node.val == target){
            //list.add(path); // we can't do this because we are adding the reference to the path list to the result, and then later in recursion, we are modifying the same path list by removing elements
            list.add(new ArrayList<>(path));
        }

        helper(node.left, target - node.val, list, path);
        helper(node.right, target - node.val, list, path);

        // backtrack, when we are at leaf , left and right will have null so after that we are removing the node from the path list
//        path.remove(path.size() -1 );
        path.removeLast();
    }



//    TC: O(N^2) for recursion and checkSum method sum calculation
//    SC: O(N) for path list
    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        List<Integer> path = new ArrayList<>();
        helper2(root, targetSum, list, path);
        return list;
    }
    public void  helper2(TreeNode node, int target, List<List<Integer>> list, List<Integer> path){
        if(node == null){
            return;
        }
        path.add(node.val);

        if(node.left == null && node.right == null){
            if(checkSum(path)==target){
                //list.add(path); // we can't do this because we are adding the reference to the path list to the result, and then later in recursion, we are modifying the same path list by removing elements
                list.add(new ArrayList<>(path));
            }
        }

        helper2(node.left, target, list, path);
        helper2(node.right, target, list, path);

        // backtrack, when we are at leaf , left and right will have null so after that we are removing the node from the path list
        path.remove(path.size() -1 );
    }
    public int checkSum(List<Integer> path){
        ListIterator<Integer> itr = path.listIterator(path.size());
        int sum =0;
        while(itr.hasPrevious()){
            sum+=itr.previous();
        }
        return sum;
    }
}
