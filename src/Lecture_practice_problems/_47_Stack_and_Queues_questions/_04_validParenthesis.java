package Lecture_practice_problems._47_Stack_and_Queues_questions;

import java.util.Stack;

public class _04_validParenthesis {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        boolean ans= stack.isEmpty() || stack.pop() == 6; // stack.pop in an empty stack will give an exception
        System.out.println(ans); // true because when the first statement is true and the next statement is either false or an exception(in this case, stack.pop() ), it will return true
    }


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
               if(ch == ')'){
                   if(stack.isEmpty() || stack.pop() != '('){
                       return false;
                   }
               }
               if(ch == '}'){
                   if(stack.isEmpty() || stack.pop() != '{'){
                       return false;
                   }
               }
               if(ch == ']'){
                   if(stack.isEmpty() || stack.pop() != '['){
                       return false;
                   }
               }
            }
        }
        // at the end if the stack is empty, it means all the brackets have closings else some has still there in the stack that doesn't have a closing bracket
        return stack.isEmpty();
    }
}
