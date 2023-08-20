package Lecture_practice_problems._44_LinkedList._03_Circular_LinkedList;

public class _01_CLL_Creation {
    public static void main(String[] args) {
        CLL list=new CLL();
        list.insertLast(12);
        list.insertLast(2);
        list.insertLast(82);
        list.insertLast(52);
        list.display();
        list.delete(2);
        list.display();
    }
}
