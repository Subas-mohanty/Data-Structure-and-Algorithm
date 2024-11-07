package Leetcode.Bit_Manipulation;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/?envType=daily-question&envId=2024-11-07

public class _2275_largest_combination_with_AND_greater_than_0 {

    // recursive + memoization solution
    // TC : O(n * m)
    // SC : O(n)
    Map<String, Integer> map = new HashMap<>();
    public int largestCombination2(int[] can) {
        return helper(can, 0, -1);
    }
    int helper(int [] arr, int ind, int and){
        if(ind == arr.length && and > 0) return 0;
        if(ind == arr.length) return -(int)1e9;

        String s = ind + "," + and;
        if(map.containsKey(s)) return map.get(s);
        int take = 1 + helper(arr, ind + 1, and & arr[ind]);
        int not = helper(arr, ind + 1, and);

        int max = Math.max(take, not);
        map.put(s, max);
        return max;
    }

    // TC : O(n)
    // SC : O(1) or O(24)
    // code explanation :
    // The longest combination will be given by the numbers that have 1 on the same position.
    // Use an int[24] count to count the position of 1s of each number;
    // in the array storing all the bit position value for each number, for ex : storing in which position there is a set bit for each number, now the max value of can[i] <= 1e7 so taking 24 size because 2 ^ 24 is 16777216, now we have to find the max of the array because in the array, we are storing the count of set bits, so at which index the count of setbits will be max, that much number of elements from the can array has setbits at that position and that will be our anwer
    // Return the max count of a position

    public int largestCombination(int[] can) {
        int [] arr = new int[24];
        for(int a : can){
            int bitPos = 0;
            while(a > 0){
                if((a & 1) == 1) arr[bitPos]++;
                a = a >> 1;
                bitPos++;
            }
        }
        int ans = 0;
        for(int a : arr) ans = Math.max(ans, a);
        return ans;
    }
}
