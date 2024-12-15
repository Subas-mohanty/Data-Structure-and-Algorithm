package Leetcode.Sliding_Window;

import java.util.TreeMap;
//https://leetcode.com/problems/continuous-subarrays/description/?envType=daily-question&envId=2024-12-14

public class _2762_continuous_subarrays {
    // TC : O(n log n) --> n for while loop and log n for treemap
    // SC : O(n)
    public long continuousSubarrays(int[] nums) {
        long result = 0;

        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int i = 0;
        int j = 0;
        while(j < n){
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while(i < j && Math.abs(map.firstKey() - map.lastKey()) > 2) {
                int frq = map.get(nums[i]);
                if(frq == 1) map.remove(nums[i]);
                else map.put(nums[i], map.get(nums[i]) -1);
                i++;
            }
            result += j - i + 1;
            j++;
        }
        return result;
    }
}
