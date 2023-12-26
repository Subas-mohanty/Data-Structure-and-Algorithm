package Lecture_practice_problems._55_BinaryTree_Questions;

public class _18_FindPath {
    boolean findPath(TreeNode node, int [] arr){
        if(node == null){
            return arr.length == 0; // if array is empty return true otherwise false
        }
        return helper(node, arr, 0);
    }
    boolean helper(TreeNode node, int [] arr, int index){
        if(node == null){
            return false;
        }
        if(index >= arr.length || node.val != arr[index]){
            return false;
        }
        // we are at the leaf node and it is the last element of the array
        if(node.left == null && node.right == null && index == arr.length-1){
            return true;
        }
        return helper(node.left, arr, index+1) || helper(node.right, arr, index+1);
    }
}
