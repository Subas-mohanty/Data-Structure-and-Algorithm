package Leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/merge-intervals/?envType=problem-list-v2&envId=array

public class _56_merge_intervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> a[0] - b[0]); // sorting based on arrival/ start time

        List<int[]> merged = new ArrayList<>();
        int [] prev = intervals[0];
        merged.add(prev); // adding the first interval in the merge list, as it doesn't overlap with anyone else

        for(int [] arr : intervals){
            int prevEnd = prev[1];
            int start = arr[0];
            int end = arr[1];
            // overlap
            // if overlap found just change the end to max of prevEnd or currEnd
            if(start <= prevEnd){
                prev[1] = Math.max(prevEnd, end);
            }
            // no overlap
            else{
                prev = arr; // updating prev to arr
                merged.add(arr); // no overlap so add to the merged list
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
