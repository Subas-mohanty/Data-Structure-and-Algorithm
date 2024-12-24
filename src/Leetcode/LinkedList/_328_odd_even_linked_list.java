package Leetcode.LinkedList;

import Leetcode.ListNode;
//https://leetcode.com/problems/odd-even-linked-list/description/
public class _328_odd_even_linked_list {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;

        ListNode even = head.next;
        ListNode odd = head;
        ListNode evenHead = even;

        while(odd != null && even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next; // this might be null and if we don't check if even.next is equal to null or not then we might do null.next in the next iteration, which will give exception
        }
        odd.next = evenHead;
        return head;
    }
}
