package Lecture_practice_problems._55_BinaryTree_Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-right-side-view/
public class _07_RightSideView {
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
    public List<Integer> rightSideView(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if(node==null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        // level order traversal
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode removed=queue.poll();

                // for the last element, when i==size-1 that means the last item is removed so we need to add this to our answer list
                if(i==size-1){
                    list.add(removed.val);
                }
                if(removed.left!=null){
                    queue.offer(removed.left);
                }
                if(removed.right!=null){
                    queue.offer(removed.right);
                }
            }
        }
        return list;
    }
}
