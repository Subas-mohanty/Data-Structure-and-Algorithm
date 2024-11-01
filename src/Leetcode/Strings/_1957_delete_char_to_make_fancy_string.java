package Leetcode.Strings;
//https://leetcode.com/problems/delete-characters-to-make-fancy-string/description/?envType=daily-question&envId=2024-11-01

public class _1957_delete_char_to_make_fancy_string {
    // TC : O(n)
    // SC : O(n)
    public String makeFancyString(String s) {
        int n = s.length();
        // if length is already smaller than 3 then there is no 3 consecutive characters present so return the string itself
        if(n < 3) return s;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= n - 3; i++){
            // three consecutive characters are equal so don't take it
            if(s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == s.charAt(i+2)) continue;
            sb.append(s.charAt(i));
        }
        // if last three character are equal we don't take the first one but take the last two, if last three are not same we take first character in the loop and last two here below
        sb.append(s.charAt(n-2));
        sb.append(s.charAt(n-1));
        return sb.toString();
    }
}
