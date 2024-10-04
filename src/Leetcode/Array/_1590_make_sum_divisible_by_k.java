package Leetcode.Array;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/make-sum-divisible-by-p/description/?envType=daily-question&envId=2024-10-03

public class _1590_make_sum_divisible_by_k {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long sum = 0;
        for(int a : nums) sum += a;
        int target = (int)(sum % p);

        // the array is divisible by p
        if(target == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        // till 0th index (excluding) the sum is -1
        map.put(0, -1);

        int ans = n;
        int curr = 0;
        for(int i = 0; i < n; i++){
            curr = (curr + nums[i]) % p; // prefix sum till ith index, taking the mod
            int find = (curr - target + p) % p; // remaining sum to make target

            // for ex: let's say our curr = 7, target = 4, so find will be 7 - 4 = 3, we need to find if 3 was found or present at any index < i, means if there is an index j, for which the prefix sum = 3, if we found such an index then take the min and update the result
            if(map.containsKey(find)) ans = Math.min(ans, i - map.get(find));

            // this curr will be the next previous or remaining when we move forward
            map.put(curr, i);
        }
        // if the ans is not updated, this means there is no such subarray so return -1
        return ans == n ? -1 : ans;
    }
}
