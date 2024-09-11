package Leetcode.LinkedList;

import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/submissions/1380777973/?envType=daily-question&envId=2024-09-06/
public class _3217_delete_node_present_in_array {
    // TC : O(n + n) --> adding element to the set and doing the deletion
    // SC : O(n) --> for the set

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int a : nums) set.add(a);
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;
        ListNode newHead = head;

        // we have only two options, either we have to delete the current node or skip the node
        // if we have to delete, there are two cases, either the node is first node in the linkedlist or in the middle, if first then set the new head or simply delete the node
        while (curr != null) {
            // we have to delete the node
            if (set.contains(curr.val)) {
                // the node is the first node
                if (prev == null) {
                    curr = next;
                    newHead = curr;
                    if (next != null) next = next.next;
                }
                // the node is in the middle
                else {
                    prev.next = next;
                    curr = next;
                    if (next != null) next = next.next;
                }
            }
            // the node is not in the set, so don't delete, skip the node, by setting the prev to curr node
            else {
                prev = curr;
                curr = next;
                if (next != null) next = next.next;
            }
        }
        return newHead;
    }
}
