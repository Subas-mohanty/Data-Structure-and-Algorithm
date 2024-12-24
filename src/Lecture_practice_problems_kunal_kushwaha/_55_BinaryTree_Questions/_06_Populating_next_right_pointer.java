package Lecture_practice_problems_kunal_kushwaha._55_BinaryTree_Questions;

import java.util.LinkedList;
import java.util.Queue;

class _06_Populating_next_right_pointer {

    private Node root;
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            // created a Queue of type TreeNode to store all the TreeNodes
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);

            // when at the end the queue is empty that means all the elements are traversed so we return the answer list
            Node currentNode = null;
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
//                while(levelSize>0) // this can be done also
                    for(int i = levelSize;i>0;i++){
                    // when the size of the queue is > than 1, we are removing the first element and pointing its next to the next element in the queue

                    if (levelSize > 1) {
                        currentNode = queue.poll();
                        currentNode.next = queue.peek();
                    } else {
                        currentNode = queue.poll();
                    }

                    if (currentNode.left != null) {
                        queue.offer(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.offer(currentNode.right);
                    }
                    levelSize--;
                }
            }
            return root;
        }
        public Node connect2(Node root) {
            if(root==null){
                return null;
            }

            Node leftMost=root;

            while(leftMost.left!=null){
                Node currentNode = leftMost;
                // for every level
                while(currentNode!=null){
                    currentNode.left.next=currentNode.right;
                    if(currentNode.next!=null){
                        currentNode.right.next=currentNode.next.left;
                    }
                    currentNode=currentNode.next;
                }
                leftMost=leftMost.left;
            }
            return root;
        }
    }
}
