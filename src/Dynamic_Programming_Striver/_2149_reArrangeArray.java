package Dynamic_Programming_Striver;

public class _2149_reArrangeArray {
    public int[] rearrangeArray(int[] nums) {
        // return helper(nums);
        return helper2(nums);
    }

    // TC : O(n^2)
    // SC : O(1)
    public int [] helper2(int [] nums){
        int sign = 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int j;
            for (j = i; j < n; j++) {
                // checking the number is positive or negative, if sign is negative then we want a negative number if sign is positive we want a positive number
                // if we want to negative but the number is positive
                // ex - 4 , then the loop will move as 4 * -1 < 0
                if (nums[j] * sign > 0) break;
            }

            // this is like insertion sort, checking from the end and swapping two values until condition is satisfied. i.e, reached till i
            for (int k = j - 1; k >= i; k--) {

                // swapping two values
                int temp = nums[k];
                nums[k] = nums[k + 1];
                nums[k + 1] = temp;
            }
            // changing the sign for alternating index
            sign *= -1;
        }
        return nums;
    }

    // TC : O(n)
    // SC : O(n)
    public int [] helper(int [] nums){
        int [] arr = new int[nums.length];
        int pos = 0;
        int neg = 1;

        for(int i = 0; i< nums.length; i++){
            if(nums[i] < 0){
                arr[neg] = nums[i];
                neg = neg+2;
            }
            else {
                arr[pos] = nums[i];
                pos = pos + 2;
            }
        }
        return arr;
    }
}
