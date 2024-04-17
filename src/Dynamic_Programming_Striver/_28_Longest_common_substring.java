package Dynamic_Programming_Striver;

// youtube video link
//https://www.youtube.com/watch?v=_wP9mWNPL5w&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=28&ab_channel=takeUforward

public class _28_Longest_common_substring {
    public static void main(String[] args) {
        String s1 = "abde";
        String s2 = "bdge";
        int ind1 = s1.length();
        int ind2 = s2.length();

        System.out.println(lcs(s1, s2, ind1-1, ind2-1, 0));
        int [][] Dp = new int[ind1+1][ind2+1];
        System.out.println(print(s1, s2, Dp));
    }

    // recursion code
    public static int lcs(String s1, String s2, int len1, int len2, int count) {
        // Base case: if either string is empty, return the count
        if (len1 < 0 || len2 < 0)
            return count;

        // If the last characters of both strings match
        if (s1.charAt(len1) == s2.charAt(len2)) {
            count = lcs(s1, s2, len1 - 1, len2 - 1, count + 1);
        }

        // Check the substring excluding the last character of s1 and s2
        count = Math.max(count, Math.max(lcs(s1, s2, len1 - 1, len2, 0), lcs(s1, s2, len1, len2 - 1, 0)));

        return count;
    }


    // TC : O(m*n)
    // SC : O(m*n) for the dp array
    public static int print(String s1, String s2, int [][] dp){
        int l1 = s1.length();
        int l2 = s2.length();

        for (int i = 0; i <= l2; i++) dp[0][i] = 0;
        for (int i = 0; i <= l1; i++)  dp[i][0] = 0;

        int ans = 0;
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    ans = Math.max(ans, dp[i][j]);
                }
                // when two consecutive elements are not equal then we can't find a substring there so the ans for that is 0
                else dp[i][j] = 0;
            }
        }
        // dp array is created so, now we have to find the maximum element in the dp array
//        int max = 0;
//        for(int [] a : dp){
//            for (int i = 0; i < a.length; i++) {
//                if(a[i] > max) max = a[i];
//            }
//        }
//        return max;
        return ans;
    }
}
