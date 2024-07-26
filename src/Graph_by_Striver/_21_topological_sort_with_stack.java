package Graph_by_Striver;

import java.util.ArrayList;
import java.util.Stack;
//https://bit.ly/3PvBfsm
public class _21_topological_sort_with_stack {
    // Topological sort means , if in a directed acyclic graph, there is an edge between u and v
    // then in the topological sort , u should come before v
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int [] vis = new int[V];
        Stack<Integer> stack = new Stack<>();
        int [] arr = new int[V];
        int ind = 0;

        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                dfs(i, adj, vis, stack);
            }
        }

        while(!stack.isEmpty()){
            arr[ind++] = stack.pop();
        }
        return arr;
    }
    public static void dfs(int start, ArrayList<ArrayList<Integer>> adj, int [] vis, Stack<Integer> stack){
        vis[start] = 1;

        for(int node : adj.get(start)){
            if(vis[node] == 0) dfs(node, adj, vis, stack);
        }
        // after finishing all the dfs calls for a particular node we are adding it in the stack,
        // but why ?
        // when all dfs calls are finished, we are adding because this node will come before other,
        // let's say , the current node don't have any adjacent node, so it will be added to the stack,
        // but what does it mean, that all the other node will come before this node and at the end
        // we are removing the elements from the stack which will make sure the correct order
        stack.push(start);
    }
}
