package Leetcode;
//https://leetcode.com/problems/sort-colors/description/
public class _61_sortColors {
    public void sortColors(int[] nums) {
        int zeros = 0;
        int ones = 0;
        int twos = 0;

        for(int num : nums){
            if(num == 0) zeros++;
            if(num == 1) ones++;
            if(num == 2) twos++;
        }
        int ind = 0;
        int n = nums.length;
        while(ind < n){
            while(zeros > 0){
                nums[ind++] = 0;
                zeros--;
            }
            while(ones > 0){
                nums[ind++] = 1;
                ones--;
            }
            while(twos > 0){
                nums[ind++] = 2;
                twos--;
            }
        }
    }

    // using dutch national flag algorithm
    public void dnf(int [] arr){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int mid = 0;

        while(mid <= high){
            if(arr[mid] == 0){
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else if(arr[mid] == 2){
                swap(arr, mid, high);
                high--;
            }
        }
    }
    public void swap(int [] arr, int f, int s){
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }
}
