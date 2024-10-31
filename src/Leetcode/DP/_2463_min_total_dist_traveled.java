package Leetcode.DP;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

//https://leetcode.com/problems/minimum-total-distance-traveled/description/?envType=daily-question&envId=2024-10-31

public class _2463_min_total_dist_traveled {
    // without memoization the time will be 2^m+n, because for each robot we can travel upto the factory length and each time we are making two calls

    // TC : O(m * n) --> m = robot.size, n = flattenfactory.size
    // SC : O(m*n)
    Long [][] dp;
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]); // sorting based on position

        // flattening the factory, which means if factory looks like this
        // factory [[2, 2], [5, 1], [6, 2]] --> [2,2,5,1,6,6]
        List<Integer> flattenFact = new ArrayList<>();
        for(int [] a : factory){
            for(int i = 0; i < a[1]; i++){
                flattenFact.add(a[0]);
            }
        }
        dp = new Long[101][flattenFact.size()];
        return minDistFind(0, 0, robot, flattenFact);
    }
    long minDistFind(int currRobo, int currFact, List<Integer> robot, List<Integer> flattenFact){
        // base case
        // all robots repaired
        if(currRobo == robot.size()) return 0;

        // no more factory left but robots are left
        if(currFact == flattenFact.size()) return (long)1e12;

        if(dp[currRobo][currFact] != null) return dp[currRobo][currFact];

        // we have two options, either we repair the robo at the currFact or we skip the currFact
        // repair case
        // abs diff between currRobo position and currFact position
        // one robot got repair at a factory so robot increase by one and fact increase by one
        long repair = Math.abs(robot.get(currRobo) - flattenFact.get(currFact)) + minDistFind(currRobo + 1, currFact + 1, robot, flattenFact);

        // when not repair, this means robots number remains same, but we skip a factory, so it increase by 1
        long not = minDistFind(currRobo, currFact + 1, robot, flattenFact);

        return dp[currRobo][currFact] = Math.min(repair, not);
    }
}
