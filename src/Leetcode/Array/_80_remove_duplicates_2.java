package Leetcode.Array;
//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=problem-list-v2&envId=array

import java.util.TreeMap;

public class _80_remove_duplicates_2 {

    // TC : O(n * log n + n)
    // SC : O(n)
    public int removeDuplicates2(int[] nums) {
        // HashMap will not work as it doesn't sort the key in sorted order
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // n * log n
        for(int a : nums){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int ind = 0;
        for(int a : map.keySet()){
            for(int i = 0; i < Math.min(map.get(a), 2); i++) nums[ind++] = a;
        }
        return ind;
    }

    // TC : O(n)
    // SC : O(1)
    public int removeDuplicates(int[] nums) {
        int k = 2;
        // checking from index 2, if found 2nd index to be equal with k-2 index, this means the element appears 3 times, so just continue, if they are not same, then swap the current element with kth index, or set the kth index to current element and increment k
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
