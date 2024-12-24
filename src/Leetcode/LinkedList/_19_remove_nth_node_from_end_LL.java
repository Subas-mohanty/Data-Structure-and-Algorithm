package Leetcode.LinkedList;
import Leetcode.ListNode;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

// we are asked to remove the nth node from the linked list, so go to the prev node of the node that need to be deleted
// first found the length of the linked list
// reach to the prev node, make that node's next to that node's next's next
public class _19_remove_nth_node_from_end_LL {
        public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return null;
        ListNode temp = head;
        int length = 0;

        while(temp != null){
            temp = temp.next;
            length++;
        }
        int dist = length - n;

        if(dist < 0) return head; // the node to be deleted is greater than the number of nodes in the list
        if(dist == 0) return head.next; // the node to be deleted is the first node so returning its next node

        ListNode prev = head;
        for (int i = 0; i < dist-1; i++) {
            prev = prev.next;
        }
        if(prev.next!= null) {
            prev.next = prev.next.next;
        }
        return head;
    }
}
