package Graph_by_Striver;

//https://shorturl.at/sLBz3
public class _15_number_of_enclaves {
    int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // checking first and last row
                if(visit[i][j] == 0 && (i == 0 || i == n-1) && grid[i][j] == 1){
                    dfs(grid, visit, i, j);
                }
                // checking first and last column
                if(visit[i][j] == 0 && (j == 0 || j == m-1) && grid[i][j] == 1){
                    dfs(grid, visit, i, j);
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] ==1 && visit[i][j] == 0) ans++;
            }
        }
        return ans;
    }
    void dfs(int [][] grid, int [][] visit, int i, int j){
        int n = grid.length;
        int m = grid[0].length;

        if(i < 0 || i >= n || j < 0 || j >= m || visit[i][j] == 1 || grid[i][j] == 0) return;
        visit[i][j] = 1;

        dfs(grid, visit, i-1, j); // up
        dfs(grid, visit, i+1, j); // down
        dfs(grid, visit, i, j-1); // left
        dfs(grid, visit, i, j+1); // right
    }
}
