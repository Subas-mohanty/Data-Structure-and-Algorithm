package Programming_Concepts;
import Leetcode.TreeNode;
import java.util.List;

//https://www.youtube.com/watch?v=Wq3ibaP4dJY

// inorder traversal using without any extra space and O(n) time
// TC : O(n)
// SC : O(1)
public class _15_morisInorderTraversal {

    void morisInorder(TreeNode root, List<Integer> list){
        TreeNode curr = root;
        while(curr != null){
            // if no left child is present, this means this is the left most child so add to the list
            if(curr.left == null){
                list.add(curr.val);
                curr = curr.right;
            }
            else{
                // if left child is present, then go to the left child and go to its right most child, and connect it back to the curr node
                TreeNode leftChild = curr.left;
                while(leftChild.right != null){
                    leftChild = leftChild.right;
                }
                leftChild.right = curr; // connecting to curr node
                // de-link the curr and it's left
                TreeNode temp = curr; // store the curr node
                curr = curr.left; // move the node to it's left
                temp.left = null; // make the left of the node null to de-link the node
            }
        }
    }
}
