package Leetcode;
import Lecture_practice_problems._45_LinkedList.LL;

public class _09_LinkedList_cycle {
    public boolean hasCycle(LL.Node head) {

        // we take two pointer fast and slow , one moves by one step ahead at a time and another moves by two step at a time so if there is a cycle present in the linked list then the fast and the slow pointer will meet somewhere and not they will point to null at the end
        LL.Node fast = head;
        LL.Node slow = head;

        // fast.next can't be null cause if it is null then we can't check for fast.next.next so we need this check and for slow there is no need to check cause if fast is at null then surely there is no cycle present and we know that fast will reach null before slow
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next; // this is null in case there is only two elements are present and no cycle is present
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}