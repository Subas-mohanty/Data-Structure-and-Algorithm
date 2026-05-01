package Competitive_Programming.Digit_DP;

import java.util.Scanner;

//https://www.spoj.com/problems/LUCIFER/

public class _05_lucifer_numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tt = sc.nextInt();

        while(tt-- > 0){
            long left = sc.nextLong();
            long right = sc.nextLong();

            Long [][][][] dp = new Long[10][2][100][100];
            isEven = Long.toString(left - 1).length() % 2 == 0;
            long leftAns = helper(Long.toString(left - 1), 0, 1, 0, 0, dp);

            dp = new Long[10][2][100][100];
            isEven = Long.toString(right).length() % 2 == 0;
            long rightAns = helper(Long.toString(right), 0, 1, 0, 0, dp);

            System.out.println(rightAns - leftAns);
        }
    }

    static boolean isEven;

    static long helper(String num, int ind, int tight, int evenSum, int oddSum, Long[][][][] dp){
        if(ind == num.length()){
            if(isPrime(evenSum - oddSum)) return 1;
            return 0;
        }

        if(dp[ind][tight][evenSum][oddSum] != null) return dp[ind][tight][evenSum][oddSum];

        int limit = (tight == 1 ? num.charAt(ind) - '0' : 9);

        long ans = 0;
        for(int i = 0; i <= limit; i++){
            int newTight = tight & (num.charAt(ind) - '0' == i ? 1 : 0);

            int updatedEven = evenSum;
            int updatedOdd = oddSum;

            if(isEven){
                if(ind % 2 == 0) updatedEven += i;
                else updatedOdd += i;
            }
            else{
                if(ind % 2 == 0) updatedOdd += i;
                else updatedEven += i;
            }
            ans += helper(num, ind + 1, newTight, updatedEven, updatedOdd, dp);
        }
        return dp[ind][tight][evenSum][oddSum] = ans;
    }

    private static boolean isPrime(int num) {
        if(num < 2) return false;

        for(int i = 2; i * i <= num; i++){
            if(num % i == 0) return false;
        }

        return true;
    }
}