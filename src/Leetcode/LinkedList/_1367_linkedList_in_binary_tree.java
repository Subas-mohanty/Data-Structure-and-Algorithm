package Leetcode.LinkedList;

//https://leetcode.com/problems/linked-list-in-binary-tree/?envType=daily-question&envId=2024-09-07

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class _1367_linkedList_in_binary_tree {

    // TC : (n*n)
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;

        // go to all node and check if there present a linked list from that node or from it's left or right
        return helper(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    boolean helper(ListNode node, TreeNode root) {
        if (node == null) return true; // end of the list, path found
        if (root == null) return false; // reached leaf node, no path found

        if (root.val == node.val) {
            // continue matching the next ListNode in both left and right subtrees
            return helper(node.next, root.left) || helper(node.next, root.right);
        }

        return false; // current TreeNode doesn't match, fail
    }
}
