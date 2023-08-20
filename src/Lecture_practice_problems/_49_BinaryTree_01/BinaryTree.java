package Lecture_practice_problems._49_BinaryTree_01;

import java.util.Scanner;

public class BinaryTree {
    public BinaryTree() {

    }

    public class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    public Node root;
    public Node getRoot(){
        return this.root;
    }

    // insert elements
    public void populate(Scanner scanner){
        System.out.println("Enter the value of root node: ");
        int value=scanner.nextInt();
        root=new Node(value);
        populate(scanner,root);
    }

    public void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to enter left of "+node.value);
        boolean left=scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value of left of "+ node.value);
            int value=scanner.nextInt();
            node.left=new Node(value);
            populate(scanner,node.left);
        }
        System.out.println("Do you want to enter right of "+node.value);
        boolean right=scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value of right of "+ node.value);
            int value=scanner.nextInt();
            node.right=new Node(value);
            populate(scanner,node.right);
        }
    }

    // preOrder: Node, Left, Right
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

    // Inorder: Left, Node, Right
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        inOrder(node.right);
        System.out.print(node.value+" ");
    }

    // PostOrder: Left, Right, Node
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        System.out.print(node.value+" ");
        postOrder(node.right);
    }
    public void display(){
        display(this.root,"");
    }

    private void display(Node node, String indent) {
        if(node==null){
            return;
        }
        System.out.println(indent+node.value);
        display(node.left,indent+"  ");
        display(node.right,indent+"  ");
    }
    public void prettyDisplay(){
        prettyDisplay(this.root,0);
    }

    private void prettyDisplay(Node node,int level) {
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