package Leetcode.TimeSeries;

import java.util.Arrays;
import java.util.PriorityQueue;
//https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/?envType=daily-question&envId=2024-10-11
//https://www.youtube.com/watch?v=FVysOn0hdww
public class _1942_number_of_smallest_occupied_chair {
    public static void main(String[] args) {
        int[][] array = {
                {3, 10},
                {1, 5},
                {2, 6}
        };
        System.out.println(smallestChair(array, 0));
    }
    // TC : (n log n + n log n) --> sorting + loop * queue operation
    // SC : O(n)

    public static int smallestChair(int[][] times, int targetFriend) {

        int target = times[targetFriend][0]; // storing the arrival time to match with curr time and return answer
        Arrays.sort(times, (x, y) -> x[0] - y[0]); // sort time according to arrival time

        // [leavingTime, chairNo]
        // to store the leaving time and chair no for every person
        PriorityQueue<int[]> occupiedChair = new PriorityQueue<>((a, b)-> a[0] - b[0]);
        PriorityQueue<Integer> availableChair = new PriorityQueue<>(); // storing all available chairs
        int chair = 0;

        for(int [] arr : times){
            int arrTime = arr[0];
            int depTime = arr[1];
            // if the current arrival time is >= the smallest time present in occupiedChair, then that chair can be available as the person has left
            while(!occupiedChair.isEmpty() && arrTime >= occupiedChair.peek()[0]){
                availableChair.offer(occupiedChair.poll()[1]);
            }
            int currChair;
            // if no available chair is present then count the chair from 0 and increase it
            if(availableChair.isEmpty()){
                currChair = chair;
                chair++;
            }
            // if chair is available then get it from the available chair, it will return the smallest chair available
            else currChair = availableChair.poll();
            occupiedChair.offer(new int[]{depTime, currChair});
            // if we found the targetPerson then return its chair number
            if(arrTime == target) return currChair;
        }
        return -1;
    }
}