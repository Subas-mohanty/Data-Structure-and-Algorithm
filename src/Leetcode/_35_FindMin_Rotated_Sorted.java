package Leetcode;
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class _35_FindMin_Rotated_Sorted {
    public int findMin(int[] nums) {
        int start =0;
        int end = nums.length-1;
        int min = Integer.MAX_VALUE;
        while(start<=end){
            int mid=start+(end-start)/2;
            // either left part or the part will be sorted
            // when left part is sorted we set the min to the nums[start] because in the left part it is the smallest and move start to mid+1 to check min in next part
            if(nums[mid]>=nums[start]){
                min=Math.min(min, nums[start]);
                start=mid+1;
            }

            // same when right part is sorted we will compare the min with nums[mid], we can't check it with start as that part may not be sorted so checking with mid and then find it in the left part(end-1)
            else{
                min=Math.min(min, nums[mid]);
                end=mid-1;
            }
        }
        return min;
    }
}
