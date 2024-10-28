package Leetcode.Array;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-square-streak-in-an-array/?envType=daily-question&envId=2024-10-28

public class _2501_longest_square_streak {

    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 16, 8, 2};
        System.out.println(longestSquareStreak(arr));
    }

    // TC : O(1e5)
    // SC : O(n)
    public static int longestSquareStreak(int[] nums) {
        Set<Long> set = new HashSet<>();
        for (int a : nums) set.add((long) a);
        int max = -1;
        long t = 1;
        for (int i = 2; i <= 100000; i++) {
            if (!set.contains((long) i)) continue;
            set.remove((long) i);
            int count = 1;
            t = (long) i * i;
            while (t <= 100000 && set.contains((long) t)) {
                count++;
                t *= t;
            }
            if (count > 1 && count > max) max = count;
        }
        return max;
    }

    // TC : O(1e5)
    // SC : O(n)
    public static int longestSquareStreak2(int[] nums) {
        boolean[] arr = new boolean[100001];
        for (int a : nums) {
            arr[a] = true;
        }

        long t = 1;
        int max = -1;
        for (int i = 1; i * i <= 100000; i++) {
            if (!arr[i]) continue;
            int count = 1;
            arr[i] = false;
            t = (long) i * i;
            while (t <= 100000 && arr[(int) t]) {
                arr[(int) t] = false;
                count++;
                t *= t;
            }
            if (count > 1 && count > max) max = count;
        }
        return max;
    }


    // TC : O(n), the while loop runs only for 5 times in the worst case, ex : 2, 4, 16, 256 and there will be no call for more than 100000 so it will be 5 calls in the worst case
    // SC : O(n)
    public static int longestSquareStreak3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int a : nums) set.add(a);

        int max = -1;
        // for each number check how many continue square is present, and take the max of all
        for (int a : nums) {
            int streak = 0;
            long curr = a;
            while (set.contains((int) curr)) {
                streak++;
                if (curr * curr > 1e5) break;
                curr *= curr;
            }
            max = Math.max(max, streak);
        }
        return max;
    }
}
