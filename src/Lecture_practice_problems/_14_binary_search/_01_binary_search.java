package Lecture_practice_problems._14_binary_search;

public class _01_binary_search {
    public static void main(String[] args) {
    int [] arr={1,2,3,11,14,23,34,45,57,78,98};
    int ans=binarySearch(arr,57);
    System.out.println(ans);
    }
    // return the index
    // return -1 if the element does not exist
    static int binarySearch(int[] arr,int target){
        if(arr.length==0)
            return -1;
        int start=0;
        int end=arr.length-1;
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
}
