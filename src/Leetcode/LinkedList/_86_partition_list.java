package Leetcode.LinkedList;
import Leetcode.ListNode;
import java.util.*;


class _86_partition_list {
    public static void main(String[] args) {

        int x = 3;
        int [] arr = {1,4,3,0,2,5,2};
        int n = arr.length;
        ListNode head = makeList(arr);
        display(head);

        ListNode ans = partition(head, x);
        display(ans);
    }
    // TC : O(N)
    // SC : O(n) --> 2 queue will store all the elements in the linked list
    public static ListNode partition(ListNode head, int x) {
        Queue<Integer> smaller = new LinkedList<>();
        Queue<Integer> larger = new LinkedList<>();
        ListNode t = head;

        // keep smaller elements in smaller queue and greater elements in greater queue
        while(t != null){
            if(t.val < x) smaller.offer(t.val);
            else larger.offer(t.val);
            t = t.next;
        }
        ListNode l = new ListNode();
        ListNode h = l;
        // make list from the 2 queues
        while(!smaller.isEmpty()){
            int value = smaller.poll();
            ListNode n = new ListNode(value);
            l.next = n;
            l = l.next;
        }
        while(!larger.isEmpty()){
            int value = larger.poll();
            ListNode n = new ListNode(value);
            l.next = n;
            l = l.next;
        }
        return h.next;
    }


    // TC : O(N)
    // SC : O(1)
    public static ListNode partition2(ListNode head, int x) {
        ListNode smallerHead = new ListNode();
        ListNode greaterHead = new ListNode();
        ListNode small = smallerHead;
        ListNode great = greaterHead;

        while(head != null){
            if(head.val < x) {
                small.next = head;
                small = small.next;
            }
            else{
                great.next = head;
                great = great.next;
            }
            head = head.next;
        }
        great.next = null;
        small.next = greaterHead.next;
        return smallerHead.next;
    }
    public static void display(ListNode head){
        while(head != null){
            System.out.print(head.val + "->" );
            head = head.next;
        }
        System.out.println();
    }
    public static ListNode makeList(int [] arr){
        ListNode head = new ListNode();
        ListNode t = head;
        int n = arr.length;
        for (int ele : arr) {
            t.next = new ListNode(ele);
            t = t.next;
        }
        return head.next;
    }
}