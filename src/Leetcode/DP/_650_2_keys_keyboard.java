package Leetcode.DP;

import java.util.Arrays;

//https://leetcode.com/problems/2-keys-keyboard/description/
//https://www.youtube.com/watch?v=zELBK8_vB7Y
public class _650_2_keys_keyboard {

    // dp + memoization solution
    // TC : O(n*n)
    // SC : O(n * n)
    int [][] dp = new int[1001][1001];
    public int minSteps(int n) {
        if(n == 1) return 0; // we already have 1 A in the notepad
        for(int [] a : dp) Arrays.fill(a, -1);

        // adding 1 because if n is > 1 then at least for one time we have to copy so adding that step
        return 1 + solve(1, 1, n);
    }
    int solve(int currA, int clipA, int n){
        // if current A in the notepad == n, we found our answer
        if(currA == n) return 0;
        if(currA > n) return (int)1e9;

        if(dp[currA][clipA] != -1) return dp[currA][clipA];

        // we copy all the A's in the notepad and then paste it, 2 steps for copy and paste
        // if copyAllAndPaste currA = 2 * currA because currA was initially present and we add another currA to it, and in the clip board there will be currA number of A's
        int copyAllAndPaste = 1 + 1 + solve(currA + currA, currA, n);

        // paste the A's which are in clip board, so added 1, step for paste
        // if only paste then currA = currA + A's present in the clipboard, and in the clip board nothing will be changed
        int paste = 1 + solve(currA + clipA, clipA, n);

        return dp[currA][clipA] = Math.min(copyAllAndPaste, paste);
    }

    // optimal prime factorization solution
    // TC : O(sqrt n)
    // SC : O(1)
    public int minSteps2(int n) {
        int ans = 0;
        int dig = 2; // took digit = 2, because for 0 and 1 the answer will be 0, now from two we will start prime factorization, means we will start checking all the numbers from 2, which divides n, if it divides reduce the number n by n /= dig
        // and then adding the dig to the answer, because all the prime numbers(n) will need n steps so adding this to the answer, if not divisible by dig, then increase dig

        while(n != 1){
            while(n % dig == 0){
                ans += dig;
                n /= dig;
            }
            dig++;
        }
        return ans;
    }
}
