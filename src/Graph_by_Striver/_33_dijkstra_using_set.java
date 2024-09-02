package Graph_by_Striver;

import java.util.*;

//https://bit.ly/3KeZZ7j
//https://www.youtube.com/watch?v=PATgNiuTP20

// TODO : Why did we do the set.remove thing ?
// In min heap, we didn't doing that because it wasn't storing all unique values, but in set it does so.
// So what we are actually doing is, when we found a smaller distance to a node, generally in the min heap we are only updating it, but in the set, when we find a smaller distance we made a check whether that node is previously visited by any other path which is a larger path
// If the node has been previously visited, that means the parent of that node (through which node we visit the current node) will be already in the set. And there is no need of visiting any further node using that node, because we found a smaller path. So we are removing it to avoid the redundant calls that node/Pair will cause.
// Now the question is why the parent node will be in the set why wouldn't it be removed earlier ? Just because we are sorting the pairs in the set according to the path or the distance needed to reach a node from the source node, so when a node is previously visited and has a larger path, it is guaranteed that the parent will be in the set
// If still there is any confusion refer to striver's lecture, link is given at the top of the file

public class _33_dijkstra_using_set {
    public int [] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s){
        int [] dist = new int[v];
        Arrays.fill(dist, (int)1e9);
        // can't use set here because set/hashset doesn't have a constructor which take comparator
        // and how we are sorting ?
        // sorting according to distance but when distance is equal use the node val
        TreeSet<Pair> set = new TreeSet<>((a, b) -> {
            if(a.dist == b.dist) return a.node - b.node;
            return a.dist - b.dist;
        });
        dist[s] = 0;
        set.add(new Pair(s, 0));

        while(!set.isEmpty()){
            Pair pair = set.pollFirst();
            int node = pair.node;
            int distance = pair.dist;
            for(ArrayList<Integer> adjList : adj.get(node)){
                int currWeight = adjList.get(1);
                int childNode = adjList.get(0);

                if(distance + currWeight < dist[childNode]){

                    // TODO : the only extra thing in this set approach is this, let's break it down at the top of the file

                    if(dist[childNode] != (int)1e9){ // previously visited but has larger path
                        // so remove the pair which has the curr child node, and the distance will be dist[childNode], because it is previously visited
                        set.remove(new Pair(childNode, dist[childNode]));
                    }
                    dist[childNode] = distance + currWeight;
                    set.add(new Pair(childNode, dist[childNode]));
                }
            }
        }
        return dist;
    }

    class Pair{
        int node;
        int dist;
        public Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
}
