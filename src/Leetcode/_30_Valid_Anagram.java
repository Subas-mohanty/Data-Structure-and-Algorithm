package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
//https://leetcode.com/problems/valid-anagram/
//DSA-01: 29-12-2023
public class _30_Valid_Anagram {
    public static void main(String[] args) {
        String s = "ccac";
        String t = "aacc";
        System.out.println(isAnagram2(s,t));
        int[] count = new int[26];

        for (int i=0; i<s.length(); i++){
            count[s.charAt(i) - 'a'] += 1;
        }
        System.out.println('c' - 'a');
        System.out.println(Arrays.toString(count));
    }
//    TC: O(N);
//    SC: O(1), we are using array of size 26 but, it will never exceed 26(no. of alphabates) so it will be constant, no matter what the size of string is
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        int[] count = new int[26];

        for (int i=0; i<s.length(); i++){
            count[s.charAt(i) - 'a'] += 1;
        }

        for (int i=0; i<t.length(); i++){
            if (count[t.charAt(i) - 'a'] == 0) {
                return false;
            }

            count[t.charAt(i) - 'a'] -= 1;

        }

        return true;
    }
//    TC: O(N);
//    SC: O(1), we are using hashmap but the size of the hashmap will never exceed 26(no. of alphabates) so it will be constant no matter what the size of string is
    public static boolean isAnagram2(String s, String t) {

        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                int value = map.get(c) + 1;
                map.put(c, value);
            }
            else{
                map.put(c, 1);
            }
        }
        // check whether all the elements of t are present in the set or not
        for(int i=0; i<s.length(); i++){
            char c=t.charAt(i);
            if(!map.containsKey(c) || map.get(c)==0){
                return false;
            }
            map.put(c, map.get(c)-1);
        }
        return true;
    }
}
