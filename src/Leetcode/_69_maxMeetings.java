package Leetcode;
import java.util.Arrays;
public class _69_maxMeetings {
    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};
        int n = end.length;
        System.out.println(maxMeetings(start, end, n));
    }

    // Creating a class of datatype to store both start and end time
    static class Pair implements Comparable<Pair> {  // implement comparable
        int st;
        int end;
        public Pair(int st, int end) {
            this.st = st;
            this.end = end;
        }

        //Override CompareTo function by sorting according to end time;
        public int compareTo(Pair x) {
            return this.end - x.end;
        }
    }

    public static int maxMeetings(int[] start, int[] end, int n) {

        // create object of new pair Class data type
        Pair[] p = new Pair[n];

        for (int i = 0; i < n; i++) {
            p[i] = new Pair(start[i], end[i]);
        }
        Arrays.sort(p); //   sorting by end-time
        int count = 1;
        Pair curr = p[0];

        for (int i = 1; i < n; i++) {
            // Compare value with previous end-time to count valid meetings
            if (curr.end < p[i].st) {
                count++;
                curr = p[i];
            }
        }
        return count;
    }
}
