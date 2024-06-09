package Leetcode;

public class _974_subarray_sum_divisible_by_k {
    public int subarraysDivByK(int[] arr, int k) {
        int ans = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if(sum % k == 0) ans++;
            }
        }
        return ans;
    }
}
