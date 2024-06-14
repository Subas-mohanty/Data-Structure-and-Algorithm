package Leetcode;

import Lecture_practice_problems._45_LinkedList.LL.ListNode;

import java.util.Stack;
//https://leetcode.com/problems/reverse-nodes-in-k-group/submissions/1262564195/
public class _25_reverse_k_nodes {
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;

        ListNode newHead = new ListNode();
        ListNode tempHead = newHead;

        while(temp != null){
            int count = 0;
            ListNode curr = temp;

            // adding k nodes in the stack
            while(count < k && temp != null){
                stack.add(temp);
                temp = temp.next;
                count++;
            }

            // when k is equal to number of elements in the stack, pop the elements and create a new list
            if(count == k){
                while(!stack.isEmpty()){
                    tempHead.next = stack.pop();
                    tempHead = tempHead.next;
                }
                tempHead.next = temp;
            }
            else tempHead.next = curr; // this is because if in the end there are less than k nodes left, then we won't reverse them instead, we will put the tempHead's next directly to the first element, so that the last part don't get reversed
        }
        return newHead.next;
    }
}
