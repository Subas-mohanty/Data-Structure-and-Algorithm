package Dynamic_Programming_Striver;
//https://bit.ly/3vEYKce
public class _32_shortest_common_supersequences {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "bdge";
        int ind1 = s1.length();
        int ind2 = s2.length();
        String s = "";

        int [][] dp = new int[ind1+1][ind2+1];
        System.out.println(print2(s1, s2, dp));
    }


    // to get the length of the shortest common super sequence
    public static int shortestSupersequence(String a, String b) {
        int l1 = a.length();
        int l2 = b.length();

        int [][] dp = new int[l1+1][l2+1];
        int lcs = makeString(a, b, dp);

//        int ans = lcs + (l1 - lcs) + (l2 - lcs);
        int ans = l1 + l2 - lcs;
        return ans;
    }
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


    // confusing a little bit , practice it again
    // https://youtu.be/xElxAuBcvsU?si=Yo51MgUEOP_oiYtJ
    public static String print2(String s1, String s2, int [][] dp){
        int l1 = s1.length();
        int l2 = s2.length();

        for(int i = 0; i <= l2; i++) dp[0][i] = 0; // when index1 = 0 we have to fill for all values of string s2 so, we took l2 and vice-versa for index2 = 0
        for(int i = 0; i <= l1; i++) dp[i][0] = 0;

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }


        // what we are doing here,
        // we are checking from the end of the dp table
        int i = l1;
        int j = l2;
        String ans2 = "";
        while(i>0 && j>0){
            // when two characters are same we are adding it to ans and then decreasing both i and j
            if(s1.charAt(i-1) == s2.charAt(j-1)) {
                ans2 += s1.charAt(i-1);
                i--;
                j--;
            }
            // this means we are going upward so we are adding the i-1st character of the s1 string
            else if(dp[i-1][j] > dp[i][j-1]){
                ans2+=s1.charAt(i-1);
                i--;
            }
            // going left
            else{
                ans2+=s2.charAt(j-1);
                j--;
            }
        }

        // if any element left over , this is like how we are doing things in merge sort
        while(i>0) {
            ans2+=s1.charAt(i-1);
            i--;
        }
        while(j>0) {
            ans2+=s2.charAt(j-1);
            j--;
        }
        // ans2 is in reverse order so, we need to reverse it first
        String res = new StringBuilder(ans2).reverse().toString();
        return res;
    }
}
