package Lecture_practice_problems._45_LinkedList;

public class LL {
    Node head;
    Node tail;
    private int size;
    public LL(){
        this.size=0;
    }
    public Node getHead(){
        return this.head;
    }

    //    https://leetcode.com/problems/rotate-list/
    //    google,twitter
    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }
        ListNode last=head;
        int length=1;
        while (last.next != null) {
            last=last.next;
            length++;
        }
        last.next=head;
        int rotation=k%length;
        int skip=length-rotation; // the first no of nodes to be skipped to reach the previous of , where the rotation would start

        ListNode newLast=head;
        for (int i = 0; i <skip-1; i++) {
            newLast=newLast.next;
        }
        head=newLast.next;
        newLast.next=null;
        return head;
    }
    //    https://leetcode.com/problems/reorder-list/
    //    Google,Facebook
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // find the middle node then reverse it from there
        ListNode mid=middleNode(head);
        ListNode secondHead=reverseInplace(mid);
        ListNode firstHead=head;

        while (firstHead != null && secondHead != null) {
            ListNode temp=firstHead.next;
            firstHead.next=secondHead;
            firstHead=temp;

            temp=secondHead.next;
            secondHead.next=firstHead;
            secondHead=temp;
        }
        // setting next of tail to null
        if (firstHead != null) {
            firstHead.next=null;
        }
    }
    //    linkedin,google,facebook,microsoft,amazon,apple
    //    https://leetcode.com/problems/palindrome-linked-list/
    public boolean isPalindrome(ListNode head) {
        ListNode mid=middleNode(head);
        ListNode secondHead=reverseInplace(mid);
        ListNode rereverseHead=secondHead;

        // compare both the halves
        while (head != null && secondHead != null) {
            if (head.val != secondHead.val) {
                break; // we don't return from here cause we have to re-reverse the list again
            }
            head=head.next;
            secondHead=secondHead.next;
        }
        reverseInplace(rereverseHead);

        // now we will check whether the loop has ended of terminated by the if statement
        return head == null || secondHead == null;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode prev=null;
        ListNode present=head;

        // skip the first left-1 nodes
        for (int i = 0; present != null && i < left-1; i++) {
            prev=present;
            present=present.next;
        }
        // we store prev,present in temporary nodes to use it later
        ListNode last=prev;
        ListNode newEnd=present;
        ListNode next=present.next;

        // reverse the list n times where n is the number of elements between left and right
        for (int i = 0; present != null && i < right - left +1; i++) {
            present.next=prev;
            prev=present;
            present=next;
            if (next != null) {
                next=next.next;
            }
        }
        // last is the previous element before left so if it is null then the list start from the right element that is now prev otherwise head will be last and it's next will be previous

        //last nEnd      prev present
        // 1 -> 2 -> 3 -> 4 -> 5 -> null
        // the modified list will be
        // 1 -> 4 -> 3 -> 2 -> 5 -> null
        if (last != null) {
            last.next=prev;
        } else{
            head=prev;
        }
        newEnd.next=present;
        return head;
    }

    // inplace reversal of linked list
    public ListNode reverseInplace(ListNode head){
        if (head == null) {
            return head;
        }
        ListNode prev=null;
        ListNode present=head;
        ListNode next=present.next;
        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    // reversal of linked list using recursion
    public void reverse(Node node){
        if(node==tail){
            head=tail;
            return;
        }
        reverse(node.next);
        tail.next=node;
        tail=node;
        tail.next=null;
    }
    public Node sortList(Node head){
        if(head==null && head.next==null){
            return head;
        }
        Node mid=getMid(head);
        Node list1=sortList(head);
        Node list2=sortList(mid);
        return merge(list1,list2);
    }

    private Node merge(Node list1, Node list2) {
        Node dummyHead=new Node();
        Node temp=dummyHead;
        while (list1 != null && list2 != null) {
            if(list1.value<list2.value){
                temp.next=list1;
                temp=temp.next;
                list1=list1.next;
            }
            else{
                temp.next=list2;
                temp=temp.next;
                list2=list2.next;
            }
        }
        temp.next=(list1!=null)?list1:list2;
        return dummyHead.next;
    }

    public Node getMid(Node head){
        Node midPrevious=null;
        while (head != null && head.next != null) {
            midPrevious=(midPrevious==null)?head:midPrevious.next;
            head=head.next.next;
        }
        Node mid=midPrevious.next;
        midPrevious.next=null;
        return mid;
    }
    public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public boolean isHappy(int n){
        int slow=n;
        int fast=n;

        // can't use while loop cause the initial condition will always be true and it will never terminate, cause we have taken fast=slow=n
        do {
            slow=sumSq(n);
            fast=sumSq(sumSq(n));
        }while(slow!=fast);

        if (slow == 1) {
            return true;
        }
        return false;
    }
    static int sumSq(int n){
        int sum=0;
        while (n != 0) {
            int rem=n%10;
            int sq=rem*rem;
            n=n/10;
            sum+=sq;
        }
        return sum;
    }
    public boolean hasCycle() {

        // we take two pointer fast and slow , one moves by one step ahead at a time and another moves by two step at a time so if there is a cycle present in the linked list then the fast and the slow pointer will meet somewhere and not they will point to null at the end
        Node fast=head;
        Node slow=head;

        // fast.next can't be null cause if it is null then we can't check for fast.next.next so we need this check and for slow there is no need to check cause if fast is at null then surely there is no cycle present and we know that fast will reach null before slow
        while(fast!= null && fast.next!= null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        System.out.println(fast); // this is null in case there is only two elements are present and no cycle is present
        return false;
    }
    public int cycleLength(Node node) {

        // we take two pointer fast and slow , one moves by one step ahead at a time and another moves by two step at a time so if there is a cycle present in the linked list then the fast and the slow pointer will meet somewhere and not they will point to null at the end
        Node fast=head;
        Node slow=head;

        // fast.next can't be null cause if it is null then we can't check for fast.next.next so we need this check and for slow there is no need to check cause if fast is at null then surely there is no cycle present and we know that fast will reach null before slow
        while(fast!= null && fast.next!= null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                int length=0;
                Node temp=slow;
                do{
                    temp=temp.next;
                    length++;
                }while(temp!=fast);
            }
        }
        System.out.println(fast); // this is null in case there is only two elements are present and no cycle is present
        return 0;
    }
    public Node detectCycle(Node head) {
        int length=0;
        Node fast=head;
        Node slow=head;

        // fast.next can't be null cause if it is null then we can't check for fast.next.next so we need this check and for slow there is no need to check cause if fast is at null then surely there is no cycle present and we know that fast will reach null before slow
        while(fast!= null && fast.next!= null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
//                length=cycleLength(head);
                length=cycleLength(slow);// this will be a little bit faster as it will not traverse the non-cycle part of the linked list
                break;
            }
        }
        if(length==0){
            return null;
        }
        Node first=head;
        Node second=head;

//        while(length>0){
//            second=second.next;
//            length--;
//        }
        for (int i = 0; i < length; i++) {
            second=second.next;
        }
        // now both will move forward until they meet
        while(first!=second){
            first=first.next;
            second=second.next;
        }
        return second;
    }
    public void duplicate(){
        Node node=head;
//        if (node.next == null){
//
//        }
        while (node.next != null) {
            if(node.value==node.next.value){
                node.next=node.next.next;
                size--;
            }
            else{
                node=node.next;
            }
        }
        tail=node;
        tail.next=null;
//        return node;
    }

    // insert using recursion
    public void insertRec(int value , int index) {
        head=insertRec(value,index,head);
    }
    private Node insertRec(int value,int index,Node node){
        if (index == 0) {
            Node temp=new Node(value);
            temp.next=node; // in the base condition we will be reaching at the same index where we want to insert the element
            size++;
            return temp;
        }
        node.next=insertRec(value,index-1,node.next);
        return node;
    }
    public void insertFirst(int value){
         Node node=new  Node(value);
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
         Node node=new  Node(value);
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
         Node node=new  Node(value,temp.next);
        temp.next=node;
        size++;
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
    public static class Node{
        public int value;
        public Node next;
        public Node(){

        }
        public Node(int value){
            this.value=value;
        }

        public Node(int value,  Node next){
            this.value=value;
            this.next=next;
        }
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
