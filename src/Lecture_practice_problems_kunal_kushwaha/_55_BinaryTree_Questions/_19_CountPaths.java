package Lecture_practice_problems_kunal_kushwaha._55_BinaryTree_Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
//DSA-01 --> 27-12-2023
public class _19_CountPaths {
//    TC: O(N^2)
//    SC: O(N)
    public int countPaths(TreeNode node, int target){
        List<Integer> list = new ArrayList<>();
        return helper(node, target, list);
    }
     int helper(TreeNode node, int target, List<Integer> list){
         if (node == null) {
             return 0;
         }
         list.add(node.val);

         int sum=0;
         int count=0;

         // check for sum in the list and how many paths exits
         ListIterator<Integer> iterator = list.listIterator(list.size());
         while(iterator.hasPrevious()){
             sum+=iterator.previous();
             if (sum == target) {
                 count++;
             }
         }
         count += helper(node.left, target, list) + helper(node.right, target, list);
         // backtracking
         list.remove(list.size()-1);

         return count;
    }
}
