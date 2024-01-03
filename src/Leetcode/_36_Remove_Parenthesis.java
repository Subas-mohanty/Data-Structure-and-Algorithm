package Leetcode;
//https://leetcode.com/problems/remove-outermost-parentheses/
public class _36_Remove_Parenthesis {
    public String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder ans = new StringBuilder();

        for(char c : s.toCharArray()){
            // our task is to add all the parenthesis except the outer ones so we will ignore the first opening parenthesis and its closing one . anything else , we will add it in our results
            // when for the first time we get "(" , we will ignore it as it is the outer parenthesis, but when we find it later in the string we add it to the ans
            if(c == '(') {
                if(count != 0){
                    ans.append(c);
                }
                count++;
            }
            // same when we get ")" , when there is already a "(" exists , this means it is also the outer parenthesis so we will ignore
            else {
                if(count != 1){
                    ans.append(c);
                }
                count--;
            }
        }
        return ans.toString();
    }
}
