package Leetcode.HashSet;

import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/description/?envType=daily-question&envId=2024-09-24

public class _3043_find_length_of_longest_common_prefix {

    // TC : O(n * x + m * y) --> n = arr1.length, m = arr2.length, x = no. of digits in the max num in arr1, y = no. of digits in the max num in arr2
    // SC : O(n * x) --> x = no. of digits in the max num in arr1
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();

        for(int num : arr1){
            // for each num adding all of its prefix in the set
            while(num > 0){
                set.add(num);
                num /= 10;
            }
        }

        int len = 0;
        for(int num : arr2){
            while(num > 0){
                // for each num in arr2, checking all prefix, if it is present in the set, then take the maximum length;
                int digitInNum = (int)Math.log10(num) + 1;
                if(set.contains(num)) len = Math.max(len, digitInNum);
                num /= 10;
            }
        }
        return len;
    }
}
