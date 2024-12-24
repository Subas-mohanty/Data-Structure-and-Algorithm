package Leetcode.Strings;

//https://leetcode.com/problems/rotate-string/submissions/1237895460/

// the intuition to this problem was if we add the string with itself then we can find if the goal string is present in the newly created string or not by using the inbuilt contains() method

public class _796_rotate_string {
    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";
        System.out.println(rotateString(s, goal));
    }
    public static boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        String snew = s + s;
        boolean ans = snew.contains(goal);
        return ans;
    }
}
