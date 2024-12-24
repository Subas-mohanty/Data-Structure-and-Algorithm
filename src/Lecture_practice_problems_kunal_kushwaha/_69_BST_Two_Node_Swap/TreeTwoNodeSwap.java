package Lecture_practice_problems_kunal_kushwaha._69_BST_Two_Node_Swap;

//DSA-01 --> 08-01-2024
class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val = val;
    }
}
public class TreeTwoNodeSwap {
    Node first;
    Node second;
    Node prev;

    public Node helper(Node root){

        // for setting the value of first and second
        inorder(root);

        // swap first and second
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return root;
    }
    private void inorder(Node node){
        if(node == null){
            return;
        }
        inorder(node.left);

        // we find the violation
        if(prev != null && prev.val > node.val){
            if(first == null){
                first = prev;
            }
            // when we find the first violation we are updating second = node but it will be again updated to second swapped node when it will find the second violation
            second = node;
        }
        prev=node;
        inorder(node.right);
    }
}

