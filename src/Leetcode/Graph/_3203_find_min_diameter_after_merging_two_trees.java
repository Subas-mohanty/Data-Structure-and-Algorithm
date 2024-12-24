package Leetcode.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/find-minimum-diameter-after-merging-two-trees/description/?envType=daily-question&envId=2024-12-24
public class _3203_find_min_diameter_after_merging_two_trees {
    // TC : O(V + E) --> same as bfs, and some extra for building the adj list
    // SC : O(V + E)
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int diam1 = diameter(edges1);
        int diam2 = diameter(edges2);
        int connectedDiam = (diam1+1)/2 + (diam2 + 1)/2 + 1;
        // why doing it we could have simply return connectedDiam
        // but no. there might be cases when any single tree has max diam, and diameter is the longest path between any two node in the graph, so when a bigger path is already present in the tree how can we take any other smaller path, because that is not even the diameter of the new tree, the diameter is still same as before
        return Math.max(connectedDiam, Math.max(diam1, diam2));
    }

    // from this to below is the code to find the diameter of any graph
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
