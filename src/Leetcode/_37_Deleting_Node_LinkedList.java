package Leetcode;
//https://leetcode.com/problems/delete-node-in-a-linked-list/
public class _37_Deleting_Node_LinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    // the node is not the tail node and the list size is > 2 and the node is present in the list in all testcases
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
