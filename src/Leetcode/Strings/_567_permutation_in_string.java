package Leetcode.Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/permutation-in-string/description/

public class _567_permutation_in_string {
    // brute force
    // TC : O( n + n * n!)
    // SC : O(n!) , number of permutation of a string having length n
    public boolean checkInclusion(String s1, String s2) {
        Set<String> set = new HashSet<>();
        helper("", s1, set);

        for(String s : set){
            if(s2.contains(s)) return true;
        }
        return false;
    }
    void helper(String s, String p, Set<String> set){
        if(p.length() == 0){
            set.add(s);
            return;
        }
        char ch=p.charAt(0);
        for (int i = 0; i <= s.length(); i++) {
            String first=s.substring(0,i);
            String second=s.substring(i,s.length());
            helper(first+ch+second,p.substring(1), set);
        }
    }


    // better approach
    // TC : O(n + (m-n) * n + n)
    // SC : O( 26) * 2
    public boolean checkInclusion2(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // taking the frequency of each character in the first string then finding all substring of s2 and checking if the frequency is same or not
        int [] arr = new int[26];
        for(char ch : s1.toCharArray()){
            arr[ch - 'a']++;
        }
        for(int i = 0; i <= m - n; i++){
            int [] fre = new int[26];
            for(int j = 0; j < n; j++){ // taking n size substring every time
                fre[s2.charAt(i+j) - 'a']++;
            }
            if(Arrays.equals(arr, fre)) return true;
        }
        return false;
    }


    // optimal approach
    // TC : O( n + (m-n) + n)
    // SC : O(26) * 2
    public boolean checkInclusion3(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(m < n) return false;

        int [] arr = new int[26];
        int [] fre = new int[26];

        for(int i = 0; i < n; i++){
            arr[s1.charAt(i) - 'a']++;
            fre[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(arr, fre)) return true;
        // using sliding window to find substring of length n
        for(int i = 1; i <= m - n; i++){
            fre[s2.charAt(i+n-1) - 'a']++; // addition of next character
            fre[s2.charAt(i-1) - 'a']--; // deletion of first character

            if(Arrays.equals(arr, fre)) return true;
        }
        return false;
    }
}
