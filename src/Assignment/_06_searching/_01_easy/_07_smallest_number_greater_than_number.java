package Assignment._06_searching._01_easy;
//https://leetcode.com/problems/find-smallest-letter-greater-than-target/
public class _07_smallest_number_greater_than_number {
    public static void main(String[] args) {
        char [] arr={'c','f','j'};
        char target='a';
        char ans=nextGreatestLetter(arr,target);
        System.out.println(ans);
    }
    static char nextGreatestLetter(char[] arr, char target) {
        int start=0;
        int end=arr.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            if (arr[mid] > target) {
                end=mid-1;
            } else{
                start=mid+1;
            }
        }
        return arr[start % arr.length];
    }
}
