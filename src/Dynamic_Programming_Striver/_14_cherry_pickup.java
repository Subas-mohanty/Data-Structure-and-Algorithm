package Dynamic_Programming_Striver;

public class _14_cherry_pickup {
    public static void main(String[] args) {
        int [][] grid = {
                {2,3,1,2},
                {3,4,2,2},
                {5,6,3,5}
        };

        int lastCol = grid[0].length;
        System.out.println(ninja(grid, 0, 0,lastCol-1));
    }
    public static int ninja(int [][] grid, int i, int j, int j2){
        int n = grid.length;
        int m = grid[0].length;


        // out of bound base case
        if(j<0 || j >= m || j2 < 0 || j2 >= m) return (int)-1e8;

        // destination base case
        if(i == n-1){
            if(j == j2) return grid[i][j];
            else return grid[i][j] + grid[i][j2];
        }

        int max = (int)-1e8;
        // we have total 9 possibilities , because for every movement in i, j can move in 3 direction and i and total 3 option down, left diag and right diag
        for(int dj = -1; dj <= 1; dj++){
            for(int dj2 = -1; dj2 <= 1; dj2++){
                int dji = j+dj;
                int dj2i = j2 + dj2;
                int val = 0;

                if(j == j2) val = grid[i][j] ;
                else val = grid[i][j] + grid[i][j2] ;
                val += ninja(grid, i+1, j+dj, j2+dj2);
                max = Math.max(val, max);
            }
        }
        return max;
    }
}
