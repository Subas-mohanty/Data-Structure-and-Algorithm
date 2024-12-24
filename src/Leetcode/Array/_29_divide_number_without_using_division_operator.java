package Leetcode.Array;

// https://leetcode.com/problems/divide-two-integers/description/

public class _29_divide_number_without_using_division_operator {
    public static void main(String[] args) {
        int x = 2147483647;
        int y = -1;
        System.out.println(divide(x, y));
    }

    public static int divide2(int x, int y) {
        long dividend = x;
        long divisor = y;
        long count = 0;
        boolean neg = false;
        if (divisor < 0 && dividend < 0) ;
        else if (divisor < 0 || dividend < 0) neg = true;

        divisor = Math.abs(divisor);
        dividend = Math.abs(dividend);

        while (dividend >= divisor) {
            if (dividend == 0) break;
            count++;
            dividend -= divisor;
        }
        if (!neg && count > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (neg && count > Integer.MAX_VALUE) return Integer.MIN_VALUE;
        return neg ? -(int) count : (int) count;
    }

    public static int divide(int dividend, int divisor){
        if(dividend == divisor) return 1;
        if(dividend == 0) return 0;
        boolean neg = false;

        if(dividend < 0 && divisor >= 0) neg = true;
        if(dividend >= 0 && divisor < 0) neg = true;

        // it is wrong, long n = Math.abs(dividend);
       long d = Math.abs((long)divisor);
       long n = Math.abs((long)dividend);

        long ans = 0;
        while(n >= d){
            int count = 0;
            while(n >= (d << (count+1))) {
                count++;
            }
//            ans += (int)Math.pow(2, count+1);
            ans += 1 << count;
            n -= (d << count);
        }

//        if(!neg && ans >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        // we can write the above statement like this also, because when we left shift a number it becomes power of two
        if(!neg && ans == (1 << 31)) return Integer.MAX_VALUE;

        return neg ? -(int)ans : (int)ans;
    }
}