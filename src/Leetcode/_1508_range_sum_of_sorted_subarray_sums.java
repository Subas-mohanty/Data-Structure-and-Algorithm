package Leetcode;

import java.util.*;
//https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/submissions/1344002008/?envType=daily-question&envId=2024-08-04
// https://www.youtube.com/watch?v=ZBNKXytHGew
public class _1508_range_sum_of_sorted_subarray_sums {

    // TC : O(n + n^2*log(n)) --> pushing to the minHeap + for each element doing insertion and removal from the queue and there are n^2 element(number of sub array)
    // SC : O(n^2)
    public int rangeSum(int[] nums, int n, int left, int right) {

        // minHeap in increasing order
        // [element, index]
        // sorting it using element
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int [] o1, int [] o2){
                return o1[0] - o2[0];
            }
        });

        // adding each element and their index as an array into the queue
        for(int i = 0; i < n; i++){
            pq.offer(new int[]{nums[i], i});
        }
        int sum = 0;
        int mod = (int)1e9+7;

        // finding the sum only till right
        for(int i = 1; i <= right; i++){
            int [] curr = pq.poll();
            // it is in the range, means it is greater than left (between left and right)
            if(i >= left){
                sum = (sum + curr[0]) % mod;
            }
            // if not out of bound
            if(curr[1] + 1 < n){
                curr[1]++; // going to the next index
                curr[0] = curr[0] + nums[curr[1]]; // cumulative sum
                pq.offer(curr);
            }
        }
        return sum;
    }


    // TC : O(n^2 + n^2(log n^2) + n^2) --> two nested loops + sorting on n2 elements(number of subarray) + calculating the sum
    // SC : O(n^2 +
    public int rangeSum2(int[] nums, int n, int left, int right) {
        List<Integer> list = new ArrayList<>();

        // finding all sub array sum
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += nums[j];
                list.add(sum);
            }
        }
        Collections.sort(list);
        long ans = 0;
        for(int i = left-1; i <= right - 1; i++){
            ans  += list.get(i);
        }
        return (int) (ans % ((int)1e9 + 7));
        }
    }
}
