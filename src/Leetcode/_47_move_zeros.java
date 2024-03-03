package Leetcode;

import java.util.Arrays;
//https://leetcode.com/problems/move-zeroes/description/
public class _47_move_zeros {
    public static void main(String[] args) {
        int [] arr = {0,1,0,0,9};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        int i = 0, j = 0;

        while (j < length) {
            while (j < length && nums[j] == 0) j++;

            //swap the values
            if (j < length) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
            j++;
            i++;
        }
    }

    public void helper2(int [] nums){
        int length = nums.length;
        int [] arr = new int[length];
        int ind = 0;
        for(int i = 0; i<length; i++){
            if(nums[i] == 0){
                arr[length-i-1] = 0;
            }
            else{
                arr[ind++] = nums[i];
            }
        }
        for(int i = 0; i<length; i++){
            nums[i] = arr[i];
        }
    }
}
