package Lecture_practice_problems_kunal_kushwaha._45_LinkedList;
import Lecture_practice_problems_kunal_kushwaha._45_LinkedList.LL.Node;

public class _01_LinkedList {
    public static void main(String[] args) {
        LL list=new LL();
//        list.insertFirst(12);
//        list.insertFirst(52);
//        list.insertFirst(23);
//        list.insertFirst(54);
//        list.display();
//        list.insertRec(11,2);
//        list.display();
//        list.insertRec(89,2);
//        list.insertLast(1);
//        list.insertLast(1);
//        list.insertLast(1);
//        list.insertLast(2);
//        list.insertLast(2);
//        list.insertLast(4);
//        list.insertLast(4);
//        list.display();
//        list.duplicate();
//        list.display();
//        list.insertLast(1);
//        list.insertLast(2);
//        list.hasCycle();
        list.insertLast(7);
        list.insertLast(7);
        list.insertLast(7);
        list.insertLast(7);
        Node head=list.getHead();
        removeElements(head,6);
        list.display();

    }
    public static Node removeElements(Node head, int val) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev=null;
        Node present=head;
        Node next=present.next;

        // we have to reach till the previous node of the given value
        while(present!=null){
            while (present!=null && present.value !=val){
                prev=present;
                present=next;
                if (next != null) {
                    next=next.next;
                }
            }
            // now present is at the value and prev is at previous of
            if (prev != null && present !=null) {
                prev.next=present.next;
            }
            present=next;
        }
        return head;
    }
}
