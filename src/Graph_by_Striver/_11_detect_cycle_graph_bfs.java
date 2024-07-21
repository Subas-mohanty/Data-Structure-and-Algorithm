package Graph_by_Striver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://shorturl.at/6nRWG

public class _11_detect_cycle_graph_bfs {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int [] vis = new int[V];

        // traversing all the vertices and checking if cycle is present at that vertex or not
        for(int i= 0; i < V; i++){
            if(vis[i] == 0){
                if(helper(i, V, adj, vis)) return true;
//                if(dfs(i, -1, V, adj, vis)) return true; // for dfs
            }
        }
        return false;
    }
    public boolean helper(int src, int v, ArrayList<ArrayList<Integer>> adj, int [] vis){
        // storing both the node and the parent node(the vertex from which it came from)
        Queue<Pair> q = new LinkedList<>();
        vis[src] = 1;
        q.offer(new Pair(src, -1));

        while(!q.isEmpty()){
            int node = q.peek().first;
            int parent = q.remove().second;

            for(int adjNode : adj.get(node)){
                // not visited, so adding to the queue
                if(vis[adjNode] == 0){
                    vis[adjNode] = 1;
                    q.offer(new Pair(adjNode, node));
                }
                // if the element is previously visited but not parent, then there is a cycle present
                else if(adjNode != parent) return true;;
            }
        }
        return false;
    }

    public boolean dfs(int src, int parent, int v, ArrayList<ArrayList<Integer>> adj, int [] vis){
        vis[src] = 1;

        for(int adjNode : adj.get(src)){
            if(vis[adjNode] == 0){
                if(dfs(adjNode, src, v, adj, vis)) return true;
            }
            // if the element is previously visited but not parent, then there is a cycle present
            else if(adjNode != parent) return true;;
        }
       return false;
    }




    class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}
