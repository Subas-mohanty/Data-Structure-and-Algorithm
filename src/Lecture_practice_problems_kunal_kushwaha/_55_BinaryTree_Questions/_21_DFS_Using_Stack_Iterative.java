package Lecture_practice_problems_kunal_kushwaha._55_BinaryTree_Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//https://leetcode.com/problems/binary-tree-preorder-traversal/description/
public class _21_DFS_Using_Stack_Iterative {
    List<Integer> dfsUsingStack(TreeNode node){
        List<Integer> list = new ArrayList<>();
        if(node == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode removed = stack.pop();
            list.add(removed.val);
            if(removed.right != null){
                stack.push(removed.right);
            }
            if(removed.left != null){
                stack.push(removed.left);
            }
        }
        return list;
    }
}
