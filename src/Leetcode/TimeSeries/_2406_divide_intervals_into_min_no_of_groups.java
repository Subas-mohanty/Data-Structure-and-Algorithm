package Leetcode.TimeSeries;
//https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/description/?envType=daily-question&envId=2024-10-12
//https://www.youtube.com/watch?v=lIzI8PknW6M

public class _2406_divide_intervals_into_min_no_of_groups {

    // TC : O(n + n + range(min to max))
    // SC : O(max + 2)
    public static int minGroups(int[][] intervals) {
        int min = (int)1e9;
        int max = -(int)1e9;

        // finding min and max in intervals array
        for(int [] arr : intervals){
            for(int a : arr){
                min = Math.min(min, a);
                max = Math.max(max, a);
            }
        }

        // making an array to store the number of overlaps at each point in the intervals array
        // this is a part of an algorithm called line sweep algorithm, it is used to check the number of intersection at each point in a range
        int [] events = new int[max + 2];

        for(int [] arr : intervals){
            int s = arr[0];
            int e = arr[1];
            events[s]++;
            events[e+1]--; // normally this is events[e]--, but the question states the end is inclusive so increasing the end
        }

        // now find the prefix sum of the events array and take the maximum
        int sum = 0;
        int ans = 0;

        for(int a : events){
            sum += a;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
