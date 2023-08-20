package Assignment._06_searching._01_easy;

import java.util.Arrays;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
// solved using two pointer method can't figure out how to do it using binary search
public class _04_two_sum {
    public static void main(String[] args) {
        int [] arr={2,7,11,15};
        int target=9;
        int [] ans=twoSum(arr,target);
        System.out.println(Arrays.toString(ans));
    }
    static int[] twoSum(int[] numbers, int target) {
        int start=0;
        int end=numbers.length-1;
        int[] ans=new int[2];
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                ans[0]=start+1;
                ans[1]=end+1;
                break;
            }
            else if(numbers[start] + numbers[end] < target){
                start++;
            }
            else{
                end--;
            }
        }
        return ans;
    }
}
