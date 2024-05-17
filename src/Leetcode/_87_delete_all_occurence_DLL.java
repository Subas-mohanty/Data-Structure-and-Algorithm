package Leetcode;
//https://shorturl.at/qcsRm
public class _87_delete_all_occurence_DLL {
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

    static Node deleteAllOccurOfX(Node head, int x) {
        // checking if initial nodes are x node or not, if yes moving the head to the node which is different from target node
        while(head.data == x) head = head.next;

        Node temp = head;
        Node prev = null;
        while(temp != null){
            if(temp.data == x){
                if(prev != null) prev.next = temp.next;
                if(temp.next != null) temp.next.prev = prev;
            }
            else prev = temp;
            temp = temp.next;
        }
        return head;
    }
}
