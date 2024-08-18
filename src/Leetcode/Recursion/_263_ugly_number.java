package Leetcode.Recursion;
//https://leetcode.com/problems/ugly-number/
public class _263_ugly_number {


    // TLE solution
    // TC : O(n/2 * sqrt(n))
    public boolean isUgly2(int n) {
        if(n <= 0) return false;
        if(n < 2) return true;
        for(int i = 2; i <= n/2; i++){
            if(n % i == 0 && isPrime(i) && i > 5){
                return false;
            }
        }
        if(isPrime(n) && n > 5) return false;
        return true;
    }
    public boolean isPrime(int n){
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    // TC : O(log n)
    public boolean isUgly(int n) {
        // negative numbers are not ugly number
        if(n < 0) return false;

        // If the number is 0, it's not considered an ugly number
        if(n == 0) return false;

        // If the number is between 1 and 3, it's inherently an ugly number
        if(n > 0 && n <= 3) return true;

        // If divisible by 2, recursively check the result of dividing by 2
        if(n % 2 == 0) return isUgly(n/2);
        // If divisible by 3, recursively check the result of dividing by 3
        if(n % 3 == 0) return isUgly(n/3);
        // If divisible by 5, recursively check the result of dividing by 5
        if(n % 5 == 0) return isUgly(n/5);

        // If not divisible by 2, 3, or 5, it's not an ugly number
        return false;
    }
}
