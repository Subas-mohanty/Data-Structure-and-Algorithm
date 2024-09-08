package Leetcode.LinkedList;

import java.util.Arrays;
//https://leetcode.com/problems/split-linked-list-in-parts/description/?envType=daily-question&envId=2024-09-08

public class _725_split_linked_list_in_parts {
    public ListNode[] splitListToParts(ListNode head, int k) {

        // if head is null, returning an array of size k having null
        if(head == null) return new ListNode[k];
        ListNode [] ans = new ListNode[k];
        int [] arr = new int[k];

        // find total number of nodes in the linked list
        int count = 0;
        ListNode curr = head;
        while(curr != null) {
            count++;
            curr = curr.next;
        }

        //
        int avg = count/k;
        int mod = count % k;
        // filling the array with the average values, for example if total node = 11 and k = 3, then fill the array with 11/3 = 3
        Arrays.fill(arr, avg);
        int ind = 0;
        // add the remaining element to the array from the first index
        while(mod != 0){
            arr[ind++]++;
            mod--;
        }

        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(arr));

        curr = head;
        ListNode next = head.next;
        ind = 0;
        count = 1;
        ans[ind] = head;
        // traversing the linked list
        while(curr != null){
            // reach at the node from where we need to separate the list
            // we can ommit this check with just having count++ at the last and change count = 0 inside the arr[ind] == count check
            while(arr[ind] != count){
                curr = next;
                if(next != null) next = next.next;
                count++;
            }
            if(curr == null) break;

            // break the chain of the linked list and move the counter
            if(arr[ind] == count){
                count = 1;
                ind++;
                curr.next = null;
                if(ind < k) ans[ind] = next;
                if(next != null) System.out.println(next.val);
            }
            curr = next;
            if(next != null) next = next.next;
        }
        return ans;
    }
}
