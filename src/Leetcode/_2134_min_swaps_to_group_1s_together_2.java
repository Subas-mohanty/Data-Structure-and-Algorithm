package Leetcode;

//https://shorturl.at/dfuL5
public class _2134_min_swaps_to_group_1s_together_2 {

    // TC : O(n + n + 2n)
    // SC : O(1)
    // intuition : sliding window
    // find total number of 1's in the array
    // keep the window size equal to total number of 1's
    // find the window with maximum number of 1 in it
    // subtract number of 1's in that window from the total number of 1 present, and that will be the answer as at minimum we have to swap that number of times to put all the 1's together
    public int minSwaps(int[] nums) {
        int count = 0;
        int n = nums.length;
        // counting number of 1's in the array
        for(int num : nums){
            if(num == 1) count++;
        }
        // window size is from i to j
        int i = 0;
        int j = i + count-1;
        int max = 0;
        // finding number of 1's in the first window
        int oneInWindow = findOne(nums, i, j);
        // going till 2n, because we have to check for cycle as well
        // while(j < 2*n) , we can also check this, and can check nums[i] but there is no need , because when we reach at i == n, we no need to check further as it will be repetetive as we have calculated from 0 to windowsize - 1
        while(i < n){
            max = Math.max(max, oneInWindow);
            int start = nums[i]; // start value of a window
            int end = nums[(j+1) % n]; // start value of the new window, ex - window size is 3, 1 0 1 1, end is the last one
            // updating the number of 1's in the current window
            if(start == 1 && end == 0) oneInWindow--;
            if(start == 0 && end == 1) oneInWindow++;
            i++;
            j++;
        }
        return count - max;
    }
    public int findOne(int [] arr, int i , int j){
        int count = 0;
        for(int k = i; k <= j; k++){
            if(arr[k % arr.length] == 1) count++;
        }
        return count;
    }
}
