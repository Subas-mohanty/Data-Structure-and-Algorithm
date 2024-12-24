package Lecture_practice_problems_kunal_kushwaha._49_BinaryTree_01;

import java.util.*;

import Lecture_practice_problems_kunal_kushwaha._64_Vertical_order_traversal.VerticalOrderTraversal;

public class BinaryTree {
    public BinaryTree() {

    }

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node next;

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


    // only for questions
    public static List<List<Integer>> verticalTraversal(Node node) {
        List<List<Integer>> ans= new ArrayList<>();
        if(node == null){
            return ans;
        }
        int col=0;
        Queue<Map.Entry<Node, Integer>> queue = new ArrayDeque<>();
        HashMap<Integer, ArrayList<Integer> > map = new HashMap<>();


        queue.offer(new AbstractMap.SimpleEntry<>(node, col));
        int min=0;
        int max=0;

        while(!queue.isEmpty()){
            Map.Entry<Node, Integer> removed=queue.poll();
            node = removed.getKey();
            col= removed.getValue();

            if(node != null){
                if(!map.containsKey(col)){
                    map.put(col, new ArrayList<Integer>());
                }
                map.get(col).add(node.value);
                min = Math.min(min,col);
                max= Math.max(max,col);

            }
            if(node.left!=null){
                queue.offer(new AbstractMap.SimpleEntry<>(node.left, col-1 ));
            }
            if(node.right!=null){
                queue.offer(new AbstractMap.SimpleEntry<>(node.right, col+1 ));
            }

        }
        for(int i = min;i<=max;i++){
            ans.add(map.get(i));
        }
        return ans;
    }
    public static Node connect(Node root) {
        if(root==null){
            return null;
        }
        // created a Queue of type TreeNode to store all the TreeNodes
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);

        // when at the end the queue is empty that means all the elements are traversed so we return the answer list
        Node currentNode=null;
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            for (int i = 0; i < levelSize; i++) {
                // when the size of the queue is > than 1, we are removing the first element and pointing its next to the next element in the queue
                if(levelSize>1){
                    currentNode=queue.poll();
                    currentNode.next=queue.peek();
                }
                else{
                    currentNode = queue.poll();
                }
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }

            }
        }
        return root;
    }
}