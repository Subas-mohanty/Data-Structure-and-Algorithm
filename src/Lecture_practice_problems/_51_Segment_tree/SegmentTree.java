package Lecture_practice_problems._51_Segment_tree;

public class SegmentTree {
    public class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval){
            this.startInterval=startInterval;
            this.endInterval=endInterval;
        }
    }
    Node root;
    public SegmentTree(int [] arr){
        // create a tree using this array
        this.root=constructTree(arr,0, arr.length-1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        if(start==end){
            // leaf node
            Node leaf = new Node(start,end);
            leaf.data=arr[start];
            return leaf;
        }
        Node node = new Node(start,end);
        int mid=(start+end)/2;
        node.left=constructTree(arr,start,mid);
        node.right=constructTree(arr,mid+1,end);

        node.data=node.left.data+node.right.data;

        return node;
    }
    public void display(){
        display(this.root);
    }
    private void display(Node node){
        String str="";

        if(node.left != null) {
            str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + " => ";
        } else{
            System.out.println("No left child exist");
        }

        // for current node
        if (node.left != null) {
            str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " <= ";
        }

        if(node.right != null) {
            str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.data;
        } else {
            str = str + "No right child";
        }
        System.out.println(str + '\n');

        // call recursion
        if (node.left != null) {
            display(node.left);
        }
        if(node.right != null) {
            display(node.right);
        }
    }

    // query
    public int query(int qsi, int qei){
        return query(this.root, qsi, qei);
    }
    private int query(Node node, int qsi, int qei){
        if(node.startInterval>=qsi && node.endInterval<= qei){
            // node is completely inside query
            return node.data;
        }
        else if(node.startInterval > qei || node.endInterval < qsi){
            // node is completely outside query
            return 0;
        }
        else{
            return this.query(node.left,qsi,qei) + this.query(node.right,qsi,qei);
        }
    }
    // update
    public void update(int index, int value){
        this.root.data=update(this.root,index,value);
    }
    private int update(Node node, int index, int value){
        if (index >= node.startInterval && index <= node.endInterval) {
            if (index == node.startInterval && index == node.endInterval) {
                node.data = value;
                return node.data;
            }
            else{
                int left=update(node.left,index,value);
                int right=update(node.right,index,value);
            }
        }
        return node.data;
    }
}
