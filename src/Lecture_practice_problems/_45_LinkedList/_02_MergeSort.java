package Lecture_practice_problems._45_LinkedList;
import Lecture_practice_problems._45_LinkedList.LL.ListNode;
public class _02_MergeSort {
    public ListNode sortList(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid=getMid(head);
        ListNode list1=sortList(head);
        ListNode list2=sortList(mid);
        return merge(list1,list2);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead=new ListNode();
        ListNode temp=dummyHead;
        while (list1 != null && list2 != null) {
            if(list1.val<list2.val){
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

    public ListNode getMid(ListNode head){
        ListNode midPrevious=null;
        while (head != null && head.next != null) {
            midPrevious=(midPrevious==null)?head:midPrevious.next;
            head=head.next.next;
        }
        ListNode mid=midPrevious.next;
        midPrevious.next=null;
        return mid;
    }
}
