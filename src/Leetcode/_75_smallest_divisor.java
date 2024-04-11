package Leetcode;
//https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
class _75_smallest_divisor {
    public static void main(String [] args){
        int [] arr = {21212,10101,12121};
        int limit = 1000000;
        System.out.println(smallestDivisor(arr, limit));
    }
    public static int smallestDivisor(int[] nums, int threshold) {
        int min = 1;
        int max = nums[0];
        for(int num : nums){
            if(num > max) max = num;
        }
        return helper(nums, threshold, min, max);
    }
    public static int helper(int [] nums, int limit, int min, int max){
        int ans = -1;
        while(min <= max){
            int mid = min + (max-min)/2;
            if(checkSum(nums, limit, mid)){
                ans = mid;
                max = mid-1;
            }
            else min = mid+1;
        }
        return ans;
    }
    public static boolean checkSum(int [] arr, int limit, int ans){
        int count = 0;
        for(int i = 0; i< arr.length; i++){
            if(arr[i] % ans == 0) count += arr[i]/ans;
            else count += arr[i]/ans +1;
        }
        return count <= limit;
    }
}