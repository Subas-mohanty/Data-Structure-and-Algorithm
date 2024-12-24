package Leetcode.Array;

import java.util.Arrays;
//https://leetcode.com/problems/most-profit-assigning-work/?envType=daily-question&envId=2024-06-18
public class _826_profit_assigning_work {
    public static void main(String[] args) {
        int [] difficulty = {2,4,6,8,10};
        int [] profit = {10,20,30,40,50};
        int [] worker = {4,5,6,7};
        System.out.println(maxProfitAssignment(difficulty, profit, worker));
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        Pair [] pair = new Pair[n];
        for(int i = 0; i < n; i++){
            pair[i] = new Pair(difficulty[i], profit[i]);
        }
        Arrays.sort(pair);
        Arrays.sort(worker);
        int j = worker.length;
        int ans = 0;

        // considering the elements from the back, because we need the elements in descending order
        while(n > 0 && j > 0){
            if(pair[n-1].d <= worker[j-1]){
                ans += pair[n-1].p;
                // we can take multiple jobs, so we are not changing n value here
                j--;
            }
            else n--;
        }
        return ans;
    }

    static class Pair implements Comparable<Pair>{
        int d;
        int p;
        public Pair(int d, int p){
            this.d = d;
            this.p = p;
        }
        public int compareTo(Pair O){
            return this.p - O.p;
        }
    }
}
