package Lecture_practice_problems_kunal_kushwaha._47_Stack_and_Queues_questions;

import java.util.Stack;

public class _05_validParenthesis_MinAdd {

    public int dj(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.size();
    }
}
