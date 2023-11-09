package Lecture_practice_problems._49_BinaryTree_01;

public class BST {
    private class Node{
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
        public int getValue(){
            return value;
        }
    }
    private Node root;
    public BST() {

    }
    public int height(Node node){
        if(node==null){
            return -1;
        }

        return node.height;
    }
    public boolean isEmpty(){
        return root==null;
    }
    public void insert(int value){
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if(node==null){
            node=new Node(value);
            return node;
        }
        if(value<node.value){
            node.left=insert(value,node.left);
        }
        if(value>node.value){
            node.right=insert(value,node.right);
        }
        node.height=Math.max(height(node.left),height(node.right))+1;

        return node;
    }
    public boolean balanced(){
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left)-height(node.right))<=1 && balanced(node.left) && balanced(node.right);
    }
    public void populate(int [] nums){
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    // for sorted array , if the array is sorted then the tree will be like a linked list which is not good so, we have to do this:
    // in case of the array is sorted we took the middle element and insert it in the tree then we call the recursive function on both the left and right halves
    public void populateSorted(int [] nums){
        populateSorted(nums,0,nums.length);
    }
    private void populateSorted(int [] nums, int start, int end){
        if (start >= end) {
            return;
        }
        int mid=start-(start-end)/2;
        this.insert(nums[mid]); // inserting the mid element
        populateSorted(nums,start,mid); // calling the recursive function for left side
        populateSorted(nums,mid+1,end); // calling the recursive function for right side
    }

//    used for math evaluation and creating a copy and in serialization also
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.value+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    // in case of a binary search tree it will return a sorted order of the elements
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.value+" ");
        inOrder(node.right);
    }
//    used while deleting a binary tree and also while we are doing bottom up calculation like calculating the height or diameter                                                      of the tree
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+" ");
    }

    public void display(){
        display(root,"Root Node : ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details+node.value);
        display(node.left,"Left child of "+node.value+": ");
        display(node.right,"Right child of "+node.value+": ");
    }
    public void prettyDisplay(){
        prettyDisplay(this.root,0);
    }

    private void prettyDisplay(Node node, int level) {
        if(node==null){
            return;
        }
        prettyDisplay(node.right,level+1);

        if(level!=0){
            for (int i = 0; i < level-1; i++) {
                System.out.print("\t\t");
            }
            System.out.println("|---->"+node.value);
        }else{
            System.out.println(node.value);
        }
        prettyDisplay(node.left,level+1);
    }
}
