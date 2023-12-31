package Leetcode;
//https://leetcode.com/problems/search-insert-position/
public class _32_Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        return helper(nums, target, 0, nums.length-1);
    }
    public int helper(int [] nums, int target, int start, int end){
        if(start>end){
            return -1;
        }
        while(start<=end){
            int mid=end-(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return start;
    }
}
