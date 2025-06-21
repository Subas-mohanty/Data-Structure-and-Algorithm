package Graph_by_Striver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//https://bit.ly/3SQQgId


/* what is a bipartite graph ?
   ans : A bipartite graph is a graph in which if we took two colours and color the nodes of the graph, no two adjacent nodes would have the same colour.
   - In other words we can say if a graph has no cycle then it is a bipartite graph.
   - if a graph has cycle and the cycle length is even then also it is a bipartite graph but if the cycle length is odd then it is not a bipartite graph.
   - draw a diagram to understand the above two sentence easily.
*/
public class _17_isBipartite_graph {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj){
        int [] visit = new int[V]; // the visit array is also used to mark color

        for(int i = 0; i < V; i++){
            if(visit[i] == 0){
//                if(bfs(i, adj, visit) == false) return false;
                if(dfs(i, adj, visit, 1) == false) return false;
            }
        }
        return true;
    }

    public boolean bfs(int start, ArrayList<ArrayList<Integer>>adj, int [] visit){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = 1;
        while(!q.isEmpty()){
            int removed = q.poll();
            for(int node : adj.get(removed)){
                if(visit[node] == 0){
                    visit[node] = (visit[removed] == 1) ? 2 : 1;
                    q.offer(node);
                }
                if(visit[removed] == visit[node]) return false;
            }
        }
        return true;
    }
    public boolean dfs(int start, ArrayList<ArrayList<Integer>> adj, int [] visit, int color){
        visit[start] = color;
        for(int node : adj.get(start)){
            if(visit[node] == 0) {
                if (dfs(node, adj, visit, color == 1 ? 2 : 1) == false) return false;
            }
            else if(visit[node] == visit[start]) return false;
        }
        return true;
    }
}
