package Leetcode.Graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Question
// given an undirected tree return its diameter: the number of edges in the longest path in the tree
// the tree is given as an array of edges where edges[i] = [u, v], is a bidirectional edge between node u and v, Each node has labels in the set {0, 1, 2, ...., edges.length}

// the question asked us to find the diameter of the graph, means we will be given a graph and we have to find the maximum distance between any two node, and the length will be the diameter
// youtube explanation
// https://www.youtube.com/watch?v=na3LE8CBYLo&t=1s


// one thing is true in this case is, we can start at any node and go to the farthest node, and it will one of the node, which is either end of the diameter
// and then again we can start from the one end of the diameter and move to the farthest node and we will get another end of the diameter
//T.C : O(V+E)
//S.C : O(V+E)
public class _1245_Tree_diameter {
    public static void main(String[] args) {
        int [][] edges = {{0,1}, {0,4}, {0,5}, {1,2}, {2,3}, {2, 6}, {3,7}};
        System.out.println(diameter(edges));
    }
    public static int diameter(int [][] edges){
        // creating adjlist from the edges array
        List<List<Integer>> list = new ArrayList<>();
        int n = edges.length + 1;
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for(int [] a : edges){
            int from = a[0];
            int to = a[1];
            list.get(from).add(to);
            list.get(to).add(from);
        }
        return findDiameter(n, list);
    }
    public static int findDiameter(int n, List<List<Integer>> list){
        // find farthest node from any node, it will give one end of the diameter
        int [] farthestNodeResult = findFarthestNode(n, list, 0);
        // again do bfs to find the another node of the diameter
        int [] diameterResult = findFarthestNode(n, list, farthestNodeResult[0]);
        return diameterResult[1]; // return the length
    }
    // simple bfs to find the farthest node from the current node and the distance
    private static int [] findFarthestNode(int n, List<List<Integer>> list, int node){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        boolean [] visit = new boolean[n];
        visit[node] = true;
        int level = 0;
        int removed = node;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                removed = q.poll();
                for(int neighbour : list.get(removed)){
                    if(!visit[neighbour]){
                        q.offer(neighbour);
                        visit[neighbour] = true;
                    }
                }
            }
            if (!q.isEmpty())level++;
        }
        return new int[]{removed, level};
    }
}
