package Assignment._10_Recursion._01_easy;

public class _03_Binary_search {
    public static void main(String[] args) {
        int [] arr={1,2,5,8,13,54};
        int target=13;
        int ans=search(arr,target);
        System.out.println(ans);
    }
    static int search(int[] arr, int target) {
        if(arr.length==0)
            return -1;
        int start=0;
        int end=arr.length-1;
        while (start <= end) {
            // find the middle element
    //           int mid=(start+end)/2; // might be possible that (s+e) exceeds the range of int
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
