package Leetcode.Heap;
import java.util.PriorityQueue;
//https://leetcode.com/problems/maximum-average-pass-ratio/submissions/1479589887/?envType=daily-question&envId=2024-12-15
class _1792_max_avg_pass_ratio {
    public static void main(String[] args) {
        int [][] arr = {{2,4}, {3,9}, {4,5}, {2,10}};
        int k = 4;
        System.out.println(maxAverageRatio(arr, k));
    }
    // TC : O(n + e * log n + n)
    // SC : O(n)
    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        // keeping double [] for easy calculation
        PriorityQueue<double []> pq = new PriorityQueue<>((a,b)->{
            // sorting based on increase in pass rate, after adding one student, which class pass rate is bigger, that should come first, not the class that has the highest pass rate after adding a student, we need the difference
            double one = ((a[0] + 1) / (a[1] + 1)) - (a[0] / a[1]);
            double two =((b[0] + 1) / (b[1] + 1)) - (b[0] / b[1]);
            return Double.compare(two, one);
        });

        // O(n)
        for(int [] a : classes) pq.offer(new double[]{a[0], a[1]});

        // O(e * log n) -> pq will have all the elements of the classes array
        while(extraStudents-- > 0){
            double [] arr = pq.poll();
            pq.offer(new double[]{arr[0] + 1, arr[1] + 1});
        }

        // O(n)
        double sum = 0;
        for(double [] a : pq){
            sum += a[0]/a[1];
        }
        return sum / classes.length;
    }
}