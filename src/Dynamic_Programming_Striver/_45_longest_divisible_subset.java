package Dynamic_Programming_Striver;

import java.util.Arrays;

public class _45_longest_divisible_subset {
    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 8, 16, 14, 28, 56, 112};
        Arrays.sort(arr);
        int length = arr.length;
        System.out.println(lis(arr, 0, -1));

        int[][] dp = new int[length][length + 1]; // coordinate shift
        for (int[] a : dp) Arrays.fill(a, -1);
        System.out.println(lis2(arr, 0, -1, dp));

        int[][] Dp = new int[length + 1][length + 1];
        System.out.println(lis3(arr, Dp));

        System.out.println(lis3(arr));
    }

    public static int lis(int[] arr, int ind, int prev) {
        if (ind == arr.length) return 0;

        int notTake = lis(arr, ind + 1, prev);
        int take = 0;
        if (prev == -1) take = 1 + lis(arr, ind + 1, ind);
        else if (arr[ind] % arr[prev] == 0) take = 1 + lis(arr, ind + 1, ind);

        return Math.max(notTake, take);
    }

    public static int lis2(int[] arr, int ind, int prev, int[][] dp) {
        if (ind == arr.length) return 0;

        if (dp[ind][prev + 1] != -1) return dp[ind][prev + 1];
        int notTake = lis2(arr, ind + 1, prev, dp);
        int take = 0;
        if (prev == -1 || arr[ind] % arr[prev] == 0) take = 1 + lis2(arr, ind + 1, ind, dp);

        return dp[ind][prev + 1] = Math.max(notTake, take);
    }

    public static int lis3(int[] arr, int[][] dp) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
//            dp[n][i] = 0;
            dp[i][0] = 1;
        }

//        for (int i = n-1; i >= 0 ; i--) {
//            for (int j = -1; j < n ; j++) {
//                int notTake = dp[i+1][j+1];
//                int take = 0;
//                if(j == -1 || arr[ind] % arr[prev] == 0) take = 1 + dp[i+1][i+1];
//                dp[i][j+1] = Math.max(notTake, take);
//            }
//        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= -1; j--) {
                int notTake = dp[i + 1][j + 1];
                int take = 0;
                if (j == -1 || arr[i] % arr[j] == 0) take = 1 + dp[i + 1][i + 1];
                dp[i][j + 1] = Math.max(notTake, take);
            }
        }
        return dp[0][0];
    }

    // this is something confusing , here we are doing something like , we took an element and comparing with its previous elements if an element is divisible then increase the count by 1 of the previous ans and take the max
    public static int lis3(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    max = Math.max(dp[i], 1 + dp[j]);
                    dp[i] = max;
                }
            }
        }
        return max;
    }
}
