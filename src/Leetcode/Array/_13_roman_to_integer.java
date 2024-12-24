package Leetcode.Array;

import java.util.HashMap;
//https://leetcode.com/problems/roman-to-integer/submissions/
public class _13_roman_to_integer {
    public static void main(String[] args) {
        String s = "III";
        System.out.println(romanToInt(s));
        System.out.println(romanToInt2(s));
    }
    public static int romanToInt2(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            if(i < s.length()-1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1))) num-= map.get(s.charAt(i));
            else num += map.get(s.charAt(i));
        }
        return num;
    }
    public static int romanToInt(String s) {
        int num = 0;
        int i = 0;
        while(i < s.length()){


            // everytime we get a character we add the corresponding value to the number and when we found that the next character is bigger than current character then we subtract the value from it
            if(s.charAt(i) == 'M') num +=1000;
            else if(s.charAt(i) == 'D') num += 500;
            else if(s.charAt(i) == 'C' && i+1 < s.length() && s.charAt(i+1) == 'M') num -= 100;
            else if(s.charAt(i) == 'C' && i+1 < s.length() && s.charAt(i+1) == 'D') num -= 100;
            else if(s.charAt(i) == 'C') num += 100;
            else if(s.charAt(i) == 'L') num += 50;
            else if(s.charAt(i) == 'X' && i+1 < s.length() && s.charAt(i+1) == 'C') num -= 10;
            else if(s.charAt(i) == 'X' && i+1 < s.length() && s.charAt(i+1) == 'L') num -= 10;
            else if(s.charAt(i) == 'X') num += 10;
            else if(s.charAt(i) == 'V') num += 5;
            else if(s.charAt(i) == 'I' && i+1 < s.length() && s.charAt(i+1) == 'V') num -= 1;
            else if(s.charAt(i) == 'I' && i+1 < s.length() && s.charAt(i+1) == 'X') num -= 1;
            else if(s.charAt(i) == 'I') num += 1;
            i++;
        }
        return num;
    }
}
