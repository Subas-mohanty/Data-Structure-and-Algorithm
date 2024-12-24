package Lecture_practice_problems_kunal_kushwaha._46_Stack_and_Queues;

public class _04_Circular_Queue_Main {
    public static void main(String[] args) throws Exception {
        Circular_Queue queue = new Circular_Queue();
        queue.insert(34);
        queue.insert(23);
        queue.insert(1);
        queue.insert(87);
        queue.insert(65);
        queue.display();
        queue.insert(147);
        queue.display();
        System.out.println(queue.remove());
        queue.display();

    }
}
