package Leetcode.Array;

import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/description/?envType=daily-question&envId=2024-12-06
public class _2554_max_no_of_integers_to_choose_from_range_1 {
    // TC : (m + n)
    // SC : O(m)
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for(int a : banned) set.add(a);

        int count = 0;
        int sum = 0;
        for(int i = 1; i <= n; i++){
            if(sum == maxSum) return count;
            if(!set.contains(i) && sum + i <= maxSum){
                sum += i;
                count++;
            }
        }
        return count;
    }
}
