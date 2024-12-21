package Leetcode.Tree;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/maximum-number-of-k-divisible-components/?envType=daily-question&envId=2024-12-21
public class _2872_max_number_of_k_divisible_components {

    // TC : O(n + n) --> making of list and dfs
    // SC : O(n + n) --> for list and for the recursion stack for dfs
    int result = 0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++) list.add(new ArrayList<>());

        // creating the adjacency list
        for(int [] a : edges){
            list.get(a[0]).add(a[1]);
            list.get(a[1]).add(a[0]);
        }
        dfs(0, -1, list, values, k);
        return result;
    }
    public long dfs(int curr, int parent, List<List<Integer>> list, int [] values, int k){
        // value of current node
        long total = values[curr];

        // for each of its adjacent nodes get the values
        for(int node : list.get(curr)){
            if(parent != node){
                total += dfs(node, curr, list, values, k);
            }
        }
        // if the current component has sum divisible by k, then we found an individual component
        if(total % k == 0){
            result++;
            return 0;
        }
        return total;
    }
}
