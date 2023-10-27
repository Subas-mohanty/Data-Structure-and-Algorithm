package Lecture_practice_problems._46_Stack_and_Queues;

import java.util.*;

public class _01_Stack_Implementation {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(12);
        stack.push(67);
        stack.push(83);
        stack.push(10);
        stack.push(25);
        stack.add(45); // append the element in last index
        stack.add(1,0); // indexing starting from 0
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

        Queue<Integer> queue =new LinkedList<>(); // LinkedList implements Deque and Deque extends Queue so LinkedList object can be used in Queue interface reference
        queue.add(34);
        queue.add(3);
        queue.add(21);
        queue.add(45);
        queue.add(78);
        System.out.println(queue.peek()); // this only show the first inserted element
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        Deque<Integer> deque=new ArrayDeque<>();
        deque.add(39);
        deque.addLast(45);
        deque.removeFirst();
    }
}
