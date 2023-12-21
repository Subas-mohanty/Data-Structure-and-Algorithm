package Lecture_practice_problems._55_BinaryTree_Questions;

import java.util.LinkedList;
import java.util.Queue;

public class _12_BT_to_LinkedList {

//    TC:O(N)
//    SC:O(1)
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while(current!=null){
            if(current.left!=null){
                TreeNode temp = current.left;
                while(temp.right!=null){
                    temp=temp.right;
                }
                temp.right=current.right;
                current.right=current.left;
                current.left=null;
            }
            current=current.right;
        }
    }

    //    TC:O(N)
    //    SC:O(1)
    public void flatten2(TreeNode root) {
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        helper(root, queue);

        // making the skewed binary tree or linked list
        TreeNode node=null;

        // this may be a little confusing that how all the nodes are getting connected as we are removing all the elements individually and , so the ans is
        // at every iteration node = the first element of the queue, and then we are pointing its right to the next element, but we are not removing the element, and on the next iteration again we make node= queue.poll() and set its right to next element in the queue, node = queue.poll() doesn't make any difference to the tree structure because we have previously set the node's right value to the next element
        while(!queue.isEmpty()){
            node = queue.poll();
            node.left=null;
            if(!queue.isEmpty()){
                node.right=queue.peek();
            }
            else{
                node.right=null;
            }
        }
        root=node; // we have to change the root so we make root=node
    }
    private void helper(TreeNode node, Queue<TreeNode> queue){
        if(node==null){
            return;
        }
        // adding the node in a queue while traversing pre order
        queue.offer(node);
        helper(node.left,queue);
        helper(node.right, queue);
    }
}
