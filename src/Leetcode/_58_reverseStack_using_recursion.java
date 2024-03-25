package Leetcode;

import java.util.Stack;
//https://shorturl.at/fotQT
//https://shorturl.at/atzDN

public class _58_reverseStack_using_recursion {
    public static void main(String[] args) {

    }
    public static void reverseStack(Stack<Integer> s) {
        if(s.isEmpty()) return;

        int top = s.pop();
        reverseStack(s);
        insert(top, s);
    }
    public static void insert(int top, Stack<Integer> s){
        if(s.isEmpty()){
            s.push(top);
            return;
        }
        int curr = s.pop();
        insert(top, s);
        s.push(curr);
    }

    public static Stack<Integer> sortStack(Stack<Integer> s) {
        if(s.isEmpty()) return s;

        int top = s.pop();
        sortStack(s);
        insert2(top, s);
        return s;
    }
    public static void insert2(int top, Stack<Integer> s){
        if(s.isEmpty() || s.peek() <= top){
            s.push(top);
            return;
        }
        int curr = s.pop();
        insert(top, s);
        s.push(curr);
    }
}
