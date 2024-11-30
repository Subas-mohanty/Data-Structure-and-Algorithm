package Leetcode.Graph;

import java.util.*;
//https://leetcode.com/problems/valid-arrangement-of-pairs/?envType=daily-question&envId=2024-11-30
//https://www.youtube.com/watch?v=ElXqjhZoUC0&t=113s
public class _2097_valid_arrangements_of_pairs {

    // TC : O(V+E) for normal DFS
    // SC : O(V+E)
    public int[][] validArrangement(int[][] pairs) {
        // constructing the graph
        Map<Integer, List<Integer>> list = new HashMap<>();
        List<Integer> li = new ArrayList<>(); // store the euler path

        // storing indegree and outdegree of each node
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();
        for(int [] a : pairs){
            int u = a[0];
            int v = a[1];

            outdegree.put(u, outdegree.getOrDefault(u, 0) + 1);
            indegree.put(v, indegree.getOrDefault(v, 0) + 1);
            list.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }
        // default start node
        int startNode = pairs[0][0];
        // find the start node
        for(int i : list.keySet()){
            // in an euler path the start node should have one extra outgoing edge which means no of outdegree will be one more than no of indegree
            if (outdegree.getOrDefault(i, 0) - indegree.getOrDefault(i, 0) == 1) {
                startNode = i;
                break;
            }
        }

        dfs(list, li, startNode);
        Collections.reverse(li); // reverse the list to get the correct order

        // create the answer from the euler path list
        int [][] ans = new int[pairs.length][2];
        for(int i = 0; i< li.size() - 1; i++){
            ans[i][0] = li.get(i);
            ans[i][1] = li.get(i+1);
        }
        return ans;
    }

    void dfs(Map<Integer, List<Integer>> list, List<Integer> li, int node){
        while (list.containsKey(node) && !list.get(node).isEmpty()) {
            int n = list.get(node).removeLast();
            dfs(list, li, n);
        }
        li.add(node); // add the node after visiting all of its neighbour, the last node of the euler path should be put first
    }
}
