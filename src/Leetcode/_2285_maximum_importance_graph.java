package Leetcode;

import java.util.Arrays;
import java.util.Comparator;
//https://leetcode.com/problems/maximum-total-importance-of-roads/description/?envType=daily-question&envId=2024-06-28
public class _2285_maximum_importance_graph {

    // TC : O(n log n)
    // SC : O(n)
    public long maximumImportance(int n, int[][] roads) {

        // Array to store the degree of each city, number of edges connected to that node
        int [] degree = new int[n];

        // Calculate the degree of each city
        for(int [] road : roads){
            degree[road[0]]++;
            degree[road[1]]++;
        }

        // Create a list of cities and sort by degree
        Integer [] cities = new Integer[n];
        for(int i = 0; i < n; i++) cities[i] = i;

        // sorting the cities array according to the degree, means higher the degree , first it comes in the sorted array, sorting in descending order of the degrees
        Arrays.sort(cities, new Comparator<>(){
            public int compare(Integer a, Integer b){
                return degree[b]-degree[a];
            }
        });

        // Assign values to cities starting from the highest degree
        long ans = 0;
        for(int i = 0; i < n; i++){
            // multiplying with (n-1) because we can assign number from 1 to n, and which node has the maximum degree should be assigned with n so that we can get the max return
            ans += (long) (n-i) * degree[cities[i]];
        }
        return ans;
    }
}
