package Leetcode.LinkedList;
//https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/description/?envType=daily-question&envId=2024-09-10

public class _2807_insert_GCD_in_linkedList {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode curr = head;
        ListNode next = curr.next;

        while(curr != null && next != null){
            int gcd = findGCD(curr.val, next.val);
            ListNode node = new ListNode(gcd);
            curr.next = node;
            node.next = next;
            curr = next;
            next = next.next;
        }
        return head;
    }
    int findGCD(int a, int b){
        if(b == 0) return a;
        return findGCD(b, a%b);
    }

    int findGCD2(int a, int b){
        for(int i = Math.min(a, b); i >= 1; i--){
            if(a % i == 0 && b % i == 0) return i;
        }
        return 1;
    }
}
