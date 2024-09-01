package Graph_by_Striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//https://bit.ly/3KeZZ7j

public class _32_dijkstra_algorithm {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){

        // store the min distance to all the vertex form source(S)
        int [] arr = new int[V];
        Arrays.fill(arr, (int)1e9); // we will store minimum values in it so initializing it with a large value

        // using min heap to store each node and its distance, so that the node having the min distance will be on top
//        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
//            @Override
//            public int compare(Pair o1, Pair o2) {
//                return o1.dist - o2.dist;
//            }
//        });
        // we can simplify the above thing using lambda expression
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1,o2) -> o1.dist - o2.dist);

        // min distance from source to source is 0
        arr[S] = 0;
        // Source needs 0 distance to go to source so adding source with dist = 0 in the min heap
        pq.offer(new Pair(S, 0));

        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int dist = pq.poll().dist; // distance to reach node from source
            ArrayList<ArrayList<Integer>> adjNode =  adj.get(node);

//          adj = {{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}}
            // Check for all adjacent nodes of the popped out
            for(int i = 0; i < adjNode.size(); i++){
                int edgeWeight = adjNode.get(i).get(1);
                int childNode = adjNode.get(i).get(0);

                // if distance to reach the childnode is bigger than sum of distance to reach its parent and distance between parent to childnode then update the distance of childnode
                if(arr[childNode] > dist + edgeWeight){
                    arr[childNode] = dist + edgeWeight;
                    // after finding the min distance of childnode till now, we add it to the min heap
                    pq.offer(new Pair(childNode, arr[childNode]));
                }
            }
        }
        return arr;
    }

    static class Pair{
        int node;
        int dist;
        public Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
}
