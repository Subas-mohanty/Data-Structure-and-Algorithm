package Leetcode.Graph;

import java.util.Arrays;
import java.util.PriorityQueue;
//https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/description/?envType=daily-question&envId=2024-11-28
// https://www.youtube.com/watch?v=UQogvDBoHe4
// This question could have been solved with dp and recursion with backtracking is working as well, but memoization is giving wrong result
// so we have to solve it using graph, here i am using dijkstra algorithm to find the shortest path, because if we do this "Model the grid as a graph where cells are nodes and edges are between adjacent cells. Edges to cells with obstacles have a cost of 1 and all other edges have a cost of 0", then it becomes very simple shortest path find problem
// one more key point is, we don't have to build the graph here, just assume that it is a graph and use accordingly
public class _2290_min_obstacle_remove_to_reach_corner {
    class Solution {
        public int minimumObstacles(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int [][] result = new int[n][m];
            for(int [] a : result) Arrays.fill(a, (int)1e9);

            PriorityQueue<int[]> pq  = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            pq.offer(new int[]{0,0,0});
            result[0][0] = 0;

            while(!pq.isEmpty()){
                int [] curr = pq.poll();
                int wt = curr[0];
                int i = curr[1];
                int j = curr[2];

                int [][] directions = {{0,-1}, {0, 1}, {-1,0}, {1,0}};
                for(int [] dir : directions){
                    int x = i + dir[0];
                    int y = j + dir[1];
                    // check if x and y are in bound
                    if(x >= 0 && x < n && y >= 0 && y < m){
                        int newCellWt = grid[x][y] == 1 ? 1 : 0;
                        if(wt + newCellWt < result[x][y]) {
                            result[x][y] = wt + newCellWt;
                            pq.offer(new int[]{wt + newCellWt, x, y});
                        }
                    }
                }
            }
            return result[n-1][m-1];
        }
    }
}
