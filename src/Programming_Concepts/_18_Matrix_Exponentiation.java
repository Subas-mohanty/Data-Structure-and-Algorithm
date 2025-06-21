package Programming_Concepts;
import java.util.Scanner;

// finding fibonacci in log(n) time with matrix exponentiation
// TC : O(log n)
//https://www.youtube.com/watch?v=gX8KaRlkoN0

public class _18_Matrix_Exponentiation {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the value of n : ");
//        int n = scanner.nextInt();
//        long ans = fibonacci(n);
//        System.out.println(n + "th fibonacci = " + ans);

        for(int i = 0; i < 100; i++){
            long ans = fibonacci(i);
            System.out.println(i + "th fibonacci = " + ans);
        }
    }

    public static long fibonacci(int n){
        if(n == 0 || n == 1) return n;

        long [][] T = {{1,1}, {1,0}}; // T(Transformation matrix) is a square matrix, whose dimension will be degree * degree
        long [][] mat = {{1},{0}};

        long [][] result = matrixExp(T, n-1);

//        long ans = (result[0][0] * mat[0][0] + result[1][1] * mat[1][0]); // this also works
        long [][] ansMat = matMul(result, mat);
        long ans = ansMat[0][0]; // f(n) resides at [0][0] and f(n-1) at [1][0]

        return ans;
    }

    private static long[][] matrixExp(long[][] base, int exp) {
        if(exp == 1) return base;

        long [][] half = matrixExp(base, exp/2);
        long [][] res = matMul(half, half);
        if(exp % 2 == 1) res = matMul(res, base);
        return res;
    }

    // this simply multiply two matrices, O(n^3), but here n is 2, so it is constant
    // why n = 2 ? because dimension of T matrix is 2*2, because the recurrence relation for fibonacci has degree = 2
    private static long[][] matMul(long[][] first, long[][] second) {
        int n = first.length;
        int m = second[0].length;
        int o = second.length;
        long[][] res = new long[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < o; k++){
                    res[i][j] = (res[i][j] + first[i][k] * second[k][j]) % MOD; // MOD is used to avoid overflow
                }
            }
        }
        return res;
    }
}
