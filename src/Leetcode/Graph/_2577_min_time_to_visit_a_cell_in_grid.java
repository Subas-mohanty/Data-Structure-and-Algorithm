package Leetcode.Graph;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/?envType=daily-question&envId=2024-11-29
//https://www.youtube.com/watch?v=2H9CVEmmMUM&t=9s
public class _2577_min_time_to_visit_a_cell_in_grid {
    // TC : O(E * log V) --> E = no of edges - m*n, V = no of nodes - m*n
    // SC : O(m*n)
    public int minimumTime(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][1] > 1 && grid[1][0] > 1) return -1;
        int[][] result = new int[n][m];
        for (int[] a : result) Arrays.fill(a, (int) 1e9);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});
        result[0][0] = 0;
        boolean [][] visit = new boolean[n][m];

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int i = curr[1];
            int j = curr[2];

            if(visit[i][j]) continue;
            visit[i][j] = true;

            int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
            for (int[] dir : directions) {
                int x = i + dir[0];
                int y = j + dir[1];

                // check if x and y are in bound
                if (x >= 0 && x < n && y >= 0 && y < m && !visit[x][y]) {
                    // we can go to next cell
                    int nextTime = 0;
                    if (time + 1 >= grid[x][y]) nextTime = time + 1;
                        // can't go to next cell but the next cell is even, so we need grid[x][y] + 1 time
                    else if((grid[x][y] - time) % 2 == 0) nextTime = grid[x][y] + 1;
                        // can't go to next cell but the next cell is odd, so we need exactly grid[x]y]
                    else nextTime= grid[x][y];

                    if(nextTime < result[x][y]){
                        result[x][y] = nextTime;
                        pq.offer(new int[]{nextTime , x, y});
                    }
                }
            }
        }
        return result[n - 1][m - 1];
    }
}
