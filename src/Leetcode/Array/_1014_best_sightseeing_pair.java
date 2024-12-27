package Leetcode.Array;

//https://leetcode.com/problems/best-sightseeing-pair/description/?envType=daily-question&envId=2024-12-27

public class _1014_best_sightseeing_pair {

    // brute force will be, check for every pair with two nested loops, and its time complexity will be O(n^2)

    // TC : O(N)
    // SC : O(N)
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        // in this array we are storing max value of values[i] + i, till that index
        // for values = [8,1,5,2,6]
        // arr = [8, 8, 8, 8, 10] , 8+0, max(8, 1+1), max(8, 5+2) .......
        int [] arr = new int[n];
        int max = 0;
        int ans = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, values[i] + i);
            arr[i] = max;
        }
        // now for every j, find the largest values of i from the arr, the index should be less than i, so find arr[i-1]
        for(int i = 1; i< n; i++){
            ans = Math.max(ans, values[i] - i + arr[i-1]);
        }
        return ans;
    }


    // we don't need the arr array in the above code, because we will need the max value till that index, which can be done by using a variable

    // TC : O(N)
    // SC : O(1)
    public int maxScoreSightseeingPair2(int[] values) {
        int n = values.length;
        int ans = 0;
        int max = values[0];
        for(int i = 1; i< n; i++){
            // find the max between curr ans and values[j] - j + max till the prev index
            ans = Math.max(ans, values[i] - i + max);
            max = Math.max(max, values[i] + i); // update the max for the next iteration
        }
        return ans;
    }
}
