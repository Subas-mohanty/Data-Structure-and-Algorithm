package Assignment._10_Recursion._01_easy;

//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
public class _22_ReducedToZero {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
    }
    static int numberOfSteps(int num) {
       return helper(num,0);
    }

    private static int helper(int num, int steps) {
        if (num == 0) {
            return steps;
        }
        if (num % 2 == 0) {
            return helper(num/2,steps+1);
        }
        else
            return helper((num-1),steps+1);
    }
}
