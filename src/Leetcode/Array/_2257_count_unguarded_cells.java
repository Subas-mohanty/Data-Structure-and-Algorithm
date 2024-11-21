package Leetcode.Array;

// https://leetcode.com/problems/count-unguarded-cells-in-the-grid/?envType=daily-question&envId=2024-11-21


public class _2257_count_unguarded_cells {
    // TC : o(g + w + g * (r + c) + m * n)
    // SC : O(m * n)
    public int countUnguarded(int n, int m, int[][] guards, int[][] walls) {
        int [][] visit = new int[n][m];

        // O(g) times to mark the guards position in the visit array
        for(int [] arr : guards){
            int i = arr[0];
            int j = arr[1];
            visit[i][j] = 2;
        }

        // O(w) times to mark the walls in the visit array
        for(int [] arr : walls){
            int i = arr[0];
            int j = arr[1];
            visit[i][j] = 3;
        }
        // for each guard we are going to its left, right, up and down which will take g * (r + c)
        for(int [] arr : guards){
            int i = arr[0];
            int j = arr[1];
            markGuarded(i, j, visit);
        }

        // finding number of unguarded cells
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visit[i][j] == 0) count++;
            }
        }
        return count;
    }
    void markGuarded(int row, int col, int [][] visit){
        int n = visit.length;
        int m = visit[0].length;

        // right
        // marking all the cells to the right of the current guard is guarded, until another guard or wall is found, same for left, up and down
        for(int i = col+1; i < m; i++){
            if(visit[row][i] == 3 || visit[row][i] == 2) break;
            visit[row][i] = 1; // mark as guarded
        }
        // left
        for(int i = col-1; i >= 0; i--){
            if(visit[row][i] == 3  || visit[row][i] == 2) break;
            visit[row][i] = 1;
        }
        // up
        for(int i = row-1; i >= 0; i--){
            if(visit[i][col] == 3  || visit[i][col] == 2) break;
            visit[i][col] = 1;
        }
        // down
        for(int i = row+1; i < n; i++){
            if(visit[i][col] == 3  || visit[i][col] == 2) break;
            visit[i][col] = 1;
        }
    }
}
