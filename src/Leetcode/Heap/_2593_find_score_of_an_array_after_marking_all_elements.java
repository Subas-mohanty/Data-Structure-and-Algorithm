package Leetcode.Heap;
import java.util.*;
//https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/description/?envType=daily-question&envId=2024-12-13

public class _2593_find_score_of_an_array_after_marking_all_elements {
       public static void main(String[] args) {
        int [] arr = {2,5,6,6,10};
        System.out.println(findScore(arr));
    }
    // TC : O(n + n log n + n log n)
    // SC : O(n)
    public static long findScore(int[] nums) {
        int n = nums.length;
        Queue<int[]> q = new PriorityQueue<>((a, b) -> {
            if(a[1] == b[1]) return a[0] - b[0]; // if element are same, sort them by their index, smallest index comes first
            return a[1] - b[1]; // based on value, smaller value comes first
        });
        for (int i = 0; i < n; i++) {
            q.offer(new int[]{i, nums[i]});
        }
        boolean [] visit = new boolean[n];

        long score = 0;
        while(!q.isEmpty()){
            int [] removed = q.poll();
            int index = removed[0];
            int ele = removed[1];
            // if this index has already been taken then don't take it any more
            if(visit[index]) continue;
            score += ele;
            // getting the prev and next index to mark them as visited
            int first = index - 1;
            int second = index + 1;
            // marking prev and next index as visited
            if(first >= 0) visit[first] = true;
            if(second < n) visit[second] = true;
        }
        return score;
    }
}
