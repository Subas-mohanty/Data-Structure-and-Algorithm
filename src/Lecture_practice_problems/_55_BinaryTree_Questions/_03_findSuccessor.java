package Lecture_practice_problems._55_BinaryTree_Questions;

import java.util.LinkedList;

// find the next node of key
public class _03_findSuccessor {
    /*
    public TreeNode findSuccessor(TreeNode root, TreeNode key){
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty){
            TreeNode cNode = queue.poll();
            if(cNode.left!=null){
                queue.offer(cNode.left);
            }
            if(cNode.right!=null){
                queue.offer(cNode.right);
            }
            if(cNode == key){
                return queue.peek();
            }
        }
        return null;
    }
    */
}
