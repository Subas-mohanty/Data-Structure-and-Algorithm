package Leetcode.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/?envType=daily-question&envId=2024-12-16

public class _3264_final_array_state_after_k_operations {
    public static void main(String[] args) {
        int [] arr = {1,2};
        int k = 3;
        int m = 4;
        System.out.println(Arrays.toString(getFinalState(arr,  k, m)));
    }

    // brute force
    // TC : O(k*n)
    // SC : O(1)
    public static int[] getFinalState2(int[] nums, int k, int multiplier) {
        int n = nums.length;
        int [] ans = nums;

        // for each k, find the min element and replace it with
        while(k-- > 0){
            int min = 0;
            for(int i = 0; i < n; i++){
                if(nums[i] < nums[min]) min = i;
            }
            ans[min] = nums[min] * multiplier;
        }
        return ans;
    }

    // TC : O(n log n + k log n)
    // SC : O(2n) --> for index and element
    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        int [] ans = nums;
        Queue<int[]> q = new PriorityQueue<>((a, b)-> {
            if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        for(int i = 0; i < n; i++) q.offer(new int[]{i, nums[i]});

        while(k-- > 0){
            int [] removed = q.poll();
            int ind = removed[0];
            int ele = removed[1];
            ans[ind] = ele * multiplier;
            q.offer(new int[]{ind, ele * multiplier});
        }
        return ans;
    }
}
