package Leetcode;
//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class _33_Search_Rotated {
    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length-1);
    }
    int helper(int [] nums, int target, int start, int end){
        if(start>end){
            return -1;
        }
        while(start<=end){
            int mid= start+(end-start)/2;
            if(nums[mid] == target){
                return mid;
            }
            // left sorted

            if(nums[start] <= nums[mid]){
                if(nums[mid] >= target && target >= nums[start]){
                    end=mid-1;
                }
                else{
                    start = mid+1;
                }
            }

            // right sorted
            else{
                if(target>=nums[mid] && target <=nums[end]){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }
}
