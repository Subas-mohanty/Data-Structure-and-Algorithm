package Graph_by_Striver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//https://bit.ly/3QwPVsi
public class _23_detect_cycle_in_DAG_toposort {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int [] indgree = new int[V];
//        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < V; i++){
            for(int node : adj.get(i)){
                indgree[node]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indgree[i] == 0) q.offer(i);
        }
        int count = 0;
        while(!q.isEmpty()){
            int removed = q.poll();
//            list.add(removed);
            count++;
            for(int node : adj.get(removed)){
                indgree[node]--;
                if(indgree[node] == 0) q.offer(node);
            }
        }
        // in toposort if no cycle is present then there will be exact V number of elements in the toposort, but if there is cycle then it will give lesser than V number of elements in the toposort
        if(count == V) return false;
        return true;
    }
}
