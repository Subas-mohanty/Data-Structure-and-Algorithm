package Leetcode.Strings;
//https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/?envType=daily-question&envId=2024-12-04
public class _2825_make_string_a_subsequence_using_cycle_increments {
    // TC : O(N)
    // SC : O(1)
    public boolean canMakeSubsequence(String str1, String str2) {
        int one = str1.length();
        int two = str2.length();

        int i = 0;
        int j = 0;
        while(i < one && j < two){
            // finding the next character
            char ch = str1.charAt(i) == 'z' ? 'a' : (char)(str1.charAt(i) + 1);
            // if the characters are equal or if by incrementing charAt(i) we get charAt(j), then move forward(both)
            // else only move i, str1's pointer
            if(str1.charAt(i) == str2.charAt(j) ||  ch == str2.charAt(j)) {
                j++;
                i++;
            }
            else i++;
        }
        if(j == two) return true;
        return false;
    }
}
