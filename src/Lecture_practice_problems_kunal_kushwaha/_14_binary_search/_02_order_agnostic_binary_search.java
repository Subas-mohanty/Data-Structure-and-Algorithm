package Lecture_practice_problems_kunal_kushwaha._14_binary_search;

public class _02_order_agnostic_binary_search {
    public static void main(String[] args) {
//        int [] arr={1,2,3,11,14,23,34,45,57,78,98};
        int [] arr={99,87,75,63,32,24,7,2,-4,-8};
        int target=-8;
        int ans=binarySearch(arr,target);
        System.out.println(ans);
    }
    static int binarySearch(int[] arr,int target){
        if(arr.length==0)
            return -1;
        int start=0;
        int end=arr.length-1;
        boolean isAsc=arr[start]<arr[end];
        while (start <= end) {
            // find the middle element
//            int mid=(start+end)/2; // might be possible that (s+e) exceeds the range of int
            int mid=start+(end-start)/2;
            if(target== arr[mid]){
                return mid;
            }
            if (isAsc) {
                if (target<arr[mid]){
                    end=mid-1;
                }
                if(target>arr[mid]){
                    start=mid+1;
                }
            }
            else{
                if (target<arr[mid]){
                    start=mid+1;
                }
                if(target>arr[mid]){
                    end=mid-1;
                }
            }
        }
        return -1;
    }
}
