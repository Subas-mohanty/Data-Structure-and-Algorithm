package Leetcode;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/generate-parentheses/description/
public class _60_generate_parenthesis {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(generateParenthesis(n));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper("", n, n, list);
        return list;
    }
    public static void helper(String s, int first, int sec, List<String> list) {
        if(first == 0 && sec == 0){
            list.add(s);
            return;
        }
        if(first > 0) helper(s + "(", first-1, sec, list);

        if(first < sec) helper(s + ")", first, sec-1, list);
    }
}
