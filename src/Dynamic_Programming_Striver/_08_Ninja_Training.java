package Dynamic_Programming_Striver;
import java.util.Arrays;

public class _08_Ninja_Training {
  public static void main(String[] args) {
    int [][] points = {
      {10,40,70},
      {20,50,80},
      {30,60,90},
    };
    System.out.println(ninjaTraining(points.length, points));
  }
  public static int ninjaTraining(int n, int[][] points) {
    int [][] dp = new int[n+1][4];
    for(int [] row : dp){
      Arrays.fill(row, -1);
    }
    return helper(n-1, points, 3, dp);
  }
  public static int helper(int n, int [][] points , int last, int [][] dp){
    if(n==0){
      int max =0;
      for(int i =0 ; i< 3; i++){
        if(i != last){
          max = Math.max(max, points[n][i]);
        }
      }
      return max;
    }
    int ans = 0;
    for(int i =0; i< 3; i++){
      if(i != last && dp[n][last] != -1){
        return dp[n][last];
      }
      if(i != last){
        int point = points[n][i] + helper(n-1, points, i, dp);
        ans= Math.max(point, ans);
      }
    }
    return dp[n][last] = ans;
  }
}
