package Lecture_practice_problems_kunal_kushwaha._13_linear_search;

import java.util.Arrays;

public class _02_string_search {
    public static void main(String[] args) {
        String s="subas";
        char target='t';
        System.out.println(search(s,target));
        System.out.println(Arrays.toString(s.toCharArray())); // toCharArray() converts the string into a character array
    }
    static boolean search2(String s,char target) {
        if (s.length() == 0) {
            return false;
        }
        for(char ch:s.toCharArray()){
            if(ch==target){
                return true;
            }
        }
        return false;
    }
    static boolean search(String s,char target){
        if(s.length()==0){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==target){
                return true;
            }
        }
        return false;
    }
}
