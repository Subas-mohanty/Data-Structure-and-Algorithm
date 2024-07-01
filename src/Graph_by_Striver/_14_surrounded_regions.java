package Graph_by_Striver;

public class _14_surrounded_regions {

    public static void main(String[] args) {
        char [][] arr =  {{'X', 'X', 'X', 'X'},
                {'O', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}};
        char [][] ans = fill(arr.length, arr[0].length, arr);
        for(char [] a : ans){
            for(char x : a){
                System.out.println(a + " ");
            }
            System.out.println();
        }
    }
    static char[][] fill(int n, int m, char [][] arr){
        int [][] visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // checking first and last row
               if(visit[i][j] == 0 && (i == 0 || i == n-1) && arr[i][j] == 'O'){
                   dfs(arr, visit, i, j);
               }
               // checking first and last column
                if(visit[i][j] == 0 && (j == 0 || j == m-1) && arr[i][j] == 'O'){
                    dfs(arr, visit, i, j);
                }
            }
        }
        // updating all O to X
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               if(visit[i][j] == 0  && arr[i][j] == 'O') arr[i][j] = 'X';
            }
        }
        return arr;
    }
    static public void dfs(char [][] arr, int [][] visit, int i, int j){
        int n = arr.length;
        int m = arr[0].length;

//        int delrow[] = {-1, 0, +1, 0};
//        int delcol[] = {0, 1, 0, -1};
//        for (int k = 0; k < 4; k++) {
//            int nrow = i + delrow[k];
//            int ncol = j + delcol[k];
//            // check for valid coordinates and unvisited Os
//            if(nrow >=0 && nrow <n && ncol >= 0 && ncol < m
//                    && visit[nrow][ncol] == 0 && arr[nrow][ncol] == 'O') {
//                dfs(arr, visit, nrow, ncol);
//            }

        // checking for out of bound cases
        if (i < 0 || i >= n || j < 0 || j >= m || visit[i][j] == 1 || arr[i][j] != 'O') {
            return;
        }

        // Mark the cell as visited
        visit[i][j] = 1;

        // Perform DFS in all four directions
        dfs(arr, visit, i - 1, j); // up
        dfs(arr, visit, i + 1, j); // down
        dfs(arr, visit, i, j - 1); // left
        dfs(arr, visit, i, j + 1); // right
    }
}
