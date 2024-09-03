package Graph_by_Striver;

import java.util.*;

//https://bit.ly/3SlYvLp

public class _35_print_shortest_path {
    public static List<Integer> shortestPath(int V, int m, int [][] edges){
//        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        // Create an adjacency list of pairs of the form node1 -> {node2, edge weight}
        // where the edge weight is the weight of the edge from node1 to node2.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V+1; i++) {
            adj.add(new ArrayList<>());
        }
        // Fill the adjacency list with edges
        for(int [] arr : edges){
            int from = arr[0];
            int to = arr[1];
            int weight = arr[2];
//            adj.get(from).add(new ArrayList<>(Arrays.asList(to, weight)));
//            adj.get(to).add(new ArrayList<>(Arrays.asList(from, weight)));
            adj.get(from).add(new Pair(to, weight));
            adj.get(to).add(new Pair(from, weight));
        }

        // Create a priority queue for storing the nodes along with distances
        // in the form of a pair { node, dist}.
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);

        // Create a dist array for storing the updated distances and a parent array for storing the nodes from where the current nodes represented by indices of the parent array came from.
        int [] dist = new int[V+1];
        int [] parent = new int[V+1];
        for (int i = 1; i < V+1; i++) {
            parent[i] = i;
            dist[i] = (int)1e9;
        }
        dist[1] = 0;

        // Push the source node to the queue.
        pq.offer(new Pair(1, 0));
        while (!pq.isEmpty()) {
            Pair removed = pq.poll();
            int node = removed.node;
            int distance = removed.dist;

//            for(ArrayList<Integer> list : adj.get(node))
            for(Pair list : adj.get(node)){
//                int currWeight = list.get(1);
//                int childNode = list.get(0);
                int currWeight = list.dist;
                int childNode = list.node;

                // Check if the previously stored distance value is greater than the current computed value or not, if yes then update the distance value.
                if(distance + currWeight < dist[childNode]){
                    dist[childNode] = distance + currWeight;
                    pq.offer(new Pair(childNode, dist[childNode]));

                    // Update the parent of the adjNode to the recent node where it came from.
                    parent[childNode] = node;
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        int node = V;

        // If distance to a node could not be found, return a list containing -1.
        if(dist[node] == (int)1e9){
            ans.add(-1);
            return ans;
        }
        // Iterate backwards from destination to source through the parent array.
        while(parent[node] != node){
            ans.add(node);
            node = parent[node];
        }
        ans.add(1); // the above loop doesn't add the source node, because the parent of 1 is 1, so adding it manually here
        ans.add(dist[V]); // question asked to add the shortest path to the end node to add at first index of the list, adding it at last so that after reversing it will come to first

        // Since the path stored is in a reverse order, we reverse the list
        // to get the final answer and then return the list.
        Collections.reverse(ans);
        return ans;
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
