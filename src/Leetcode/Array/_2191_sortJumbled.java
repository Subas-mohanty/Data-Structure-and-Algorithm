package Leetcode.Array;

import java.util.Arrays;
import java.util.Comparator;
// https://leetcode.com/problems/sort-the-jumbled-numbers/description/
public class _2191_sortJumbled {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int [] newNumber = convertToNewSys(mapping, nums); // getting the new number array
        int n = nums.length;

        Integer [] indices = new Integer[n];
        // creating an Integer array to store indices for the relative order
        for(Integer i = 0; i < n; i++) indices[i] = i;

        // sorting the indidces array according to the values of newNumber array
        Arrays.sort(indices, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return newNumber[a] - newNumber[b];
            }
        });

        int [] ans = new int[n];
        int i = 0;
        // creating the ans array from the indices and the original nums array
        for(int ind : indices){
            ans[i] = nums[ind];
            i++;
        }
        return ans;
    }

    // converting the original number to new number after mapping
    public int[] convertToNewSys(int [] mapping, int [] nums){
        int n = nums.length;
        int [] arr = new int[n];
        int ind = 0;

        for(int num : nums){
            if(num == 0){
                arr[ind++] = mapping[0];
                continue;
            }
            int i = 0;
            int val = 0;
            while(num > 0){
                int last = num%10;
                num /= 10;
                val = mapping[last] * (int)Math.pow(10, i) + val;
                i++;
            }
            arr[ind++] = val;
        }
        return arr;
    }
}
