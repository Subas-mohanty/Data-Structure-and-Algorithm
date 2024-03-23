package Dynamic_Programming_Striver;

import java.util.Arrays;

public class _51_cost_to_cut {

    public static void main(String[] args) {
        int[] arr = {1, 8, 3, 5};
        int n = arr.length;

        // 1 2 3 4 5
        // 0 1 3 4 5

		Arrays.sort(arr);
        int length = 9;
        int[] newArr = new int[n + 2];

        newArr[0] = 0;
        newArr[n + 1] = length;
        for (int i = 0; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        System.out.println(cost(newArr, 1, n));

		int [][] dp = new int[n+1][n+1];
		for(int [] a: dp) Arrays.fill(a, -1);
		System.out.println(cost2(newArr, 1, n, dp));
    }

    public static int cost(int[] arr, int i, int j) {
        if (i > j) return 0;
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = arr[j + 1] - arr[i - 1] + cost(arr, i, k - 1) + cost(arr, k + 1, j);
            min = Math.min(min, cost);
        }
        return min;
    }
	public static int cost2(int[] arr, int i, int j, int[][] dp) {
        if (i > j) return 0;
        int min = Integer.MAX_VALUE;

		if(dp[i][j] != -1) return dp[i][j];

        for (int k = i; k <= j; k++) {
            int cost = arr[j + 1] - arr[i - 1] + cost2(arr, i, k - 1, dp) + cost2(arr, k + 1, j, dp);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }
}
