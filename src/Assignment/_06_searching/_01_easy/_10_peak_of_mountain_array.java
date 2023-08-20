package Assignment._06_searching._01_easy;
//https://leetcode.com/problems/peak-index-in-a-mountain-array/
public class _10_peak_of_mountain_array {
    public static void main(String[] args) {
        int [] arr={0,10,5,2};
        int ans=peakIndexInMountainArray(arr);
        System.out.println(ans);
    }
    static int peakIndexInMountainArray(int[] arr) {
        int start=0;
        int end=arr.length-1;
        int mid=0;
        while (start != end) {
            mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                // now in decreasing part of the array
                // this may be the answer
                // that's why end!= mid-1
                end=mid;
            }
            else if(arr[mid]<arr[mid+1]){
                // now in increasing part of the array
                start=mid+1;
            }
        }
        return start; // we can return end as well cuz both are equal
    }
}
