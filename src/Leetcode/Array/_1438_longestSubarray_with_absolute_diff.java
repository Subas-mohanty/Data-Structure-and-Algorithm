package Leetcode.Array;

import java.util.ArrayDeque;
import java.util.Deque;
//https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/?envType=daily-question&envId=2024-06-23

// youtube explanation
//https://www.youtube.com/watch?v=-03XJSf8R9E
public class _1438_longestSubarray_with_absolute_diff {
    public int longestSubarray(int [] nums, int limit) {
        int n = nums.length;
        int ans = 0;
        int left = 0;

        // using deque to store the max and min element in the subarray
        Deque<Integer> inc = new ArrayDeque<>(); // to store the min element
        Deque<Integer> dec = new ArrayDeque<>(); // to store the max element


        for(int right = 0; right < n; right++){

            // if we get a smaller element than the top of inc deque then remove it and opposite for dec deque
            while(!inc.isEmpty() && inc.getLast() > nums[right]) inc.removeLast();
            while(!dec.isEmpty() && dec.getLast() < nums[right]) dec.removeLast();


            // now add the current element in both the queue
            inc.addLast(nums[right]);
            dec.addLast(nums[right]);

            // this means our window get invalid so we have to move our left pointer
            while(dec.getFirst() - inc.getFirst() > limit){

                // if the window get invalid due to inc deque we remove the first element from the inc deque else otherwise
                if(dec.getFirst() == nums[left]) dec.removeFirst();
                if(inc.getFirst() == nums[left]) inc.removeFirst();
                left++;
            }
            // calculating the length of the subarray
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
