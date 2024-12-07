package Leetcode.BinarySearch;

// https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/?envType=daily-question&envId=2024-12-07
public class _1760_min_limit_of_balls_in_bag {
    // TC : O(n + log(max) * n)
    // SC : O(1)

    // in the best case there can be 1 ball each in the bag, or in the worst case there can be max number of balls in the bag, so doing binary search and checking our mid is a potential answer or not, means can we put mid, numbers of balls in each bag, if so then check for more smaller numbers and get the answer
    public int minimumSize(int[] nums, int maxOp) {
        int max = 0;
        for(int a : nums) max = Math.max(max, a);
        int start = 1;
        int end = max;
        int ans = 0;
        while(start <= end){
            int mid = end - (end - start) / 2;
            if(isAns(mid, nums, maxOp)){
                ans = mid;
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return ans;
    }
    // this is checking if we can put mid number of balls in each bag after max number of operations
    boolean isAns(int mid, int [] nums, int max){
        int count = 0;
        for(int a : nums){
            if(a <= mid) continue;
            if(count > max) return false;
            if(a % mid == 0) count += a/mid - 1;
            else count += a/mid;
        }
        return count <= max;
    }
}
