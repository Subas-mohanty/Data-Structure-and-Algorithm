package Leetcode.Math;
//https://leetcode.com/problems/harshad-number/description/
public class _3099_harshad_number {

    public static void main(String[] args) {
        int x = 23;
        System.out.println(sumOfTheDigitsOfHarshadNumber(x));
    }
    public static  int sumOfTheDigitsOfHarshadNumber(int x) {
        int num = x;
        int sum = 0;
        while(num > 0){
            int last = num % 10 ;
            sum += last;
            num = num/10;
        }
        if(x % sum == 0) return sum;
        else return -1;
    }
}
