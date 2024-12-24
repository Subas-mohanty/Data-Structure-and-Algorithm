package Leetcode.LinkedList;
import Lecture_practice_problems._45_LinkedList.LL.ListNode;

import java.util.Stack;

// https://leetcode.com/problems/remove-nodes-from-linked-list/description/?envType=daily-question&envId=2024-05-06
public class _2487_remove_nodes_from_ll {
  public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;

        // monotonic decreasing stack, that means it will only have strictly decreasing values
        while(temp != null){
            while(!stack.isEmpty() && temp.val > stack.peek().val) stack.pop();
            stack.push(temp);
            temp = temp.next;
        }
        ListNode end = null;
        while(!stack.isEmpty()){
            temp = stack.pop();
            temp.next = end;
            end = temp;
        }
        return temp;
    }
}
