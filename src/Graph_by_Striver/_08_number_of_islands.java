package Graph_by_Striver;
//https://leetcode.com/problems/number-of-islands/
public class _08_number_of_islands {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length ==0) return 0;

        int cnt = 0;
        int n = grid.length;
        int m = grid[0].length;

        int [][] visited = new int[n][m];
        for(int i = 0; i <n ; i++){
            for(int j = 0; j < m; j++){
                // for every element, if it has not been visited and it's a land we are doing dfs
                if(visited[i][j] == 0 && grid[i][j] == '1'){
                    cnt++;
                    dfs(visited, grid, i, j);
                }
            }
        }
        return cnt;
    }

    public void dfs(int [][] visited, char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] == 1 || grid[i][j] == '0') return;

        visited[i][j] = 1; // mark as visited
        // we don't have to visit all the 8 direction because every element can visit to their four side and we can get all the connected areas
        dfs(visited, grid, i-1, j); // up
        dfs(visited, grid, i+1, j); // down
        dfs(visited, grid, i, j+1); // right
        dfs(visited, grid, i, j-1); // down
    }
}
