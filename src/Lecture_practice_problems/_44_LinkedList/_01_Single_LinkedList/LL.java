package Lecture_practice_problems._44_LinkedList._01_Single_LinkedList;

public class LL {
     private Node head;
     private Node tail;
     private int size;
     public LL(){
      this.size=0;
     }



    public boolean hasCycle(Node head) {

        // we take two pointer fast and slow , one moves by one step ahead at a time and another moves by two step at a time so if there is a cycle present in the linked list then the fast and the slow pointer will meet somewhere and not they will point to null at the end
        Node fast=head;
        Node slow=head;

        // fast.next can't be null cause if it is null then we can't check for fast.next.next so we need this check and for slow there is no need to check cause if fast is at null then surely there is no cycle present and we know that fast will reach null before slow
        while(fast!= null && fast.next!= null){
            slow=slow.next;
            fast=fast.next.next; // this is null in case there is only two elements are present and no cycle is present
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
     public Node removeDuplicates(Node node){
         while(node!=null){
             if (node.value == node.next.value) {
                 node.next=node.next.next;
             }
             else{
                 node=node.next;
             }
         }
         return node;
     }
     public void insertFirst(int value){
      Node node=new Node(value);
      node.next=head;
      head=node;

      if(tail==null){
       tail=head;
      }
      size+=1;
     }

     public void insertLast(int value){
         if (tail == null) {
             insertFirst(value);
             return;
         }
         Node node=new Node(value);
         tail.next=node;
         tail=node;
         size++;
     }

     public void insert(int value,int index){
         if (index == 0) {
             insertFirst(value);
             return;
         }
         if (index == size) {
             insertLast(value);
             return;
         }
        Node temp=head;
         for (int i = 1; i < index; i++) {
            temp=temp.next;
         }
         Node node=new Node(value,temp.next);
         temp.next=node;
         size++;
     }
     public void insertRec(int value,int index){
         head=insertRec(value,index-1,head);
     }
     private Node insertRec(int value,int index,Node node){
         if(node==null){
             return node;
         }
         if(index==0) {
             Node temp = new Node(value,node.next);
             node.next=temp;
             size++;
             return node;
         }

         node.next=insertRec(value,index-1,node.next);
         return node;
     }
    public int deleteFirst(){
         Node temp=head;
         head=head.next; // Have to assign head to it's next
        if (head == null) {
            tail = null;
        }
        size--;
        return temp.value;
    }
    public int deleteLast(){
        if (size<=1) {
            deleteFirst();
        }
        Node temp=head;
        for (int i = 0; i < size-2; i++) {
            temp=temp.next;
        }
        int value= tail.value;
        tail=temp;
        temp.next=null;
        size--;

        return value;
    }

    public int delete(int index){
        if (index == 0) {
            deleteFirst();
        }
        if (index == size - 1) {
            deleteLast();
        }
        // Store head in a temporary variable, so that the main head doesn't change
        Node previous = head;
        // Traverse through the linked list and reached at the previous element of the given index
        for (int i = 0; i < index-1; i++) {
            previous=previous.next;
        }
        int value=previous.next.value; // This value is deleted
        previous.next=previous.next.next; // setting the next of previous to the next of it's next node
        size--;
        return value;
    }
    // To print the linked list
     public void display(){
      Node temp=head;
      while(temp!=null){
       System.out.print(temp.value+"->");
       temp=temp.next;
      }
      System.out.println("End");
     }

     // This class is for every nodes
     private class Node{
          private int value;
          private Node next;

          public Node(int value){
           this.value=value;
          }

          public Node(int value,Node next){
           this.value=value;
           this.next=next;
          }
     }
}
