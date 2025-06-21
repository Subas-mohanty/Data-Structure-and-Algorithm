class Solution {
    void main(){
        for(int i = 2; i < 10; i++){
            System.out.print(fun(i) + " ");
        }
    }
    public int fun(int n){
        int [][] matrix = {{1,1}, {1,0}};
        int [][] base = {{1}, {0}};
        int [][] powMatrix = power(matrix, n-1);
        int [][] res = multiply(powMatrix, base);
        return res[0][0];
    }
    int [][] power(int [][] matrix, int b){
        if(b == 0){
            int [][] identity = {{1,0}, {0,1}};
            return identity;
        }
        if(b == 1) return matrix;
        int [][] half = power(matrix, b/2);
        int [][] res = multiply(half, half);
        if(b % 2 ==1) res = multiply(res, matrix);
        return res;
    }
    int [][] multiply(int [][] matrix, int[][] second){
        int n = matrix.length;
        int m = second.length;
        int o = second[0].length;
        int [][] ans = new int[n][o];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < o; j++){
                int sum = 0;
                for(int k = 0; k < m; k++){
                    sum += matrix[i][k] * second[k][j];
                }
                ans[i][j] = sum;
            }
        }
        return ans;
    }
}