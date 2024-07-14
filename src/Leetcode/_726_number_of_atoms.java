package Leetcode;

import java.util.HashMap;
import java.util.Stack;
import java.util.TreeMap;
//https://leetcode.com/problems/number-of-atoms/?envType=daily-question&envId=2024-07-14
// youtube explanation
//https://www.youtube.com/watch?v=vg0ym41i-EM


// Explanation :
/*
    The question is not so hard if we understand the logic. What we are doing in this problem is, for every set of parenthesis we are creating a hashmap to store the frequency of all the atoms inside that scope only,
    so, if we get '(' , we are simply adding a new empty hashmap to the stack
    when we get ')' , we are checking is there any number after that, if yes than multiply that number with all the elements in that map ( ex- (OH)2 --> O2H2
    and after doing this we are putting it back to the top element in the stack for further calculation

    same thing we are doing for name also, finding the name, until we are not getting a digit or a uppercase letter,
    after that checking if the name has a number after it or not, we are calculating its count, then putting it in the map, which is in the top of the stack
 */
public class _726_number_of_atoms {

    public String countOfAtoms(String formula) {
        Stack<HashMap<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        int n = formula.length();
        int index = 0;

        while(index < n){
            char ch = formula.charAt(index);
            if(ch == '('){
                stack.push(new HashMap<>());
                index++;
            }
            else if(ch == ')'){
                HashMap<String, Integer> currMap = stack.pop();
                StringBuilder multiplier = new StringBuilder();
                index++; // move to the next character

                // find the multiplier --> ()n
                while(index < n && Character.isDigit(formula.charAt(index))){
                    multiplier.append(formula.charAt(index));
                    index++;
                }

                // multiply the count
                if(multiplier.length()> 0){
                    int m = Integer.parseInt(multiplier.toString());
                    for(String atom : currMap.keySet()){
                        currMap.put(atom, currMap.get(atom) * m);
                    }
                    // insert popped map elements to the stack top
                    for(String atom : currMap.keySet()){
                        stack.peek().put(atom, stack.peek().getOrDefault(atom, 0) + currMap.get(atom));
                    }
                }
            }
            else{ // Atom name and count
                StringBuilder atomName = new StringBuilder();
                atomName.append(ch);
                index++;
                while(index < n && Character.isLowerCase(formula.charAt(index))){
                    atomName.append(formula.charAt(index));
                    index++;
                }

                // find the number after an element, ex Mg22, to find this 22
                StringBuilder count = new StringBuilder();
                while(index < n && Character.isDigit(formula.charAt(index))){
                    count.append(formula.charAt(index));
                    index++;
                }
                // if nothing is present then the count is 1 by default
                int c = (count.length() > 0) ? Integer.parseInt(count.toString()) : 1;
                stack.peek().put(atomName.toString(), stack.peek().getOrDefault(atomName.toString(), 0) + c);
            }
        }

        // using treemap to store the name in sorted order
        TreeMap<String, Integer> sortedMap = new TreeMap<>(stack.peek());
        StringBuilder ans = new StringBuilder();
        for(String atom : sortedMap.keySet()){
            ans.append(atom);
            if(sortedMap.get(atom) > 1) ans.append(sortedMap.get(atom));
        }
        return ans.toString();
    }
}
