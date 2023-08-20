package Lecture_practice_problems._15_binary_search_interview_questions;

public class _03_find_in_infinite_array {
    public static void main(String[] args) {
        int [] arr={2,3,4,6,8,11,14,23,46,53,61,79,87};
        int target=11;
        int ans=ans(arr,target);
        System.out.println(ans);
    }
    static int ans(int [] arr,int target){
        int start=0;
        int end=1;
        while (target > arr[end]) {
                start=end+1;
                end=2*end;
        }
        return infiniteArray(arr,target,start,end);
    }
    static int infiniteArray(int [] arr,int target,int start,int end){
        int mid=0;
        while (start <= end) {
            // find the middle element
//            int mid=(start+end)/2; // might be possible that (s+e) exceeds the range of int
            mid=start+(end-start)/2;
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
        return mid;
    }
}
