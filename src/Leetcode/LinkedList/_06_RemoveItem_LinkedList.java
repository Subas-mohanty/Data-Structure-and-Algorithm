package Leetcode.LinkedList;


import Leetcode.ListNode;

public class _06_RemoveItem_LinkedList {
    public static void main(String[] args) {

    }
    public ListNode removeElements(ListNode head, int val) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev=null;
        ListNode present=head;
        ListNode next=present.next;

        // we have to reach till the previous node of the given value
        while(present!=null){
            while(present.val!=val){
                prev=present;
                present=next;
                if (next != null) {
                    next=next.next;
                }
            }
            // now present is at the value and prev is at previous of that
            prev.next=present.next;
            present=next;
        }
        return head;
    }
}
