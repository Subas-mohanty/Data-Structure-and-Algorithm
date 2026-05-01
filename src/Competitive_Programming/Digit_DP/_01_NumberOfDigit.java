package Competitive_Programming.Digit_DP;

//https://leetcode.com/problems/number-of-digit-one/description/

public class _01_NumberOfDigit {
    // https://www.youtube.com/watch?v=cthI6e5KGgg

    // Notes : DSA 02 : 28-02-2026

    public static void main(String[] args) {
        // taking long because in digit dp problems, left and right can be up to 10^18
        long left = 2;
        long right = 13;
        int targetDigit = 1;


        int rightDigits = solve(Long.toString(right), 0, 1, 0, targetDigit);
        int leftDigits = solve(Long.toString(left - 1), 0, 1, 0, targetDigit);
        System.out.println(rightDigits - leftDigits);


    }
    // [index][tight][count]
    // what does tight means ?
    // tight is a boolean value 0 or 1, represents whether we can put [0,9] digits or not in a specific index, if tight is true -> restriction (so can't put all the digits);
    // else put [0,9]

    static Integer [][][] dp = new Integer[20][2][20];

    // num = 46257
    // when tight = 1, limit = 4 for index 0

    private static int solve(String num, int index, int tight, int count, int targetDigit){
        if(index == num.length()) return count;

        if(dp[index][tight][count] != null) return dp[index][tight][count];

        // what is the max range we can go for each index, if tight = 1, this means there is restriction so we can't put digit more than the current digit otherwise we can put [0,9]
        int limit = (tight == 1 ? num.charAt(index) - '0' : 9);

        int ans = 0;

        for(int i = 0; i <= limit; i++){

            // if found the targetDigit, then increase the count by 1
            int updatedCount = count + (i == targetDigit ? 1 : 0);

            // if once tight is false then it will remain false for all next indices
            // so if the current digit, i.e i == targetDigit, this means we can't put the [0,9] for next indices because restriction starts, so we mark tight as true
            int newTight = tight & (i == num.charAt(index) - '0' ? 1 : 0);


            ans += solve(num, index + 1, newTight, updatedCount, targetDigit);
        }
        return dp[index][tight][count] = ans;
    }
}
