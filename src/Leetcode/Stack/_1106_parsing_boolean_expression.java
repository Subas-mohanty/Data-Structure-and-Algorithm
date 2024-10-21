package Leetcode.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/parsing-a-boolean-expression/description/?envType=daily-question&envId=2024-10-20

public class _1106_parsing_boolean_expression {

    public static void main(String[] args) {
        String exp = "&(|(f))";
        System.out.println(parseBoolExpr(exp));
    }

    // TC : O(n + k)
    // SC : 2*n --> n for stack and n for list(overall)

    public static boolean parseBoolExpr(String exp) {
        Stack<Character> stack = new Stack<>();

        // traversing each character and adding in the stack, if closing bracket found then evaluate the statement inside that
        for (char ch : exp.toCharArray()) {
            if (ch == ',') continue;
            if (ch == ')') {
                List<Character> list = new ArrayList<>();
                // storing all the values inside the parenthesis in a list, for AND and OR, the order doesn't matter so not reversing it
                while (!stack.isEmpty() && stack.peek() != '(') list.add(stack.pop());
                stack.pop(); // (, remove the opening parenthesis
                char operator = stack.pop(); // get the character, it is guaranteed that an operator will be present before opening parenthesis
                if (operator == '&') {
                    char newCh = parseAnd(list);
                    stack.push(newCh);
                }
                if (operator == '|') {
                    stack.push(parseOr(list));
                }
                if (operator == '!') {
                    stack.push(parseNot(list));
                }
            } else stack.push(ch);
        }

        // get the last and only character present in the stack and return accordingly
        char ch = stack.pop();
        return ch == 'f' ? false : true;
    }

    static char parseAnd(List<Character> list) {
        // for AND, if one false is found than the entire statement is false
        for (char ch : list) {
            if (ch == 'f') return 'f';
        }
        return 't';
    }

    static char parseOr(List<Character> list) {
        // for OR, if one true is found than the entire statement is true
        for (char ch : list) {
            if (ch == 't') return 't';
        }
        return 'f';
    }

    static char parseNot(List<Character> list) {
        char ch = list.get(0); // here only one character will be present and return the NOT of it
        if (ch == 'f') return 't';
        else return 'f';
    }
}
