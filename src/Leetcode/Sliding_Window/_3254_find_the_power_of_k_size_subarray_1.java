package Leetcode.Sliding_Window;

import java.util.Arrays;

public class _3254_find_the_power_of_k_size_subarray_1 {
    public static void main(String[] args) {
        int [] arr = {2,2,2,2,2};
        int k = 4;
        System.out.println(Arrays.toString(resultsArray(arr, k)));
        System.out.println(Arrays.toString(resultsArray2(arr, k)));
    }
    // brute force solution
    // TC : O((n - k) * k)
    // SC : O(n- k + 1) --> asked in the question
    public static int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int [] ans = new int[n - k + 1];


        // we are checking each k size sub-array
        outer:
        for(int i = 0; i <= n-k; i++){
            int j;
            // this loop will run for k - 1 times, for k sized sub-array, and we are checking for consecutiveness, if the element are consecutive as well as increasing then after the loop set ans[i] to nums[j-1], because j will have move one index forward,
            // if the condition fails, set ans[i] to -1 and continue the outer loop
            for(j = i+1; j < i+k; j++){
                if(nums[j] != nums[j-1] + 1){
                    ans[i] = -1;
                    continue outer;
                }
            }
            ans[i] = nums[j-1];
        }
        return ans;
    }



    // optimal approach
    // TC : O(2 * n) --> visiting all elements twice, once for i and once for j
    // SC : O(1)

    public static int[] resultsArray2(int[] nums, int k) {
        int n = nums.length;
        int [] ans = new int[n - k + 1];
        Arrays.fill(ans, -1);

        int count = 1;
        // checking for first window
        for(int i = 1; i < k; i++){
            if(nums[i] == nums[i-1] + 1){
                count++;
            }
            else count = 1;
        }
        if(count == k) ans[0] = nums[k-1];

        int i = 1;
        int j = k;

        while(j < n){
            // for next window, check if the next coming element is consecutive or not, if consecutive, increase the count else reset it to 1, means no consecutive element
            if(nums[j - 1] + 1 == nums[j]){
                count++;
            }
            else{
                count = 1;
            }
            // if the number of consecutive element is >= k, this means, this window have all the element as consecutive and maybe some more consecutive element is previously present so update the answer to nums[j]
            if(count >= k) ans[i] = nums[j];

            // move the window
            i++;
            j++;
        }
        return ans;
    }
}
