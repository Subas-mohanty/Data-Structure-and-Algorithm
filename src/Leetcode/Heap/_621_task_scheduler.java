package Leetcode.Heap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

// https://leetcode.com/problems/task-scheduler/description/

public class _621_task_scheduler {

    // TC : O(n + n + n log n)
    // SC : O(n) --> both pq and q together will store n elements at a time in the worst case

    public int leastInterval(char[] tasks, int n) {
        int [] map = new int[26];
        for(char ch : tasks) map[ch - 'A']++; // frequency of all the characters

        // max-heap
        PriorityQueue<int[] > pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Queue<int[]> q = new LinkedList<>();

        // putting the frequencies into the max-heap
        for(int a : map){
            if(a > 0) pq.offer(new int[]{a, 0});
        }
        int time = 0;
        while(!q.isEmpty() || !pq.isEmpty()){
            time++;
            // check if there is a task in max-heap and process it
            int execTime = time + n;
            if(!pq.isEmpty()){
                int [] task = pq.poll();
                int freq = task[0];
                freq--;
                // If there are more instances of this task, schedule it with a new cooldown
                if(freq > 0) q.offer(new int[]{freq, time + n});
            }
            // Check if any tasks in the cooldown queue are ready to be rescheduled
            if(!q.isEmpty() && q.peek()[1] <= time) pq.offer(q.poll());
        }
        return time;
    }
}
