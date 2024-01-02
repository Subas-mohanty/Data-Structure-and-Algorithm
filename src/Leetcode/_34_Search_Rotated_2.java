package Leetcode;

public class _34_Search_Rotated_2 {
    public static void main(String[] args) {
        int [] nums = {1, 0, 1, 1, 1};
        System.out.println(search(nums, 0));
    }
    public static boolean search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length-1);
    }
    static boolean helper(int [] nums, int target, int start, int end){
        while(start<=end){
            int mid= start+(end-start)/2;
            if(nums[mid] == target){
                return true;
            }
            // the only case when our normal search in sorted array will fail when our start, mid and end will be equal so if we handle that case then rest part will be taken care by the normal unique element like search
            if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                start=start+1;
                end=end-1; // moving start to one place ahead and end to one place back , because we know that mid is not the answer if it was then it would have returned in the previous check, if mid is not the answer then neither start and end will be as all of them are same
                // and after doing this we are continuing the process as there might more cases like this and we will be doing so until this check fails and our next if statements get true
                continue;
            }

            // left sorted
            if(nums[start] <= nums[mid]){
                if(nums[mid] >= target && target >= nums[start]){
                    end=mid-1; // target in left part so search in left
                }
                else{
                    start = mid+1; // target is not in left so go to right
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
        return false;
    }
}
