package Lecture_practice_problems_kunal_kushwaha._44_LinkedList._03_Circular_LinkedList;

public class CLL {
    Node head;
    Node tail;
    CLL() {
        this.head = null;
        this.tail = null;
    }
    void insertLast(int value){
        Node temp=new Node(value);
        if(head==null){
            head=temp;
            tail=temp;
            return;
        }
        tail.next=temp;
        temp.next=head;
        tail=temp;
    }
    void delete(int value){
        Node node=head;
        if (node == null) {
            return;
        }
        if (node.value == value) {
            tail.next=head.next;
            head=tail.next;
        }
        Node nodeToBeDeleted=node.next;
        do {
            if (nodeToBeDeleted.value == value) {
                node.next=nodeToBeDeleted.next;
                break;
            }
            node=node.next;
        } while(node!=head);
    }
    void display(){
        Node temp=head;
        if (head != null) {
            do{
                System.out.print(temp.value+"->");
                temp=temp.next;
            } while(temp!=head);
        }
        System.out.println("HEAD");
    }
    class Node{
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
