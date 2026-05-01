package Competitive_Programming.Digit_DP;

import java.util.Arrays;
import java.util.Scanner;

//https://www.spoj.com/problems/GONE/

public class _03_GONE_numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tt = sc.nextInt();

        Arrays.fill(isPrime, true);
        for(int i = 2; i < 10; i++){
            for(int j = i * 2; j < 100; j += i){
                isPrime[j] = false;
            }
        }
        isPrime[0] = false;
        isPrime[1] = false;


        while(tt-- > 0){
            long left = sc.nextLong();
            long right = sc.nextLong();

            Long [][][] dp = new Long[10][2][100];
            long leftAns = helper(Long.toString(left - 1), 0, 1, 0, dp);

            dp = new Long[10][2][100];
            long rightAns = helper(Long.toString(right), 0, 1, 0, dp);

            System.out.println(rightAns - leftAns);
        }
    }
    static boolean [] isPrime = new boolean[100];

    static long helper(String num, int ind, int tight, int sum, Long[][][] dp){
        if(ind == num.length()){
            if(isPrime[sum]) return 1;
            return 0;
        }

        if(dp[ind][tight][sum] != null) return dp[ind][tight][sum];

        int limit = (tight == 1 ? num.charAt(ind) - '0' : 9);

        long ans = 0;
        for(int i = 0; i <= limit; i++){
            int newTight = tight & (num.charAt(ind) - '0' == i ? 1 : 0);
            ans += helper(num, ind + 1, newTight, sum + i, dp);
        }
        return dp[ind][tight][sum] = ans;
    }
}