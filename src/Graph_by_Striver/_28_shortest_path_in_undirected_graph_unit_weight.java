package Graph_by_Striver;

import java.util.*;
//https://bit.ly/3RGnHLH
public class _28_shortest_path_in_undirected_graph_unit_weight {
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {

        // creating the graph from the 2D array
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for(int [] edge : edges){
            int from = edge[0];
            int to = edge[1];
            adjList.get(from).add(to);
        }

        int [] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        while(!q.isEmpty()){
           int removed = q.poll();
           for(int node : adjList.get(removed)){
               // for every node , we are checking how much distance is needed to reach its parent and then we add 1 to it as all node has unit weight, if we can reach the current node with less distance then we are updating the dist
                if(dist[removed] + 1 < dist[node]) dist[node] = dist[removed] + 1;
                q.offer(node);
           }
        }
        // the nodes that can't be reached , marking them as -1
        for (int i = 0; i < n; i++){
            if(dist[i] == (int)1e9) dist[i] = -1;
        }
        return dist;
    }
}
