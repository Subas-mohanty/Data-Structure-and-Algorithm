package Lecture_practice_problems._69_BST_Two_Node_Swap;

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
            second = node;
        }
        prev=node;
        inorder(node.right);
    }
}

