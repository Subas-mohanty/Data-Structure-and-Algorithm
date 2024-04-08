package Leetcode;

import java.util.Arrays;

//https://youtu.be/dxVcMDI7vyI?si=OkVXKgttOqaWNkHc
public class _72_min_platforms {
    public static void main(String[] args) {
        int [] arr = {900,1100,1235};
        int [] dep = {1000,1200,1240};
        int n = arr.length;
        System.out.println(findPlatform(arr, dep,n));
        System.out.println(f(arr, dep, n));
    }
    // greedy approach
    // TC : O(n)
    static int findPlatform(int arr[], int dep[], int n){
        Arrays.sort(arr);
        Arrays.sort(dep);
        int plat_needed = 1, result = 1;

        // two pointer , one starts from 1st index of arrival time and j starts from 0th index of departure time,
        int i = 1, j = 0;

        while(i < n && j < n){

            // if arrival time of a train is less than equal to departure time of any previous train we need one more platform
            if(arr[i] <= dep[j]){
                plat_needed++;
                i++;
            }
            // if arrival time of a train is greater than the departure time of a previous train then we have that platform as vacant so, we can use the same platform , we have previously increased that to one so decreasing it here
            else if (arr[i] > dep[j]) {
                plat_needed--;
               j++;
            }
            result = Math.max(plat_needed, result);
        }
        return result;
    }

    static int f(int [] arr, int [] dep, int n){
        int ans = 1;
        for (int i = 0; i < n; i++) {
           int temp = 1;
            for (int j = 0; j < n; j++) {
                if(i != j){
                    // if collapse happen between arrival time and departure time
                    // what does this condition means ?
                    // ans -: arr[i] >= arr[j] this means that ith train has arrived after the jth train that's why its arrival time is bigger than jth train, and dep[j] > arr[i] means that the ith train has arrived before the jth train has departed that's why we need another platform
                    // and we are taking the maximum of all this and that is our answer
                    if(arr[i] >= arr[j] && dep[j] > arr[i]) temp++;
                }
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }
}
