package Leetcode.Array;

import java.util.Arrays;
//https://leetcode.com/problems/two-best-non-overlapping-events/description/?envType=daily-question&envId=2024-12-08

public class _2054_two_best_non_overlapping_events {
    // TC : O(n + n * logn)
    // SC : O(N)

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]); // sorting based on start time

        int n = events.length;
        // storing the largest value from the curr index to last index
        int [] value = new int[n];
        value[n-1] = events[n-1][2];
        for(int i = n-2; i >= 0; i--){
            value[i] = Math.max(value[i+1], events[i][2]);
        }

        int max = 0;
        for (int[] event : events) {
            max = Math.max(max, event[2]); // consider only one event

            int index = findEvent(events, event[1]);
            int sum = index == -1 ? 0 : event[2] + value[index]; // -1 means no such event is found so current sum = 0
            max = Math.max(sum, max);
        }
        return max;
    }

    // this finds the first non overlapping event's index
    int findEvent(int[][] events, int end) {
        int n = events.length;
        int s = 0;
        int e = n - 1;
        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (events[mid][0] > end) {
                ans = mid;
                e = mid - 1;
            }
            else s = mid + 1;
        }
        return ans;
    }
}
