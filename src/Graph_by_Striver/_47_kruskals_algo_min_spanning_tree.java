package Graph_by_Striver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://bit.ly/3eLuYvH

public class _47_kruskals_algo_min_spanning_tree {

    // TC : O(V+E + E log E + V * 4 * alpha * 2) --> E is the number of edges and V is number of node
    // SC : O(V + V) --> for the parent and size array int the disjoint set
    static int spanningTree(int V, int E, List<List<int[]>> adj) {

        int sum = 0;
        List<int[]> list = new ArrayList<>();

        // we make a adj list, where we are storing from , to and the weight
        // O(V+E)
        for(int i = 0; i < V; i++){
            for(int [] arr : adj.get(i)){
                int from = i;
                int to = arr[0];
                int wt = arr[1];

                list.add(new int []{from, to, wt});
            }
        }

        // sorting the list according to weight
        // O(E log E) --> M is the number of edge
        Collections.sort(list,(x, y) -> x[2] - y[2]);

//        list.sort((x, y) -> x[2] - y[2]); // new java feature

        // using disjoint set to check whether both from and to node belong to same component or set or not, if they belong to same component then don't consider that edge otherwise it will make a cycle, if they belong to different components then take the weight and make union of them

        // V * 4 * alpha * 2
        DisjointSet ds = new DisjointSet(V);

        for(int [] arr : list){
            int from = arr[0];
            int to = arr[1];
            int wt = arr[2];

            if(ds.findRootParent(from) != ds.findRootParent(to)){
                sum += wt;
                ds.unionBySize(from, to);
            }
        }
        return sum;
    }
}
