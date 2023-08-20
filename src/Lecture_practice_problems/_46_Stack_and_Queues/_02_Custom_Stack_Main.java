package Lecture_practice_problems._46_Stack_and_Queues;

public class _02_Custom_Stack_Main {
    public static void main(String[] args) throws Exception {
        Custom_Stack stack=new Dynamic_Stack(4);
        stack.push(23);
        stack.push(25);
        stack.push(3);
        stack.push(78);
        stack.push(65);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
