package Assignment._06_searching._02_medium;

import java.util.Arrays;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class _01_first_and_last_position_of_element_in_sorted_array {
    public static void main(String[] args) {
        int [] arr={5,7,7,8,8,10};
        int target=8;
        int [] ans=searchRange(arr,target);
        System.out.println(Arrays.toString(ans));
    }
    static int[] searchRange(int[] nums, int target) {
        int [] ans={-1,-1};
        ans[0]=search(nums,target,true);
        if (ans[0] != -1) {
            ans[1]=search(nums,target,false);
        }
        return ans;
    }
    static int search(int[] nums,int target,boolean findFirstIndex) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        int count = 0;
        // what if the target is greater than the last element of the array
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                // potential answer found
                ans=mid;
                if (findFirstIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
