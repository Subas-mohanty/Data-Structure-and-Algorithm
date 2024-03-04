package Dynamic_Programming_Striver;
//https://bit.ly/4bVhJlj
// question states number of deletion and insertion to make s2 from s1
// we can find the longest common subsequence and the elements those are left in s1 and s2 will be either deleted or inserted so our answer will be the total number of elements left in s1 and s2
public class _31_min_insertion_and_deletion {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "anc";
        int l1 = s1.length();
        int l2 = s2.length();

        int [][] dp = new int[l1+1][l2+1];
        int lcs = makeString(s1, s2, dp);

        int ans = (l1 - lcs) + (l2 - lcs);
        System.out.println(ans);
    }

    // this is the lcs function we have been writing from last 5 or 6 videos may be
    public static int makeString(String s1, String s2, int [][] dp){
        int l1 = s1.length();
        int l2 = s2.length();

        for (int i = 0; i <= l1 ; i++) dp[i][0] = 0;
        for (int i = 0; i <= l2 ; i++) dp[0][i] = 0;

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[l1][l2];
    }
}
