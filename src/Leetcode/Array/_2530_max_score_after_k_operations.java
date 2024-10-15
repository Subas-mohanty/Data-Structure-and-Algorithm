package Leetcode.Array;

import java.util.Collections;
import java.util.PriorityQueue;
//https://leetcode.com/problems/maximal-score-after-applying-k-operations/?envType=daily-question&envId=2024-10-14
public class _2530_max_score_after_k_operations {
    public static void main(String[] args) {
        int [] arr = {1, 10, 3, 3, 3};
        int k = 3;
        System.out.println(maxKelements(arr, k));
    }
    public static long maxKelements(int[] nums, int k) {
        long sum = 0;
        // store the numbers in descending order and take the largest element first, add in the ans and then put the num/3 in the heap again, do it k times
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int a : nums) pq.offer(a);

        while(k-- > 0){
            int num = pq.poll();
            sum += num;
            int ele = num % 3 == 0 ? num/3 : num/3 + 1;
            // int ele = (int)Math.ceil((double)num/3); this is how to use the ceil function
            // int ele = (num + 2) / 3; this also works
            pq.offer(ele);
        }
        return sum;
    }
}
