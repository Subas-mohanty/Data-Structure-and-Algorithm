package Assignment._06_searching._03_hard;
//https://leetcode.com/problems/find-in-mountain-array/
public class _06_find_in_mountain_array {
    public static void main(String[] args) {
        int [] arr={0,1,2,4,2,1};
        int target=3;
        int ans=binarySearch(arr,target);
        System.out.println(ans);
    }
    static int binarySearch(int[] arr,int target){
        if(arr.length==0)
            return -1;
        int start=0;
        int end=0;
        if(target<arr[peakIndexInMountainArray(arr)]){
            end=peakIndexInMountainArray(arr);
        }
        else{
            end=arr.length-1;
        }
        while (start <= end) {
            // find the middle element
//            int mid=(start+end)/2; // might be possible that (s+e) exceeds the range of int
            int mid=start+(end-start)/2;
            if (target<arr[mid]){
                end=mid-1;
            }
            if(target>arr[mid]){
                start=mid+1;
            }
            if(target== arr[mid]){
                return mid;
            }
        }
        return -1;
    }
    // this function finds the greatest element of the mountain array
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
