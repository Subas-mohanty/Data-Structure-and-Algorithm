package Leetcode;
import java.util.*;
//https://shorturl.at/dMV15
public class _3075_maximumHappiness {
        public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int k = 4;
        System.out.println(maximumHappinessSum(arr, k));
    }

    public static long maximumHappinessSum(int[] arr, int k) {
        int n = arr.length;
        if(k > n) return -1;
        Integer [] ans = new Integer[n];
        for (int i = 0; i < n; i++) ans[i] = arr[i];

        Arrays.sort(ans, Collections.reverseOrder());
        long sum = ans[0];
        for (int i = 1; i < k; i++) {
            if (ans[i] - i >= 0) {
                sum += ans[i] - i;
            }
        }
        return sum;
    }
}
