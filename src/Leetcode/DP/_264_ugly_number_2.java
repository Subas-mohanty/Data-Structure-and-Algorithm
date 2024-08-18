package Leetcode.DP;
//https://leetcode.com/problems/ugly-number-ii/?envType=daily-question&envId=2024-08-18

//https://www.youtube.com/watch?v=jRacRh6x4go
public class _264_ugly_number_2 {


    // TLE solution
    // TC : O(n log n)
    public int nthUglyNumber2(int n) {
        int num = 1;
        while (n != 0) {
            if (isUgly(num)) {
                n--;
            }
            num++;
        }
        return num - 1;
    }

    public boolean isUgly(int n) {
        // negative numbers are not ugly number
        if (n < 0) return false;

        // If the number is 0, it's not considered an ugly number
        if (n == 0) return false;

        // If the number is between 1 and 3, it's inherently an ugly number
        if (n > 0 && n <= 3) return true;

        // If divisible by 2, recursively check the result of dividing by 2
        if (n % 2 == 0) return isUgly(n / 2);
        // If divisible by 3, recursively check the result of dividing by 3
        if (n % 3 == 0) return isUgly(n / 3);
        // If divisible by 5, recursively check the result of dividing by 5
        if (n % 5 == 0) return isUgly(n / 5);

        // If not divisible by 2, 3, or 5, it's not an ugly number
        return false;
    }


    // optimal solution
    // TC : O(n)
    // SC : O(n)
    
    /*
    We have an array k of first n ugly number. We only know, at the beginning, the first one, which is 1. Then

    k[1] = min( k[0]x2, k[0]x3, k[0]x5). The answer is k[0]x2. So we move 2's pointer to 1. Then we test:

    k[2] = min( k[1]x2, k[0]x3, k[0]x5). And so on. Be careful about the cases such as 6, in which we need to forward both pointers of 2 and 3.
    */
    public int nthUglyNumber(int n) {
        int[] t = new int[n + 1];
        // t[i] = ith Ugly number;
        // we will return t[n] = nth ugly number

        t[1] = 1; // 1st Ugly number

        int i2 = 1; // i2th Ugly number
        int i3 = 1; // i3rd Ugly number
        int i5 = 1; // i5th Ugly number

        for (int i = 2; i <= n; i++) {
            int i2th_ugly = t[i2] * 2;
            int i3rd_ugly = t[i3] * 3;
            int i5th_ugly = t[i5] * 5;

            t[i] = Math.min(Math.min(i2th_ugly, i3rd_ugly), i5th_ugly);

            if (t[i] == i2th_ugly) {
                i2++;
            }

            if (t[i] == i3rd_ugly) {
                i3++;
            }

            if (t[i] == i5th_ugly) {
                i5++;
            }
        }

        return t[n];
    }
}
