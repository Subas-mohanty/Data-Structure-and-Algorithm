package Leetcode;

import Lecture_practice_problems._45_LinkedList.LL.ListNode;
//https://leetcode.com/problems/swap-nodes-in-pairs/submissions/
public class _24_swap_nodes_in_pairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode ans = swap(head);
        return ans;
    }
    ListNode swap(ListNode node){
        if(node == null || node.next == null){
            return node;
        }

        // s is first node and e is it's next node
        ListNode s = node;
        ListNode e = node.next;

        // swapping s and e
        ListNode temp = e.next;
        e.next = s;
        s.next = temp;

        s.next = swap(s.next);

        return e;
    }
}
