package Graph_by_Striver;

import java.util.ArrayList;

public class _07_numberOf_provinces {

    public int number_of_provinces(int V, ArrayList<ArrayList<Integer>> adj) {
        int count = 0;
        boolean [] visit = new boolean[V+1];
        for(int i = 0 ; i< V; i++){
            if(!visit[i]){
                count++;
                dfs(adj, i, visit);
            }
        }

        return count;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean [] visit) {
        visit[node] = true;

        for(int x : adj.get(node)){
            if(!visit[x]){
                dfs(adj, x, visit);
            }
        }
    }
}
