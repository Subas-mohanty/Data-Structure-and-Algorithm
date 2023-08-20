package Lecture_practice_problems._23_Recursion_01;

public class _04_binary_search {
    public static void main(String[] args) {
        int [] arr={1,2,3,4,5,6,7,8,9};
        int target=8;
        int ans=search(arr,target,0,arr.length-1);
        System.out.println(ans);
    }
    static int search(int [] arr,int target,int s,int e){
        if (s > e) {
            return -1;
        }
        int m=s+(e-s)/2;
        if (arr[m] < target) {
            return search(arr,target,m+1,e); // if the target element lies in the right hand side we need to change the start to mid+1
        } else if (arr[m] >target) {
            return search(arr,target,s,m-1); // if the target element lies in the left hand side we need to change the end to mid-1
        }
        return m; // here arr[m] == target , so this is the answer
    }
}
