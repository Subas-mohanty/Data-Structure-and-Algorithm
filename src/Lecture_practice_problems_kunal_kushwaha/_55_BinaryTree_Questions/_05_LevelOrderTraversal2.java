package Lecture_practice_problems_kunal_kushwaha._55_BinaryTree_Questions;
import javax.swing.tree.TreeNode;
import java.util.Collections;
import java.util.List;
//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
public class _05_LevelOrderTraversal2 {

    /*
    // using stack
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Stack<List<Integer>> stack = new Stack<>(); // type is of List<Integer>, because we will be storing each level's small list inside the stack

        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int levelSize=queue.size();
            for(int i=0;i<levelSize;i++){
                TreeNode cNode = queue.poll();
                level.add(cNode.val);
                if(cNode.left!= null){
                    queue.offer(cNode.left);
                }
                if(cNode.right!= null){
                    queue.offer(cNode.right);
                }
            }
            stack.push(level); // for every level we are storing the list in an array, and after all the levels are completed we are popping the values from the stack and adding them into the result list
        }
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }


    // using the reversed() method

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // this is the answer list we are going to return
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        // created a Queue of type TreeNode to store all the TreeNodes
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            // going to run a loop for how many elements are present in that level and that is same as size of queue
            int levelSize=queue.size();
            // for every level creating a list to store that level's element
            List<Integer> currentLevel= new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode=queue.poll();
                // remove the element from the queue and add it's value in the inside list
                currentLevel.add(currentNode.val);
                // if node.left and node.right are not null we are adding those values to the queue
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
        Collections.reverse(result); // we need to import collections
        return result;
    }

    // putting each level at oth index
    public List<List<Integer>> levelOrder(TreeNode root) {
        // this is the answer list we are going to return
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        // created a Queue of type TreeNode to store all the TreeNodes
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            // going to run a loop for how many elements are present in that level and that is same as size of queue
            int levelSize=queue.size();
            // for every level creating a list to store that level's element
            List<Integer> currentLevel= new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode=queue.poll();
                // remove the element from the queue and add it's value in the inside list
                currentLevel.add(currentNode.val);
                // if node.left and node.right are not null we are adding those values to the queue
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }
            // after the completion of the level , adding the list to the answer list at 0th index to make sure the list inserted first will come to last and the list inserted last will be at first
            result.add(0,currentLevel);
        }
        return result;
    }
    */
}
