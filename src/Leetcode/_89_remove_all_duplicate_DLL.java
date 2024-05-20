package Leetcode;
//https://shorturl.at/BbWer
public class _89_remove_all_duplicate_DLL {
    class Node
    {
        int data;
        Node next;
        Node prev;
        Node(int data)
        {
            this.data = data;
            next = prev = null;
        }
    }

    Node removeDuplicates2(Node head){
        if(head == null) return head;

        Node temp = head;

        while(temp != null && temp.next != null){
            Node runner = temp;
            while(runner != null && temp.data == runner.data){
                runner = runner.next;
            }
            temp.next = runner;
            if(runner != null) runner.prev = temp;
            temp = runner;
        }
        return head;
    }

    Node removeDuplicates(Node head){
        Node temp = head;
        Node prev = null;

        while(temp != null){
            while(temp != null && temp.data == temp.prev.data){
                temp = temp.next;
            }
            if(prev != null) prev.next = temp;
            temp.prev = prev;
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}
