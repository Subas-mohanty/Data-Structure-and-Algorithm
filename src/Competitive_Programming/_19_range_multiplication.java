package Competitive_Programming;

import java.util.Arrays;

/**
 * Problem:
 * Apply multiple range multiplication queries on an array and return
 * the final updated array.
 *
 * Query format: {l, r, m}
 * → Multiply all elements from index l to r by m
 *
 * Approach Used:
 * - Difference array technique + logarithmic transformation
 *
 * Why Log?
 * - Multiplication over ranges cannot be directly handled using difference arrays
 *   because division (for undoing effect at r+1) causes precision issues.
 *
 * - So we convert multiplication into addition using:
 *      log(a * b) = log(a) + log(b)
 *
 * - Then apply prefix sum and finally revert using exponentiation.
 */

public class _19_range_multiplication {

    public static void main(String[] args) {

        int[] arr = {3, 5, 2, 7, 1, 4, 6, 8, 9, 10};

        // Queries: {left, right, multiplier}
        int[][] queries = {
                {0, 5, 2},
                {2, 8, 3},
                {1, 3, 4},
                {6, 9, 5},
                {0, 9, 2},
                {4, 4, 10},
                {7, 8, 3}
        };

        int n = arr.length;

        // Prefix array to store log-based difference values
        double[] prefix = new double[n];

        for (int[] q : queries) {
            int l = q[0], r = q[1], m = q[2];

            // Convert multiplication into addition using log
            double log = Math.log(m);

            prefix[l] += log;

            // Mark end of range
            if (r + 1 < n) prefix[r + 1] -= log;
        }

        // Step 2: Convert difference array into prefix sum array
        for (int i = 1; i < n; i++) {
            prefix[i] += prefix[i - 1];
        }

        // Step 3: Apply accumulated multiplication to original array
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            // Convert back using exponentiation
            ans[i] = (int) Math.round(arr[i] * Math.exp(prefix[i]));
        }

        System.out.println(Arrays.toString(ans));
    }
}