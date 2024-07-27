package Graph_by_Striver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//https://www.youtube.com/watch?v=tZjVTTABXV0
//https://www.geeksforgeeks.org/problems/topological-sort/1
public class TopoSort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // find incoming edges for every node
        int [] inDegree = new int[V];
        for(int i = 0; i < V; i++){
            for(int node : adj.get(i)) inDegree[node]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // adding nodes to queue which indegree is 0
        for(int i = 0; i < V; i++){
            if(inDegree[i] == 0) q.offer(i);
        }
        ArrayList<Integer> res = new ArrayList<>();

        // kahn's algorithm
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);

            // visit all neighbours
            for(int neighbours : adj.get(node)){
                inDegree[neighbours]--;
                if(inDegree[neighbours] == 0) q.offer(neighbours);
            }
        }
        
        // converting list to array
        int [] ans = new int[V];
        for(int i = 0; i < V; i++){
            ans[i] = res.get(i);
        }

        return ans;
    }
}
