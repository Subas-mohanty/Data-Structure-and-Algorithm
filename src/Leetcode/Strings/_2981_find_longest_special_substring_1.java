package Leetcode.Strings;
import java.util.Map;
import java.util.HashMap;
//https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/?envType=daily-question&envId=2024-12-10

// watch this video for the most optimal solution explanation
//https://www.youtube.com/watch?v=fDUPCtPqzss

public class _2981_find_longest_special_substring_1 {
    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(maximumLength3(s));
    }

    // TC : O(N^3)
    // SC : O(1)
    public int maximumLength2(String s) {
        Map<String, Integer> map = new HashMap<>();
        int n = s.length();
        for(int i =0; i < n; i++){
            for(int j = i; j < n; j++){
                String str = s.substring(i, j+1);
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
        int ans = -1;
        for(String str : map.keySet()){
            if(map.get(str) >= 3 && isCharSame(str)) ans = Math.max(ans, str.length());
        }
        return ans;
    }
    // check if all the characters in s is same or not
    boolean isCharSame(String s){
        char ch = s.charAt(0);
        for(char c : s.toCharArray()){
            if(ch != c) return false;
        }
        return true;
    }


    // TC : O(N^2)
    // SC : O(1)
    public int maximumLength(String s) {
        Map<String, Integer> map = new HashMap<>();
        int n = s.length();
        for(int i =0; i < n; i++){
            // making only special substrings
            StringBuilder sb = new StringBuilder();
            for(int j = i; j < n; j++){
                // create substring until we get same characters
                if(sb.isEmpty() || sb.charAt(sb.length() - 1) == s.charAt(j)){
                    sb.append(s.charAt(j));
                    map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                }
                else break;
            }
        }

        // find the special substring which occur thrice and find its length
        int ans = -1;
        for(String str : map.keySet()){
            if(map.get(str) >= 3) ans = Math.max(ans, str.length());
        }
        return ans;
    }

    // most optimal solution
    // creating a 2D array to store each characters frequency
    // TC : O(n)
    // SC : O(26 * n)
    public static int maximumLength3(String s) {
        int n = s.length();
        int [][] arr = new int[26][n+1];

        arr[s.charAt(0) - 'a'][1] = 1;

        int len = 1;
        for(int i = 1; i < n; i++){
            char ch = s.charAt(i);
            if(ch == s.charAt(i-1)){
                len++;
                arr[ch - 'a'][len]++;
            }

            else{
                len = 1;
                arr[ch - 'a'][len]++;
            }
        }

        // find cumulutive sum of the 2d arr
        for(int i = 0; i < 26; i++){
            for(int j = n-1; j >= 0; j--){
                arr[i][j] += arr[i][j+1];
            }
        }

        // find answer
        int ans = -1;
        for(int i = 0; i < 26; i++){ // character
            for(int j = 1; j <= n; j++){ // length of special substring
                if(arr[i][j] >= 3) ans = Math.max(ans, j);
            }
        }
        return ans;
    }
}
