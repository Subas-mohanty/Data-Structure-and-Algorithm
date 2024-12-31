package Leetcode.DP; 
import java.util.Arrays;
//https://leetcode.com/problems/minimum-cost-for-tickets/submissions/1493269945/?envType=daily-question&envId=2024-12-31
public class _983_min_cost_for_tickets {
    public static void main(String[] args) {
        int [] days = {1,4,6,7,8,20};
        int [] costs = {2, 7 , 15};
        System.out.println(mincostTickets(days, costs));
    }

    // recursive approach
    // at each index we have 3 options either take a one day pass, take a 7 day pass or take a 30 day pass, and take the min
    public static int mincostTickets(int[] days, int[] costs) {
        return helper(days, costs, 0);
    }
    static int helper(int [] days, int [] costs, int ind){

        if(ind == days.length) return 0;

        int one = costs[0] + helper(days, costs, findInd(days, days[ind] + 1));
        int seven = costs[1] + helper(days, costs, findInd(days, days[ind] + 7));
        int thirty = costs[2] + helper(days, costs, findInd(days, days[ind] + 30));
        return Math.min(one, Math.min(seven, thirty));
    }

    // find the index of day till which we have travelled
    static int findInd(int [] days, int day){
        for(int i = 0; i < days.length; i++){
            if(days[i] >= day) return i;
        }
        return days.length;
    }

    // memoization
    // TC : O(n)
    // SC : O(n + n) --> dp array + recursion stack space
    int [] dp;
    public int mincostTickets2(int[] days, int[] costs) {
        dp = new int[days.length];
        Arrays.fill(dp, -1);
        return helper2(days, costs, 0);
    }
    int helper2(int [] days, int [] costs, int ind){

        if(ind == days.length) return 0;
        if(dp[ind] != -1) return dp[ind];
        int one = costs[0] + helper2(days, costs, findInd(days, days[ind] + 1));
        int seven = costs[1] + helper2(days, costs, findInd(days, days[ind] + 7));
        int thirty = costs[2] + helper2(days, costs, findInd(days, days[ind] + 30));
        return dp[ind] = Math.min(one, Math.min(seven, thirty));
    }

    // tabulation method
    // TC : O(n)
    // SC : O(n)
    public static int mincostTickets3(int[] days, int[] costs) {
        int n = days.length;
        int [] dp = new int[n + 1];
        dp[n] = 0;
        for(int i = n-1; i >= 0; i--){
            int one = costs[0] + dp[ findInd(days, days[i] + 1)];
            int seven = costs[1] + dp[ findInd(days, days[i] + 7)];
            int thirty = costs[2] + dp[ findInd(days, days[i] + 30)];
            dp[i] = Math.min(one, Math.min(seven, thirty));
        }
        return dp[0];
    }
}