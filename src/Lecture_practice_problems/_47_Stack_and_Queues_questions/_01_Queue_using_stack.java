package Lecture_practice_problems._47_Stack_and_Queues_questions;

import java.util.Stack;

//https://leetcode.com/problems/implement-queue-using-stacks/

// this is insert efficient, which means it takes O(1) for insert and O(N) for removal
public class _01_Queue_using_stack {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public _01_Queue_using_stack() {
        first=new Stack<>();
        second=new Stack<>();
    }

    public void add(int element) {
        first.push(element);
    }
    public int remove() throws Exception{

        // // emptying first stack to second stack
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        int removed=second.pop();

        // emptying second stack to first stack
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return removed;
    }
    public int peek() throws Exception{
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        int peeked=second.peek();
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return peeked;
    }
    public boolean isEmpty(){
        return first.isEmpty();
    }
}
