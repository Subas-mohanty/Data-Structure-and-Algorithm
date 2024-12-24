package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/palindrome-partitioning/description/
public class _131_palindrome_partitioning {
    // TC : (n * 2^n)
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        int i = 0, n = s.length();
        read(i, n, s, list, ans);
        return ans;
    }

    private void read(int i, int n, String s, List<String> list, List<List<String>> ans) {
        if (i == n) ans.add(new ArrayList<>(list));
        else {
            // we can make a partition anywhere, so we are doing that and checking if, after the partition, the substring is palindrome or not , if yes adding it to list and then backtracking, and checking for the remaining string
            for(int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);
                if (isPalin(sub)) {
                    list.add(sub);
                    read(j + 1, n, s, list, ans);
                    list.remove(list.size() - 1); // backtrack
                }
            }
        }
    }

    private boolean isPalin(String sub) {
        int n = sub.length();
        for(int i = 0; i < n/2; i++){
            if(sub.charAt(i) != sub.charAt(n-1-i)) return false;
        }
        return true;
    }
}
