package Leetcode.Strings;

//https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/description/

public class _3304_find_kth_char_in_string_game {
    public static char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        while(sb.length() < k){
            StringBuilder str = new StringBuilder();
            int size = sb.length();
            for(int i = 0; i < size; i++){
                int ch =  sb.charAt(i) + 1; // ascii value of next char
                char chc = (char) ch; // next char
                str.append(chc); // adding to str
            }
            // after creating the new string which has next char of all the characters in sb, adding it in sb
            sb.append(str);
        }
        return sb.charAt(k-1);
    }
}