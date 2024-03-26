package Leetcode;

import java.util.ArrayList;
import java.util.List;
//https://shorturl.at/fELMT
public class _59_binary_Strings {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(helper("", n, true, new ArrayList<>()));

        System.out.println(helper2(n));
    }
    public static List<String> helper(String s, int ind, boolean canOne, List<String> list){
        if(ind == 0){
            list.add(s);
            return list;
        }
        if(canOne){
            helper(s+"0", ind-1, true, list);
            helper(s+"1", ind-1, false, list);
        }
        else{
            helper(s+"0", ind-1, true, list);
        }
        return list;
    }


    // it will generate all the possible binary strings in tabulation method
    public static List<String> helper2(int ind){
        List<String>[] dp = new ArrayList[ind+1];
        for (int i = 0; i <= ind; i++) {
            dp[i] = new ArrayList<>();
        }
        dp[0].add("");

        for (int i = 1; i <= ind; i++) {
            for (String s : dp[i - 1]) {
                dp[i].add(s + "0");
                dp[i].add(s + "1");
            }
        }
        return dp[ind];
    }
}
