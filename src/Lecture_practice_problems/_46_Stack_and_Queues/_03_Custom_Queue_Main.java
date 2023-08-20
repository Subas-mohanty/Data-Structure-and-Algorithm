package Lecture_practice_problems._46_Stack_and_Queues;

import java.util.SortedMap;

public class _03_Custom_Queue_Main {
    public static void main(String[] args) throws Exception {
        Custom_Queue queue = new Custom_Queue(5);
        queue.insert(34);
        queue.insert(23);
        queue.insert(1);
        queue.insert(87);
        queue.insert(65);
        queue.display();
        System.out.println(queue.remove());
        queue.display();
    }
}
