package Leetcode;

import java.util.HashMap;

public class _84_countSubstrings_with_k_distinct {
    public static void main(String[] args) {
        String s = "abcad";
        int k = 2;
        System.out.println(countSubStrings(s,k));
    }
    public static int countSubStrings(String s, int k) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            // this unique is the number of unique characters, it states that if the current character at j index is already present in the map then is the unique characters is same as k if yes then we found one substring and if the current character is not present then compare the number of unique characters already present + this character which is unique++ with k if yes then found another substring
            int unique = 0;
            for (int j = i; j < s.length(); j++) {
                if(!map.containsKey(s.charAt(j))) unique++;
                if(unique == k) count++;

                int temp = map.getOrDefault(s.charAt(j),0);
                map.put(s.charAt(j), temp +1);
            }
        }
        return count;
    }
}
