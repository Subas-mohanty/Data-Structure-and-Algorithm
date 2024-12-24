package Lecture_practice_problems_kunal_kushwaha._68_BT_to_DoublyLL;

//https://www.geeksforgeeks.org/convert-binary-tree-to-doubly-linked-list-by-keeping-track-of-visited-node/
// from GeekForGeeks
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {
    Node root;
    // head --> Pointer to head node of created doubly linked list
    Node head;
    // static means its value will not be changed , it will work as a reference like array or list
    static Node prev = null;

    // root --> Root of Binary Tree
    void BinaryTree2DoubleLinkedList(Node root) {
        if (root == null)
            return;
        BinaryTree2DoubleLinkedList(root.left);
        // building a doubly linked list where the head is the left most element
        if (prev == null) {
            head = root;
        } else {
            // when we have a head node previously we will make current node's left = previous node(prev) and the previous node's right = current node.
            // making a doubly linked list from the left most element by pointing its next to its parent and this node as its parents previous.
            // create a diagram and it can be clearly understood
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        BinaryTree2DoubleLinkedList(root.right);
    }


    // done by kunal using two classes
    class DoublyLinkedList {
        LLNode head;
        LLNode tail;

        public LLNode convert(TreeNode root) {
            if (root == null) {
                return null;
            }
            helper(root);

            return head;
        }

        private void helper(TreeNode node) {
            if (node == null) {
                return;
            }
            // inorder traversal
            helper(node.left);

            LLNode newNode = new LLNode(node.val);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            helper(node.right);
        }
    }

    class LLNode {
        int val;
        LLNode prev;
        LLNode next;

        public LLNode(int val) {
            this.val = val;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
