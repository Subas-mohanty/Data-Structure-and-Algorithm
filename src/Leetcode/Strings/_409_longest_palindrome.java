package Leetcode.Strings;

//https://leetcode.com/problems/longest-palindrome/description/?envType=daily-question&envId=2024-06-04
public class _409_longest_palindrome {
    public int longestPalindrome(String s) {
        int n = s.length();

        int [] arr = new int[58];
        for(int i = 0; i < n ; i++){
            int ind = s.charAt(i) - 'A';
            arr[ind]++;
        }
        int ans = 0;
        boolean flag = false;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 == 0) ans += arr[i];
            else {
                ans += arr[i] - 1;
                flag = true;
            }
        }
        return flag ? ans +1 : ans;
    }
}
