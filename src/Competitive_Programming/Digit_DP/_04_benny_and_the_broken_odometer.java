package Competitive_Programming.Digit_DP;

import java.util.*;

//https://www.hackerearth.com/problem/algorithm/benny-and-the-broken-odometer/

public class _04_benny_and_the_broken_odometer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tt = sc.nextInt();

        while(tt-- > 0){
            long n = sc.nextLong();

            dp = new Long[10][2][10];

            long ans = helper(Long.toString(n), 0, 1, 0);
            System.out.println(n - ans);
        }
    }
    static Long [][][] dp;
    static long helper(String num, int ind, int tight, int count){
        if(ind == num.length()){
            if(count >= 1) return 1;
            return 0;
        }

        if(dp[ind][tight][count] != null) return dp[ind][tight][count];

        int limit = (tight == 1 ? num.charAt(ind) - '0' : 9);

        long ans = 0;
        for(int i = 0; i <= limit; i++){
            int newTight = tight & (i == num.charAt(ind) - '0' ? 1 : 0);
            int updatedCount = count + (i == 3 ? 1 : 0);
            ans += helper(num, ind + 1, newTight, updatedCount);
        }
        return dp[ind][tight][count] = ans;
    }
}
