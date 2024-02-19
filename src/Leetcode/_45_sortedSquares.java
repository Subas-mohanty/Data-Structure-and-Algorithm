package Leetcode;

import java.util.Arrays;
//https://leetcode.com/problems/squares-of-a-sorted-array/description/
// The approach is -: the question states the given array is sorted , so it's quite obvious that the elements whose absolute value is big will be at the edge and while we move towards the center the value will decrease .
// Now we can make a check that which elements absolute value is big, left or right, which will be greater we will add its squrae in the result array. When we complete all the iteration the result array will be sorted in decreasing order . Now reverse the array to get the answer
public class _45_sortedSquares {
  public static void main(String[] args) {
    int [] arr = {-3,2,0,1,4,5};
    System.out.println(Arrays.toString(sortedSquares(arr)));
  }
  // TC : O(n) + the inbuilt sorting that might be O(nlogn)
  // SC : O(n) for the result array
  public static int[] sortedSquares(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        int [] result = new int[right+1];
        int index = 0;
        while(left <= right){
        if(Math.abs(arr[left]) < Math.abs(arr[right])){
            result[index]= (int)Math.pow(arr[right], 2);
            right--;
        }
        else{
            result[index] = (int)Math.pow(arr[left], 2);
            left++;
        }
        index++;
        }
        Arrays.sort(result);
        return result;
    }
}
