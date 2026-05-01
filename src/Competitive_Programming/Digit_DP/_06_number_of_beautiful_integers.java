package Competitive_Programming.Digit_DP;

// digit dp
//https://leetcode.com/problems/number-of-beautiful-integers-in-the-range/

public class _06_number_of_beautiful_integers {
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        K = k;

        int right = helper(Integer.toString(high), 0, 1, 1, 0, 0, 0);

        dp = new Integer[10][2][2][10][10][20];
        int left = helper(Integer.toString(low - 1), 0, 1, 1, 0, 0, 0);

        return right - left;
    }


    int K;
    Integer [][][][][][] dp = new Integer[10][2][2][10][10][20];

    int helper(String s, int ind, int tight, int flag, int even, int odd, int num){
        if(ind == s.length()) {
            if(flag == 0 && even == odd && num % K == 0) return 1;

            return 0;
        }

        if(dp[ind][tight][flag][even][odd][num] != null) return dp[ind][tight][flag][even][odd][num];

        int limit = (tight == 1 ? s.charAt(ind) - '0' : 9);

        int ans = 0;

        for(int i = 0; i <= limit; i++){
            int newTight = tight & (s.charAt(ind) - '0' == i ? 1 : 0);

            int updatedEven = even;
            int updatedOdd = odd;

            int newFlag = flag & (i == 0 ? 1 : 0);
//            int newFlag = (flag == 1 && i == 0) ? 1 : 0;

            if(newFlag == 0){
                if(i % 2 == 0) updatedEven++;
                else updatedOdd++;
            }

            int newNum = (num * 10 + i) % K;

            ans += helper(s, ind + 1, newTight, newFlag, updatedEven, updatedOdd, newNum);
        }

        return dp[ind][tight][flag][even][odd][num] = ans;
    }
}
