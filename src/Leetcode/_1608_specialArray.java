package Leetcode;
import java.util.Arrays;

//https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/description/?envType=daily-question&envId=2024-05-27
public class _1608_specialArray {
    // TC : O(n)
    // SC : O(1)
  public int specialArray(int[] nums) {
        int start = 0;
        int end = nums.length;
        // binary searching on the number from 0 to length of array to find the special number
        while(start <= end){
            int mid = (start+end)/2;
            int check = lowerBound(mid,nums);
            if(mid == check) return mid;
            else if(mid > check) end = mid-1;
            else start = mid+1;
        }
        return -1;
    }
    // this function checks how many numbers are greater than or equal to mid
    public int lowerBound(int mid, int [] nums){
        Arrays.sort(nums);
        int s = 0, e = nums.length-1;
        int ans = -1;
        while(s <= e){
            int m = (s+e)/2;
            if(nums[m] >= mid){
                // 1 3 4 6 7 9 
                ans = nums.length - m;
                e = m -1;
            }
            else s = m + 1;
        }
        return ans;
    }

    // TC : O(n)
    // SC : O(n)
     public int specialArray2(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+1];

        // n = 9
        // 2 1 3 4 5 7 9 8 6
         // creating the frequency array
        for(int num: nums){
            if(num >= n) arr[n]++; // if a number is greater than or equal to length of arr than incrementing arr[n] as question states that greater than or equal to
            else arr[num]++;
        }
        
        int ans = 0;
        // checking from the length to 0 , that how many numbers are greater than or equal to the current number if same return
        for(int i = n; i > 0; i--){
            ans += arr[i];
            if(ans == i) return i;
        }

        return -1;
    }
}
