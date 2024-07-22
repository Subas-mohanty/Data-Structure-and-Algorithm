package Leetcode;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/find-eventual-safe-states/
public class _802_find_safe_nodes {
    public List<Integer> eventualSafeNodes(int [][] adj) {
        int V = adj.length;
        int [] vis = new int[V];
        int [] pathVis = new int[V];
        int [] check = new int[V];
        List<Integer> list = new ArrayList<>();

        // traversing all node, visiting and checking if cycle is present at any node, if yes, return true
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                dfs(i, adj, vis, pathVis, check);
            }
        }
        for(int i = 0; i < V; i++){
            if(check[i] == 1) list.add(i);
        }
        return list;
    }

    public boolean dfs(int start, int [][] adj, int [] vis, int [] pathVis, int [] check){
        vis[start] = 1;
        pathVis [start] = 1;
        check[start] = 0;

        for(int node : adj[start]){
            // if node is unvisited
            if(vis[node] == 0){
                if(dfs(node, adj, vis, pathVis, check)){
                    check[node] = 0;
                    return true;
                }
            }
            // if the node has been previously visited
            // But it has been visited in the same path
            else if(pathVis[node] == 1){
                check[node] = 0;
                return true;
            }
        }

        check[start] = 1;
        pathVis[start] = 0;
        return false;
    }
}
