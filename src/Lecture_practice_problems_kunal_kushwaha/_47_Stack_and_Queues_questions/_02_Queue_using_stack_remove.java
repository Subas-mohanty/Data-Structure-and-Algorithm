package Lecture_practice_problems_kunal_kushwaha._47_Stack_and_Queues_questions;

import java.util.Stack;

//https://leetcode.com/problems/implement-queue-using-stacks/

// this is remove efficient, which means it takes O(1) for removal and O(N) for insertion
public class _02_Queue_using_stack_remove {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public _02_Queue_using_stack_remove() {
        first=new Stack<>();
        second=new Stack<>();
    }

    public void add(int element) throws Exception{
        // we don't need this actually, as we are confirming first that the first stack is empty with the while loop and if it's already empty then this while condition will be failed and it will be pushed normally
//        if(first.isEmpty()){
//            first.push(element);
//        }
        // emptying first stack to second stack
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        first.push(element);

        // emptying second stack to first stack
        while(!second.isEmpty()){
            first.push(second.pop());
        }
    }
    public int remove() throws Exception{
        return first.pop();
    }
    public int peek(){
        return first.peek();
    }
    public boolean isEmpty(){
        return first.isEmpty();
    }
}
