package Leetcode.Graph;

import java.util.ArrayList;
import java.util.List;

public class _2192_ancestors_of_node_in_DAG {


    // TC : O(n * (n+e)) --> (n+e) for dfs and we are doing dfs for every node
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        // creating the adjacency list
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
            res.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            adjList.get(from).add(to);
        }

        for(int i = 0; i < n; i++){
            // re initialize the visited array on every iteration so that for every new node the visited array should be clear, that means for every new node we want the previously visited nodes are no longer present in the visited array
            int [] visited = new int[n];
            visited[i] = 1;
            dfs(i, visited, adjList, i, res);
        }
        return res;
    }

    // dfs 
    public void dfs(int node, int [] visited, List<List<Integer>> adjList, int parent, List<List<Integer>> res){

        visited[node] = 1;
        for(int x : adjList.get(node)){
            if(visited[x] != 1){
                res.get(x).add(parent);
                dfs(x, visited, adjList, parent, res);
            }
        } 
    }
}