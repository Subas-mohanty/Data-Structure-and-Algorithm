package Leetcode;

import java.util.Arrays;
//https://leetcode.com/problems/longest-common-prefix/description/
public class _14_longest_common_prefix {
    public static void main(String[] args) {
        String [] arr = {"aaa", "aa", "aaa"};
        System.out.println(longestCommonPrefix(arr));
    }
    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        String ans = "";
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[length-1];

        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if(first.charAt(i) != last.charAt(i)) return ans;
            else ans+= first.charAt(i);
        }
        return ans;
    }
}
