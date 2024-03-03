package Dynamic_Programming_Striver;
//https://bit.ly/3H2ZtGP
public class _30_min_insertion_toMake_palindrome {
    public static void main(String[] args) {
        String s = "abcdefg";
        String reversed = new StringBuilder(s).reverse().toString();
        int [][] dp = new int[s.length()+1][s.length()+1];
        int lcs = lcs(s, reversed, dp);
        System.out.println(s.length() - lcs);
//        System.out.println(lcs(s, reversed, dp));
    }
    public static int lcs(String s1, String s2, int [][] dp){
        int l1 = s1.length();
        int l2 = s2.length();

        for (int i = 0; i <= l1; i++) dp[i][0] = 0;
        for (int i = 0; i <= l1; i++) dp[0][i] = 0;

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[l1][l2];
    }
}
