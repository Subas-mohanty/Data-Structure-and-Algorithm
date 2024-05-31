package Lecture_practice_problems._55_BinaryTree_Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _01_BFS {
    // queue.offer(root); // add() will throw an IllegalStateException if no space is currently available in the Queue, otherwise add method will return true. offer() method will return false if the element cannot be inserted due to capacity restrictions.

    // TreeNode currentNode=queue.poll(); // Peek() - It will give the head element of the queue. If queue is empty then it will return null. Poll() - It will give the head element of the queue and will remove the head element from queue. If queue is empty then it will return null.
    public List<List<Integer>> levelOrder(TreeNode root) {
        // this is the answer list we are going to return
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        // created a Queue of type TreeNode to store all the TreeNodes
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root); // see above for explanation

        // when at the end the queue is empty that means all the elements are traversed so we return the answer list
        while(!queue.isEmpty()){
            // going to run a loop for how many elements are present in that level and that is same as size of queue
            int levelSize=queue.size();
            // for every level creating a list to store that level's element
            List<Integer> currentLevel= new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode=queue.poll(); // see above for explanation
                // remove the element from the queue and add it's value in the inside list
                currentLevel.add(currentNode.val);
//                 if node.left and node.right are not null we are adding those values to the queue
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }
            // after the completion of the level , adding the list to the answer list
            result.add(currentLevel);
        }
        return result;
    }
}
