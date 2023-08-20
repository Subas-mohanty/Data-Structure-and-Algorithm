package Lecture_practice_problems._44_LinkedList._02_Doubly_LinkedList;

public class DLL {
    Node head;
    int size=0;

    void insertFirst(int value){
        Node node=new Node(value);
        node.next=head;
        node.prev=null;
        if (head != null) {
            head.prev=node;
        }
        head=node;
        size++;
    }
    public void display(){
        Node temp=head;
        for (int i = 0; i < size; i++) {
            System.out.print(temp.value+"->");
            temp=temp.next;
        }
        System.out.println("End");
    }
    public void displayRev(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+"->");
            temp=temp.prev;
        }
        System.out.println("End");
    }
    class Node{
        int value;
        Node next;
        Node prev;

        Node(int value){
            this.value=value;
        }
        Node(int value,Node next,Node prev){
            this.value=value;
            this.next=next;
            this.prev=prev;
        }
    }
}
