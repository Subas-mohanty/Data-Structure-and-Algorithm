package Dynamic_Programming_Striver;

import java.util.Arrays;

public class _44_lis_binary_search {
    public static void main(String[] args) {
        int [] arr = {10,34,2,6,30,89,1};
        System.out.println(lis(arr));

        Arrays.sort(arr); // 1,2,6,10,30,34,89
//        System.out.println(Arrays.toString(arr));
//        int ans = Math.abs(Arrays.binarySearch(arr, 7)); // this is shit, it returns the index if the element is present and if not present then returns ind+1 , where ind = the index where that element would be put
//        System.out.println(ans);
        System.out.println(lowerBound(arr, 0, arr.length-1, 5));

    }

//    TC : O(n+logN) --> traversal and binary search
//    SC : O(n) --> for the temp array
    // the temp array is not storing the LIS , we are just using it to store the elements and get the length that's it
    public static int lis(int [] arr){
        int n = arr.length;
        int [] temp = new int[n];
        int ind = 0;
        temp[ind] = arr[0];
        int size = 1;
        for (int i = 1; i < n; i++) {
            if(arr[i] > temp[ind]){
                ind++;
                temp[ind] = arr[i];
                size++;
            }
            else{
                // binary search to find the lower bound or the first greater element than arr[i]
                int index = lowerBound(temp, 0, ind, arr[i]);
                temp[index] = arr[i];
            }
        }
//        return size;
        return ind+1;
    }


    private static int lowerBound(int[] temp, int s, int e, int i) {
        int lb = 0;

        while(s<=e){
            int mid = s + (e-s)/2;
            if(temp[mid] == i) return mid;
            else if(temp[mid] > i){
                lb = mid;
                e = mid-1;
            }
            else s = mid+1;
        }
        return lb;
    }
}