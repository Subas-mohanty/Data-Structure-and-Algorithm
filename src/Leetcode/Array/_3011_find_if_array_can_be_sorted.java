package Leetcode.Array;

//https://leetcode.com/problems/find-if-array-can-be-sorted/description/?envType=daily-question&envId=2024-11-06

public class _3011_find_if_array_can_be_sorted {

    // TC : O(n^2)
    // SC : O(1)
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        boolean swapped = false;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-1-i; j++){
                if(nums[j] <= nums[j+1]) continue;
                else {
                    if(setBits(nums[j]) != setBits(nums[j + 1])) return false;
                    else{
                        int temp = nums[j];
                        nums[j] = nums[j+1];
                        nums[j+1] = temp;
                        swapped = true;
                    }
                }
            }
            if(!swapped) break;
        }
        return true;
    }
    int setBits(int num){
        int ans = 0;
        while(num > 0){
            if((num & 1) == 1) ans++;
            num = num >> 1;
        }
        return ans;
    }



    // TC : O(n)
    // SC : O(1)
    public boolean canSortArray2(int[] nums) {
        // Number of set bits of the elements in the current segment
        int numOfSetBits = Integer.bitCount(nums[0]);
        int maxOfSegment = nums[0];
        int minOfSegment = nums[0];

        // Initialize max of the previous segment to the smallest possible integer
        int maxOfPrevSegment = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (Integer.bitCount(nums[i]) == numOfSetBits) {
                // Element belongs to the same segment
                // Update min and max values of the segment
                maxOfSegment = Math.max(maxOfSegment, nums[i]);
                minOfSegment = Math.min(minOfSegment, nums[i]);
            } else { // Element belongs to a new segment
                // Check if the segments are arranged properly
                if (minOfSegment < maxOfPrevSegment) {
                    return false;
                }

                // Update the previous segment's max
                maxOfPrevSegment = maxOfSegment;

                // Start a new segment with the current element
                maxOfSegment = nums[i];
                minOfSegment = nums[i];
                numOfSetBits = Integer.bitCount(nums[i]);
            }
        }
        // Final check for proper segment arrangement
        if (minOfSegment < maxOfPrevSegment) {
            return false;
        }
        return true;
    }
}
