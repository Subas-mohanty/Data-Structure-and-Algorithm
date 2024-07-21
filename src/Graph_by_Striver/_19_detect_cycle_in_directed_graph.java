package Graph_by_Striver;

import java.util.ArrayList;
//https://shorturl.at/4Q2Ar
public class _19_detect_cycle_in_directed_graph {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int [] vis = new int[V];
        int [] pathVis = new int[V];

        // traversing all node, visiting and checking if cycle is present at any node, if yes, return true
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                if(dfs(i, adj, vis, pathVis)) return true;
            }
        }
        return false;
    }
    // TC : O(n+2E) , same as DFS

    // what we are doing here is, we are taking a visited array to store which node has visited or not, and also we are taking a pathVisit array, in which we are storing which nodes have been visited in the same path, means , if we are going in a direction and found no node further then we can backtrack and can say we are choosing a different patho
    public boolean dfs(int start, ArrayList<ArrayList<Integer>> adj, int [] vis, int [] pathVis){
        vis[start] = 1;
        pathVis [start] = 1;

        for(int node : adj.get(start)){
            // if node is unvisited
            if(vis[node] == 0){
                if(dfs(node, adj, vis, pathVis)) return true;
            }
            // if the node has been previously visited
            // But it has been visited in the same path
            else if(pathVis[node] == 1) return true;
        }

        pathVis[start] = 0;
        return false;
    }
}
