package Lecture_practice_problems._15_binary_search_interview_questions;

public class _02_floor {
    public static void main(String[] args) {
        int [] arr={1,2,3,4,5,11,12,34,56,78,98};
        int ans=ceilingNumber(arr,0);
        System.out.println(ans);
    }
    // return the greatest number lesser than or equal to target
    static int ceilingNumber(int [] arr,int target){
        int start=0;
        int end=arr.length-1;
        // what if the target is lesser than the first element of the array
//        if(target<arr[arr.length-1]){
//            return -1;
//        }
        while(start<=end){
            int mid=start+(end-start)/2;
            if (arr[mid] > target) {
                end=mid-1;
            } else if (arr[mid] < target) {
                start=mid+1;
            } else{
                return mid;
            }
        }
        return arr[end]; // when the while loop exit and, it did not find the answer then on the next iteration the end will move to the next lesser element than the target and, we will get the answer . Cause in the second last iteration start=end=mid , so now as it is asking for lesser element than target , the pointer will move to the required element with the head end
    }
}
