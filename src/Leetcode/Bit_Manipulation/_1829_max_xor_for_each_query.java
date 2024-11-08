package Leetcode.Bit_Manipulation;
//https://leetcode.com/problems/maximum-xor-for-each-query/?envType=daily-question&envId=2024-11-08
public class _1829_max_xor_for_each_query {
    // the main thing to observe in this problem is, any number xor with its complement gives the largest value

    // TC : O(n * k)
    // SC : O(n)
    public static int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int [] arr = new int[n];
        int ind = 0;
        int [] xor = new int[n];
        xor[0] = nums[0];
        for(int i = 1; i < n; i++) xor[i] = xor[i-1] ^ nums[i];

        for(int i = n-1; i >= 0; i--){
            int x = xor[i];
            for(int k = (int)Math.pow(2, maximumBit) - 1; k >= 0; k--){
                if((x & k) == 0){
                    arr[ind++] = k;
                    break;
                }
            }
        }
        return arr;
    }


    // TC : O(n)
    // SC : O(1)
    public static int[] getMaximumXor2(int[] nums, int maximumBit) {
        int n = nums.length;
        int [] arr = new int[n];
        int ind = 0;
        int [] xor = new int[n];
        xor[0] = nums[0];
        for(int i = 1; i < n; i++) xor[i] = xor[i-1] ^ nums[i];

        for(int i = n-1; i >= 0; i--){
            int x = xor[i];
            int k = findComplement(x, maximumBit);
            arr[ind++] = k;
        }
        return arr;
    }
    static int findComplement(int a, int maxBit){
        int mask = (int) Math.pow(2, maxBit) - 1;
        return mask ^ a;
    }
}
