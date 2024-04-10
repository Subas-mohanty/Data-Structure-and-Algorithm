package Leetcode;
//https://leetcode.com/problems/koko-eating-bananas/
public class _73_koko_eating_bananas {
    public static void main(String[] args) {
        int [] arr = {805306368,805306368,805306368};
        int h = 1000000000;
//        System.out.println(minEatingSpeed(arr, h));
        System.out.println(checkAns(arr, 1, h));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int num : piles) max = Math.max(max, num);

        int left = 1;
        int right = max;
        int ans = -1;

        while( left <= right){
            int mid = left + (right-left)/2;
            if(checkAns(piles, mid, h)){
                right = mid-1;
                ans = mid;
            }
            else {
                left = mid+1;
            }
        }
        return ans;
    }
    public static boolean checkAns(int [] arr, int ans, int h){
        long count = 0; // if we use int then for large number the sum of elements in the array will go to negative so we are using long
        for(int i = 0; i<arr.length; i++){
            if(arr[i] % ans == 0) count += arr[i]/ans;
            else count += arr[i]/ans+1;
        }
        return count <= h;
    }
}
