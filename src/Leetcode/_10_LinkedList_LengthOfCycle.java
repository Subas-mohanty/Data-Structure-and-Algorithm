package Leetcode;

import Lecture_practice_problems._45_LinkedList.LL;

public class _10_LinkedList_LengthOfCycle {
    public int lengthOfCycle(LL.Node head){
        LL.Node fast=head;
        LL.Node slow=head;

        // fast.next can't be null cause if it is null then we can't check for fast.next.next so we need this check and for slow there is no need to check cause if fast is at null then surely there is no cycle present and we know that fast will reach null before slow
        while(fast!= null && fast.next!= null){
            slow=slow.next;
            fast=fast.next.next; // this is null in case there is only two elements are present and no cycle is present
            if(slow==fast){
                int length=0;
                LL.Node temp=slow;
                do{
                    temp=temp.next;
                    length++;
                }while(temp!=slow);
                return length;
            }
        }
        return -1;
    }
}
