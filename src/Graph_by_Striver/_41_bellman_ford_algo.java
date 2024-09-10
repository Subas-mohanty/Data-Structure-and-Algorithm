package Graph_by_Striver;

import java.util.ArrayList;
import java.util.Arrays;

// https://bit.ly/3K7emug
// https://www.youtube.com/watch?v=0vVofAhAYjc


// Now we have 3 questions ?
// 1. What is a negative cycle ?
// 2. How to detect negative cycles ?
// 3. Why N-1 iterations ?
// Ans 1. if a graph has negative edge after relaxing all the edges and its still reducing then it is called a negative cyble. Or if a graph has a cycle and the sum of total edges is negative(less than 0) then we can say the graph has a negative cycle
// Ans 2. after relaxing all the edges, do one more iteration and check if the weight is still reducing or not, if yes then the graph has negative cycles
// Ans 3. Let's take an example
// ex : 0 -> 1 -> 2 -> 3 -> 4  edges[[3,4,1]], [2,3,1], [1,2,1], [0,1,1]
// for this kind of graph, at each iteration we will be relaxing one node, as you can see the source node is at the last so after first iteration we relax the source node and in the next iteration we will relax node 1 as it is just above the node 1 and it is connected to node 0, so in each iteration we will relax one node, there except source node there is N-1 or V-1 node, so at the worst case we will have to iterate for N-1 times, in general no. of Vertex - 1 time

public class _41_bellman_ford_algo {

    // TC : O(v * e)
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int [] dist = new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[S] = 0;

        for (int i = 1; i < V; i++) {
            for(ArrayList<Integer> list : edges){
                int from = list.get(0);
                int to = list.get(1);
                int wt = list.get(2);

                if(dist[from] != (int)1e8 && dist[from] + wt < dist[to]){
                    dist[to] = dist[from] + wt;
                }
            }
        }
        
        // this is extra code written for the question, not part of bellman_ford
        // this thing check whether there is a negative cycle present or not, negative cycle means if the path weight is negative after performing bellman_ford
        // checking form nth iteration if the value is still reducing means it has a negative cycle
        for(ArrayList<Integer> list : edges){
                int from = list.get(0);
                int to = list.get(1);
                int wt = list.get(2);

                if(dist[from] != (int)1e8 && dist[from] + wt < dist[to]){
                    return new int[]{-1};
                }
            }
        return dist;
    }
}
