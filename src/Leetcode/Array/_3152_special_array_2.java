package Leetcode.Array;
//https://leetcode.com/problems/special-array-ii/submissions/1474383282/?envType=daily-question&envId=2024-12-09
public class _3152_special_array_2 {

    // TC : O(q * n)
    // SC : O(1)
    public boolean[] isArraySpecial2(int[] nums, int[][] queries) {
        boolean [] arr = new boolean[queries.length];
        int ind = 0;
        // for each query check if the array is special or not
        outer:
        for(int [] a : queries){
            for(int i = a[0]; i < a[1]; i++){
                if(i != nums.length - 1 && (nums[i] + nums[i+1]) % 2 == 0) {
                    arr[ind++] = false;
                    continue outer;
                }
            }
            arr[ind++] = true;
        }
        return arr;
    }
    // brute force is giving TLE so we have to find a better approach
    // TC : O(q + n)
    // SC : O(n)
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        boolean [] arr = new boolean[queries.length];
        int ind = 0;

        // this prefix array store the no of violating elements till the index, for ex
        // nums     3 4 1 2 6 7
        // prefix   0 0 0 0 1 1 --> for the first element the no of violating element is 0, then for 1 check for the previous value if both are even or both are add, then this is a violating element which means it can't make a special array, if both have different parity(even and odd), then no of violating element remains same
        int [] prefix = new int[n];
        prefix[0] = 0;
        for(int i = 0; i < n - 1; i++){
            // sum of even + even or odd + odd gives even, so adding one more violating element
            if((nums[i] + nums[i+1]) % 2 == 0) prefix[i+1] = prefix[i] + 1;
            else prefix[i+1] = prefix[i]; // same no of violating element
        }

        for(int [] a : queries){
            int s = a[0];
            int e = a[1];
            // this means inside this range no violating element is found so the array is special
            if(prefix[s] - prefix[e] == 0) arr[ind++] = true;
            else arr[ind++] = false;
        }
        return arr;
    }
}
