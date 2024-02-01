package Dynamic_Programming_Striver;

public class _08_Ninja_Training {
    public static void main(String[] args) {
        int [][] points = {
                {1,2,5},
                {3,1,1},
                {3,3,3},
        };
        System.out.println(ninjaTraining(points.length, points));
    }
    public static int ninjaTraining(int n, int points[][]) {
        int [][] dp = new int[n+1][4];
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
            if(i != last){
                int point = points[n][i] + helper(n-1, points, i, dp);
                ans= Math.max(point, ans);
            }
        }
        return ans;
    }
}
