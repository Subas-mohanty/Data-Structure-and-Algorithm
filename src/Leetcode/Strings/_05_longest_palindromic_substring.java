package Leetcode.Strings;

//https://leetcode.com/problems/longest-palindromic-substring/description/
// youtube explanation
//https://youtu.be/vTlVtLvPQo4?si=Qw3et3QM5Gmu3_Vl
public class _05_longest_palindromic_substring {

    public static void main(String[] args) {
        String s = "aacabdkacaa";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
        return helper(s);
    }
    public static String helper(String s){
        int l1 = s.length();
        String ans = "";

        // at each character we will check if moving n characters to left and right and check if that string is palindrome or not
        // for odd number of substring
        for(int mid = 0; mid < l1; mid++) {
            int orb = 1;
            int len = 1;
            while(mid - orb >= 0 && mid+orb < s.length()){
                if(s.charAt(mid-orb) == s.charAt(mid+orb)){
                    orb++;
                    len += 2;
                }
                else break;
            }
            if(len > ans.length()){
                int left = mid - len/2;
                ans = s.substring(left, mid+left+1);
            }
        }
        // testing even length palindrome
        for(int mid =0; mid < l1; mid++){
            int orb = 1;
            int len = 0;
            while( mid-orb+1 >= 0 && mid+orb < l1){
                if(s.charAt(mid-orb +1) == s.charAt(mid + orb)){
                    orb++;
                    len += 2;
                }
                else break;
            }
            if(len > ans.length()){
                int startInd = mid - len/2 + 1;
                ans = s.substring(startInd, startInd+len);
            }
        }
        return ans;
    }
}
