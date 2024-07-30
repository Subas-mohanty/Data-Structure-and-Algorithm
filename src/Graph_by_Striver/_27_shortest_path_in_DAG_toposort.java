package Graph_by_Striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
//https://bit.ly/3dJdQXE
public class _27_shortest_path_in_DAG_toposort {

    // TC : O(2*(N + M) + N) --> distance calculation + toposort + dist array traversal
    // SC : O(N + M + N + N + N) --> adjlist(N+M) + dist + stack + vis
    public int[] shortestPath(int N,int M, int[][] edges) {
        // creating the graph
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) adjList.add(new ArrayList<>());
        for(int [] edge : edges){
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            Pair pair = new Pair(to, weight);
            adjList.get(from).add(pair);
        }

        int [] vis = new int[N];
        Stack<Integer> stack = new Stack<>();
        int [] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // doing dfs and getting the toposort in the stack
        for(int i = 0; i < N; i++){
            if(vis[i] == 0) topoSort(i, adjList, stack, vis);
        }

        dist[0] = 0;
        // O(N + M) --> number of nodes + edges, because the for loop inside will run at most M times, and the stack will have all the nodes after completion of the toposort
        while(!stack.isEmpty()){
            int removed = stack.pop();

            for(Pair pair : adjList.get(removed)){
                int to = pair.first;
                int weight = pair.second;
                if((long)dist[removed] + weight < dist[to]){
                    dist[to] = dist[removed] + weight;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }
        return dist;
    }
    public void topoSort(int node, List<List<Pair>> adjList, Stack<Integer> stack, int [] vis){
        vis[node] = 1;
        for(Pair pair : adjList.get(node)){
            int to = pair.first;
            if(vis[to] == 0) topoSort(to, adjList, stack, vis);
        }
        stack.push(node);
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
