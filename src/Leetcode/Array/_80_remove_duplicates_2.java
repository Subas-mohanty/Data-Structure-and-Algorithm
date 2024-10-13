package Leetcode.Array;
//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=problem-list-v2&envId=array

public class _80_remove_duplicates_2 {
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
