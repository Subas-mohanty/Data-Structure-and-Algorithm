package Assignment._08_Strings._02_medium;

import java.math.BigInteger;

//https://leetcode.com/problems/multiply-strings/
public class _09_String_multiply {
    public static void main(String[] args) {
        String ans=multiply("6913259244","71103343");
        System.out.println(ans);
    }
    static String multiply(String num1, String num2) {
        long no1=Long.parseLong(num1);
        long no2=Long.parseLong(num2);
        long ans=no1*no2;
//        ans=BigInteger.valueOf(ans);
        return Long.toString(ans);
    }
}
