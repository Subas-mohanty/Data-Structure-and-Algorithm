package Leetcode.BinarySearch;

import java.util.Arrays;
//https://leetcode.com/problems/count-the-number-of-fair-pairs/description/?envType=daily-question&envId=2024-11-13


// the first question would be the question says we need pairs where i < j, and we are sorting the elements how does that work ?
// We only need the sum which is nums[i] + nums[j]
// But since nums[i] + nums[j] == nums[j] + nums[i], then the order does not matter.
// If the question requires you to get the pairs, then the order does matter since (i, j) != (j, i).

// now our task is to find the number of pairs which sum is less than lower (storing it in low)
// and number of pairs which sum is less than or equal to upper (storing it in high)
// subtracting them will give us the number of pairs having lower <= sum and sum <= upper
public class _2563_count_number_of_fair_pairs {
    // TC : O(n * log n)
    // SC : O(1)

    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        long count = 0;
        Arrays.sort(nums);

        for(int i = 0; i < n; i++){
            // low will have the index of the largest element which sum with nums[i] < lower and high will give the index of the largest element which sum with nums[i] <= upper and by subtracting we can get the number of element where lower <=  nums[i] + element <= upper
            long low = lowerBound(nums, i + 1, lower - nums[i]);
            long high = lowerBound(nums, i + 1, upper - nums[i] + 1);

            count += high - low;
        }

        return count;
    }

    // this will found lower bound for an element between index s and e (both are inclusive)
    // for 5 it will give index of 4 or 3 or 2 which ever is present
    long lowerBound(int [] arr, int s, int element){
        int e = arr.length - 1;
        while(s <= e){
            int mid = e - (e - s)/2;
            if(arr[mid] >= element) e = mid - 1;
            else s = mid + 1;
        }
        return s;
    }
}
