package Leetcode.Bit_Manipulation;
//https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-ii/description/?envType=daily-question&envId=2024-11-10

public class _3097_shortest_subarray_with_OR_at_least_K_2 {

    // TC : O(n ^ 2)
    // SC : O(1)
    public int minimumSubarrayLength2(int[] nums, int k) {
        int n = nums.length;
        int min = (int)1e9;
        for(int i = 0; i < n; i++){
            int or = 0;
            for(int j = i; j < n; j++){
                or = or | nums[j];
                if(or >= k){
                    min = Math.min(min, j - i + 1);
                    break; // why break here, because we need the min length of sub-array
                }
            }
        }
        return min == (int)1e9 ? -1 : min;
    }
    // TC : O(n)
    // SC : O(32)
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int min = (int)1e9;

        int [] arr = new int[32];
        int i = 0;
        int j = 0;
        while(j < n){
            numToBitArray(arr, nums[j], 1); // add the numbers binary into the bit array
            while(i <= j && getDecimalFromArr(arr)>= k){
                min = Math.min(min, j - i + 1);
                numToBitArray(arr, nums[i], -1); // subtract the left number from bit array
                i++;
            }
            j++;
        }
        return min == (int)1e9 ? -1 : min;
    }
    // convert number to bit array
    // ex : 3 --> [1, 1]
    // now when we are adding the bit or doing OR with other numbers than we have to add the number to bit array but when we are removing the number(window shrink)/diff == -1, we have to remove the bit of the number from the bit array
    void numToBitArray(int [] arr, int num, int diff){
        int bitPos = 0;
        while(num > 0){
            if((num & 1) == 1) arr[bitPos] += diff;
            num = num >> 1;
            bitPos++;
        }
    }

    // converting an array of bits to decimal number
    // ex [1, 0, 1, 0] --> 5, not 10 because array index are form left to right 0, 1, 2, 3
    int getDecimalFromArr(int [] arr){
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if(arr[i] > 0) ans += (int)Math.pow(2, i);
            // if(arr[i] > 0) ans = ans | (1 << i); // can use this also, this is faster also
        }
        return ans;
    }
}
