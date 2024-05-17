package Leetcode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
//https://shorturl.at/JYnLd
public class _88_find_pairs_with_given_sum_DLL {
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

    // TC : O(n)
    // SC : O(n) for the ans list, which we can't ignore
    public static ArrayList<ArrayList<Integer>> helper(int target, Node head){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Node start = head,  end = head;
        while(end.next != null) end = end.next;

        while(start != end && end.next != start){
            int sum = start.data + end.data;
            if(sum == target){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(start.data);
                list.add(end.data);
                ans.add(list);
                start = start.next;
                end = end.prev;
            }
            else if(sum > target) end = end.prev;
            else start = start.next;
        }
        return ans;
    }

    // TC : O(n log n) --> for sorting
    // SC : O(n) --> for hashmap
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Node temp = head;
        while(temp != null){
            if(map.containsKey(target-temp.data)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(target - temp.data);
                list.add(temp.data);
                ans.add(new ArrayList<>(list));
            }
            map.put(temp.data, target-temp.data);
            temp = temp.next;
        }

        // Sorting the pairs
        Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> pair1, ArrayList<Integer> pair2) {
                return pair1.get(0) - pair2.get(0);
            }
        });

        return ans;
    }
}
