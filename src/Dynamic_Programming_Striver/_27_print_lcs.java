package Dynamic_Programming_Striver;

import java.util.Arrays;

// rewrite the code tomorrow first --> done
// https://replit.com/@Subas01/printLCS#src/main/java/Main.java
public class _27_print_lcs {
    // we can also use StringBuilder here
    public static String ans = "";
    public static void main(String[] args) {
        String s1 = "abcbbcacdbbac";
        String s2 = "bdgebbacdbbacgbaaldk";
        int ind1 = s1.length();
        int ind2 = s2.length();
        String s = "";
//        print(s1, s2, ind1-1, ind2-1, s);
//        System.out.println(ans);

        int [][] dp = new int[ind1+1][ind2+1];
        System.out.println(print2(s1, s2, dp));


//        fun(s1, s2, 0, 0, s);
//        System.out.println(ans);
    }


    public static void fun(String s1, String s2, int ind1, int ind2, String s){
        if (ind1 >= s1.length() || ind2 >= s2.length() ) {
            if (s.length() > ans.length()) {
                ans = s;
            }
            return;
        }
        if(s1.charAt(ind1) == s2.charAt(ind2)){
            s+= s1.charAt(ind1);
            fun(s1, s2, ind1 +1, ind2 +1, s);
        }
        else{
            fun(s1, s2, ind1+1, ind2, s);
            fun(s1, s2, ind1, ind2+1, s);
        }
    }


    public static void print(String s1, String s2, int ind1, int ind2, String s){
        if (ind1 < 0 || ind2 < 0) {
            String temp = new StringBuilder(s).reverse().toString();
            if (temp.length() > ans.length()) {
                ans = temp;
            }
            return;
        }
        if(s1.charAt(ind1) == s2.charAt(ind2)){
            s+= s1.charAt(ind1);
            print(s1, s2, ind1 - 1, ind2 - 1, s);
        }
        else{
            print(s1, s2, ind1-1, ind2, s);
            print(s1, s2, ind1, ind2-1, s);
        }
    }

    // we can print the LCS using the dp table, it's a little bit confusing , here is the video link will see later
    // https://youtu.be/-zI4mrF2Pb4?si=R2xHNO2Vnf4mdFUV
    // understood a lil bit
    public static int print2(String s1, String s2, int [][] dp){
        int l1 = s1.length();
        int l2 = s2.length();

        for(int i = 0; i <= l2; i++) dp[0][i] = 0; // when index1 = 0 we have to fill for all values of string s2 so, we took l2 and vice-versa for index2 = 0
        for(int i = 0; i <= l1; i++) dp[i][0] = 0;

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        int len = dp[l1][l2];
        String ans = "";
        int i = l1, j = l2;


        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                ans += s1.charAt(i-1);
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]) i--;
            else j--;
        }
        // the ans string is in reverse order so we have to reverse it
        String str = new StringBuilder(ans).reverse().toString();
        System.out.println(str);
        return dp[l1][l2];
    }
}
