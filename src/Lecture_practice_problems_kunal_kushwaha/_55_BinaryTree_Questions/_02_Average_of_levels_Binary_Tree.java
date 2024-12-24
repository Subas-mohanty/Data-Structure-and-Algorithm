package Lecture_practice_problems_kunal_kushwaha._55_BinaryTree_Questions;
import java.util.*;

public class _02_Average_of_levels_Binary_Tree {

    /*
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize=queue.size();
            double sum=0;
            for(int i=0; i<levelSize;i++){
                TreeNode cNode=queue.poll();
                sum+=cNode.val;
                if(cNode.left!=null){
                    queue.offer(cNode.left);
                }
                if(cNode.right!=null){
                    queue.offer(cNode.right);
                }
            }
            list.add(sum/levelSize);
        }
        return list;
    }
     */
}
