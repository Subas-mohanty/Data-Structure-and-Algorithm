package Lecture_practice_problems_kunal_kushwaha._15_binary_search_interview_questions;

public class _01_ceiling_number {
    public static void main(String[] args) {
        int [] arr={1,2,3,4,5,11,12,34,56,78,98};
        int ans=ceilingNumber(arr,100);
        System.out.println(ans);
    }
    // return the smallest number greater than or equal to target
    static int ceilingNumber(int [] arr,int target){
       int start=0;
       int end=arr.length-1;
       // what if the target is greater than the last element of the array
        if(target>arr[arr.length-1]){
            return -1;
        }
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
       return arr[start]; // when the while loop exit and, it did not find the answer then on the next iteration the start will move to the next greater element than the target and, we will get the answer . Cause in the second last iteration start=end=mid , so now as it is asking for greater element than target , the pointer will move to the required element with the head start .
        // jetele start and end equal heijiba then mid bi start and end saha saman heijiba so it will check now whether the target is less then or greater than mid , tapare it will run the if condition accordingly, in this case it is greater so it will increase the start by mid +1 and now the start will move over to smallest number greater than or equal to target .
    }
}
