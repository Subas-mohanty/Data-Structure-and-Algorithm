package Leetcode.Strings;

//https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/description/?envType=daily-question&envId=2024-06-03
public class _2486_appendCharacters {
    public int appendCharacters(String s, String t) {
        int one = 0;
        int two = 0;
        int lenS = s.length();
        int lenT = t.length();

        while(one < lenS && two < lenT){
            if(s.charAt(one) != t.charAt(two)){
                one++;
            }
            else{
                one++;
                two++;
            }
        }
//        return lenT - two < 0 ? 0 : lenT - two;
        return Math.max(lenT - two, 0);
    }
}
