package Leetcode.Strings;
//https://leetcode.com/problems/string-compression-iii/description/?envType=daily-question&envId=2024-11-04

public class _3163_string_compression_3 {

    // TC : O(n)
    // SC : O(2n or constant) --> if all the characters in the word is unique then the space used will be 2 * 26 = 52, because s only consists lowercase english letters
    public static String compressedString(String word) {
        int n = word.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < n){
            int count = 0;
            int s = i;
            char ch = word.charAt(s);
            // finding consecutive count of each char
            while(i < n && word.charAt(i) == ch){
                count++;
                i++;
            }
            // if the count is greater than 9, dividing it into something like
            // 9a3a for count = 12
            while(count >= 9){
                sb.append(9).append(ch);
                count -= 9;
            }
            // this is for the extra count after 9, ex: 3a
            if(count > 0){
                sb.append(count).append(ch); // this appends the count first then the character
            }
        }
        return sb.toString();
    }
}
