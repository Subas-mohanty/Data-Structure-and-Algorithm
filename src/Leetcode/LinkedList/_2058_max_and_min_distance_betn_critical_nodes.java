package Leetcode.LinkedList;

import java.util.ArrayList;

// https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/

public class _2058_max_and_min_distance_betn_critical_nodes {


    // TC : O(n)
    // SC : O(n) --> for the list
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null || head.next == null) return new int[]{-1,-1};

        ArrayList<Integer> list = new ArrayList<>();

        ListNode prev = head;
        ListNode curr = prev.next;
        ListNode next = curr.next;
        int count = 0;
        while(curr != null){
            if(next != null && (curr.val > prev.val && curr.val > next.val)){
                list.add(count);
            }
            if(next != null && (curr.val < prev.val && curr.val < next.val)){
                list.add(count);
            }
            count++;
            prev = curr;
            curr = next;
            if(next != null) next = next.next;
        }
        // this means only one maxima or minima is present and that's why returning [-1,-1]
        if(list.size() <= 1) return new int[]{-1,-1};

        int max = list.getLast() - list.get(0);
        int min = (int) 1e9;
        for(int i = list.size()-1; i > 0; i--){
            min = Math.min(min, list.get(i) - list.get(i-1));
        }
        return new int[]{min, max};
    }



    // this doesn't user any extra space
    // TC : O(n)
    // SC : O(1)
    public int[] nodesBetweenCriticalPoints2(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;

        int ind = 1;
        int prev_ind = -1;
        int first_ind = -1;
        int last_ind = -1;
        int min_dist = Integer.MAX_VALUE;

        while(curr.next != null){
            // checkk for maxima or minima
            if(curr.val > prev.val && curr.val > curr.next.val || curr.val < prev.val && curr.val < curr.next.val){
                // when we found the maxima or minima for the first time, storing the index as first index
                if(first_ind == -1){
                    first_ind = ind;
                    prev_ind = ind;
                }
                else{
                    min_dist = Math.min(min_dist, ind - prev_ind);
                }
                prev_ind = ind;
            }
            ind++;
            prev = curr;
            curr = curr.next;
        }
        if(min_dist == Integer.MAX_VALUE) return new int[]{-1, -1};

        last_ind = prev_ind; // storing the last index, where we found a maxima or minima last time, and the diff between first_ind and last_ind will be the maximum distance
        return new int[]{min_dist, last_ind - first_ind};
    }


    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
