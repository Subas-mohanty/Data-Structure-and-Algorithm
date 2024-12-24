package Lecture_practice_problems_kunal_kushwaha._51_Segment_tree;

public class SegmentTree {
    public class Node{
        int value;
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
            // leaf node with one index
            Node leaf = new Node(start,end);

            // value of the node will be either arr[start] or arr[end] because it's the only index, so we don't need any kind of sum to calculate it's value and as start and end is same we can use any of these
            leaf.value=arr[start];
            return leaf;
        }
        Node node = new Node(start,end);
        int mid=(start+end)/2;
        node.left=constructTree(arr,start,mid);
        node.right=constructTree(arr,mid+1,end);

        // current node's value is equal to the value of left node + the value of the right node
        node.value=node.left.value+node.right.value;

        return node;
    }
    public void display(){
        display(this.root);
    }
    private void display(Node node){
        String str="";

        if(node.left != null) {
            str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.value + " => ";
        } else{
            System.out.print("No left child exist => ");
        }

        // for current node
            str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.value + " <= ";

        if(node.right != null) {
            str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.value;
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
            return node.value;
        }
        else if(node.startInterval > qei || node.endInterval < qsi){
            // node is completely outside query
            return 0;
        }
        else{
            // if we don't find any of the conditions above that means the node interval is partially inside the query interval, so we just check left tree and right tree
            return this.query(node.left,qsi,qei) + this.query(node.right,qsi,qei);
        }
    }
    // update
    public void update(int index, int value){
        this.root.value=update(this.root,index,value);
    }
    private int update(Node node, int index, int value) {
        // this is checking only the leaf node whose index value is equal to the index but not checking for the another leaf node of the same level , so that node giving us the null pointer exception
        // let's look how ? suppose we want to update the 0th index so it will only check for that node whose start and end index is 0 but when the node will be index 1,2,3 or any other leaf node , it will call the left and right recursion call as normal but those will be null as their parent node was leaf node

        if(node.startInterval == index && node.endInterval == index){
            node.value=value;
            return node.value;
        }
        // to fix the null pointer exception we have to make a check that if the node is a leaf node then we are no more going to check it and this is how it is done
        if(node.left!=null && node.right!=null){
            int left=update(node.left,index,value);
            int right=update(node.right,index,value);
            node.value=node.left.value+node.right.value;
        }
        return node.value;
    }
//    private int update(Node node, int index, int value){
//        // this checks the null pointer exception, what it is doing is, it in only doing the operation on the leaf node that needs to be updated for other node its just simply returning the node value
//        if (index >= node.startInterval && index <= node.endInterval) {
//            if (index == node.startInterval && index == node.endInterval) {
//                node.value = value;
//                return node.value;
//            }
//            else{
//                int left=update(node.left,index,value);
//                int right=update(node.right,index,value);
//            }
//        }
//        return node.value;
//    }
}
