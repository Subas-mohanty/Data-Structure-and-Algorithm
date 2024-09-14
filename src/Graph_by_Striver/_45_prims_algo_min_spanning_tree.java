package Graph_by_Striver;

import java.util.List;
import java.util.PriorityQueue;

public class _45_prims_algo_min_spanning_tree {

    // TC : O(E + log(e))
    // SC : O(E) + O(V) --> for min heap and visited array
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        boolean [] visit = new boolean[V];

        PriorityQueue<int []> q = new PriorityQueue<>((x, y) -> x[2] - y[2]);

        q.offer(new int[]{-1, 0, 0});
        int sum = 0;

        // O(E) --> at max the min heap will have all the edges if all the edges have same weight
        while(!q.isEmpty()){

            // this takes O(log e)
            int [] removed = q.poll();
            int from = removed[0];
            int to = removed[1];
            int wt = removed[2];

            if(visit[to]) continue;

            visit[to] = true;
            sum += wt;

            // the loop will run for the number of edges in the min heap times, so it is O(e) * log(e) for the heap insertion
            for(int [] arr : adj.get(to)){
                if(!visit[arr[0]]){
                    q.offer(new int[] {to, arr[0], arr[1]});
                }
            }
        }
        return sum;
    }
}
