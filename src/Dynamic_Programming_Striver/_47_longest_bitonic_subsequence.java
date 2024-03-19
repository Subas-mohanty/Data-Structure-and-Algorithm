package Dynamic_Programming_Striver;

import java.util.Arrays;
//https://bit.ly/3r4o1JB
//https://youtu.be/y4vN0WNdrlg?si=UcplrLZEQLC2Z7vf

public class _47_longest_bitonic_subsequence {
    public static void main(String[] args) {
        int [] arr = {1,2,10,4,5,2,1};
        int [] arr2 = {42,2,27,16,4,3,22,32,21,24,19};
        System.out.println(bitonic(arr2));
    }
    // the problem is like LIS , we can check for increasing part from the start of the array and we have to do the same from the end of the array and at maximum element of the array our answer will be lies
    public static int bitonic(int [] arr){
        int n = arr.length;
        int [] dp = new int[n];
        int [] dp2 = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(dp2, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

                // this is not gonna work
//                if(arr[i] < arr[j]){
//                    dp2[i] = Math.max(dp2[i], dp2[j]+1);
//                }
            }
        }
        for (int i = n-1; i >=0 ; i--) {
            for (int j = n-1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }
        for(int a : dp){
            System.out.print(a + " ");
        }
        System.out.println();
        for(int a : dp2){
            System.out.print(a + " ");
        }
        System.out.println();

        // creating the bitonic array and returning the max value of the array
        int maxi =0;
        int [] bitonic = new int[n];
        for(int i = 0; i< dp.length; i++){
            // the max element will be common in both of these so subtract it by 1
            bitonic[i] = dp[i] + dp2[i] -1;
            maxi = Math.max(maxi, bitonic[i]);
        }

        return maxi;
    }
}
