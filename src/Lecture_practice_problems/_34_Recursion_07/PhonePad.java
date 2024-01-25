package Lecture_practice_problems._34_Recursion_07;

import java.util.ArrayList;
import java.util.HashMap;
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
public class PhonePad {
    public static void main(String[] args) {
        String digits="";
        ArrayList<String> ans = letterCombinations(digits);
        System.out.println(ans);
    }

    static ArrayList<String> letterCombinations(String digits) {
        // created a map to store the letters associated with the numbers
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return helper(0,"",digits,new ArrayList<>(), map);
    }

    private static ArrayList<String> helper(int i, String ans, String digits, ArrayList<String> list, HashMap<Character, String> map) {
        if(digits.length() == 0){
            return list;
        }
        if(i == digits.length()){
            list.add(ans);
            return list;
        }
        String data = map.get(digits.charAt(i));
        for (int j = 0; j < data.length(); j++) {
            ans+=data.charAt(j);
            helper(i+1, ans, digits, list, map);
            // backtrack
            ans=ans.substring(0,ans.length()-1);
        }
        return list;
    }
}
