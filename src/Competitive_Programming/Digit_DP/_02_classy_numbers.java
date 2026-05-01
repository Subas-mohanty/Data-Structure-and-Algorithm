package Competitive_Programming.Digit_DP;
import java.util.*;

//https://codeforces.com/contest/1036/problem/C

public class _02_classy_numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tt = sc.nextInt();
        while(tt-- > 0){
            long left = sc.nextLong();
            long right = sc.nextLong();
            Long [][][] dp = new Long[20][2][20];
            long first = helper(Long.toString(left - 1), 0, 1, 0, dp);

            dp = new Long[20][2][20];
            long second = helper(Long.toString(right), 0, 1, 0, dp);

            System.out.println(second - first);
        }
    }



    public static long helper(String num, int ind, int tight, int count, Long [][][] dp){
        if(count > 3) return 0;
        if(ind == num.length()) return 1;

        if(dp[ind][tight][count] != null) return dp[ind][tight][count];

        int limit = (tight == 1 ? num.charAt(ind) - '0' : 9);

        long ans = 0;

        for(int i = 0; i <= limit; i++){
            int updatedCount = count + (i != 0 ? 1 : 0);
            int newTight = tight & (i == num.charAt(ind) - '0' ? 1 : 0);
            ans += helper(num, ind + 1, newTight, updatedCount, dp);

        }

        return dp[ind][tight][count] = ans;
    }
}
