package Leetcode.Heap;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description/?envType=daily-question&envId=2024-10-13
// youtube link : https://www.youtube.com/watch?v=M-f16cQInnI

public class _632_smallest_range_covering_ele_from_k_lists {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int [] a, int [] b){
                return a[0] - b[0];
            }
        });

        int max = -(int) 1e9;
        for(int i = 0; i < n; i++){
            int firstEl = nums.get(i).get(0);
            pq.offer(new int[]{firstEl, i, 0});
            max = Math.max(max, firstEl); // maximum among the first element of all the k lists
        }
        int [] range = {0, (int)1e9};
        while (true){
            int [] temp = pq.poll();
            int minEl = temp[0], listInd = temp[1], eleInd = temp[2];
            // if our new range is smaller, then update the range
            if(max - minEl < range[1] - range[0]){
                range[0] = minEl;
                range[1] = max;
            }
            if(eleInd == nums.get(listInd).size() - 1) break; // a list is over so no need to traverse further
            // get the next element from the list, where the curr min was
            int next = nums.get(listInd).get(eleInd + 1);
            max = Math.max(max, next);
            pq.offer(new int[]{next, listInd, eleInd  +1});
        }
        return range;
    }
}
