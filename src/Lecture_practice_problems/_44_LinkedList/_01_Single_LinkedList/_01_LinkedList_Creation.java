package Lecture_practice_problems._44_LinkedList._01_Single_LinkedList;

public class _01_LinkedList_Creation {
    public static void main(String[] args) {
        LL list=new LL();
        list.insertFirst(12);
        list.insertFirst(65);
        list.insertFirst(67);
        list.insertFirst(1);
        list.insertLast(101);
        list.insert(5,2);
        list.display();
        list.insertRec(2,3);
        list.display();

//        System.out.println(list.deleteFirst());
//        list.display();
//        System.out.println(list.deleteLast());
//        list.display();
//        System.out.println(list.delete(1));
//        list.display();
    }
}
