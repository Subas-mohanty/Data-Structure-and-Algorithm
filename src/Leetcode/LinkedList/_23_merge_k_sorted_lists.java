package Leetcode.LinkedList;

import Leetcode.ListNode;
//https://leetcode.com/problems/merge-k-sorted-lists/
public class _23_merge_k_sorted_lists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;

        ListNode ans = lists[0];
        for(int i = 1; i< lists.length; i++){
            ans = merge(ans, lists[i]);
        }
        return ans;
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
}
