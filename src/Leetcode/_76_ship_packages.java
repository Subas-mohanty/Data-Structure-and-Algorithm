package Leetcode;
//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/submissions/1230648677/
public class _76_ship_packages {
    public static void main(String[] args) {
       int [] arr = {1,2,3,1,1};
       int days = 4;
        System.out.println(shipWithinDays(arr, days));
    }
    public static int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int maxInarr = 0; // we have to take the max element of the array as the min element because at any day we have to take that element and if the min is less than this then we can't take that element so, to take every element we have to take that as min
        int sum = 0; // this is the higher limit , because at max we can take this as the capacity and we can ship them in one day
        for(int num : weights){
            if(num > maxInarr) maxInarr = num;
            sum+=num;
        }

        // binary search
        int ans = -1;
        while(maxInarr <= sum){
            int mid = maxInarr + (sum - maxInarr)/2;
            if(checkDays(weights, mid, days)){
                ans = mid;
                sum = mid-1;
            }
            else maxInarr = mid+1;
        }
        return ans;
    }

    // checking if current capacity can transport them in the given days or not
    public static boolean checkDays(int [] arr, int mid, int limit){

        int sum = 0;
        int count = 1;
        for(int i = 0; i < arr.length; i++){
            if(sum + arr[i] <= mid) sum+=arr[i];
            else {
                sum = 0;
                sum+=arr[i];
                count++;
            }
        }
        return count <= limit;
    }
}
