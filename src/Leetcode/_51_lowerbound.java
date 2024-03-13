package Leetcode;

public class _51_lowerbound {
    public static int upperBound(int []arr, int x, int n){
        return search(arr, n, x);
    }
    public static int search(int [] arr, int n, int target){
        if(target > arr[n-1]) return n;
        if(target < arr[0]) return 0;

        int ub = n;
        int start = 0;
        int end = n;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == target) start = mid+1;
            else if(arr[mid] > target){
                ub = mid;
                end = mid-1;
            }
            else start = mid+1;
        }
        return ub;
    }
}
