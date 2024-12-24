package Leetcode.LinkedList;

// https://leetcode.com/problems/merge-nodes-in-between-zeros/description/
public class _2181_merge_nodes {

    // TC : O(n)
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = head;
        ListNode newHead = new ListNode();
        ListNode ans = newHead;

        while(temp != null){
            int sum = 0;
            // finding the sum until we encounter a 0
            while(temp.val != 0){
                sum += temp.val;
                temp = temp.next;
            }
            // when we find 0, create a new node with the sum value and create the linked list
            if(temp.val == 0 && sum != 0){
                ListNode curr = new ListNode(sum);
                newHead.next = curr;
                newHead = newHead.next;
            }
            temp = temp.next;
        }
        return ans.next;
    }


    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
