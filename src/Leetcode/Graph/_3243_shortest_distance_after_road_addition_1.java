package Leetcode.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/description/?envType=daily-question&envId=2024-11-27

public class _3243_shortest_distance_after_road_addition_1 {

    // TC : O( q * ( v + e)) --> v + e = n + n^2 because it says unidirectional edge and in the worst case there will be n^2 edge
    // ex : for 5 vertex edges will be 4  + 3 + 2 + 1 which is n * (n-1) / 2
    // SC : O(n^2 + n + n) --> list + vis + queue
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // creating a graph in list representation
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            list.get(i).add(i + 1);
        }

        // answer array
        int [] arr = new int[queries.length];
        int ind = 0;
        // for each query updating the graph and finding the shortest path
        for(int [] q : queries){
            list.get(q[0]).add(q[1]);
            arr[ind++] = bfs(n, list);
        }
        return arr;
    }
    // this will return the shortest path from 0 to n-1
    int bfs(int n, List<List<Integer>> list){
        Queue<Integer> q = new LinkedList<>();
        boolean [] vis = new boolean[n];
        q.offer(0);
        vis[0] = true;

        int move = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                if(node == n-1) return move;
                for(int next : list.get(node)){
                    if(!vis[next]){
                        q.offer(next);
                        vis[next] = true;
                    }
                }
            }
            move++;
        }
        return 0;
    }
}
