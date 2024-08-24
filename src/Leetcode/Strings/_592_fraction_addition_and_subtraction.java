package Leetcode.Strings;

//https://leetcode.com/problems/fraction-addition-and-subtraction/?envType=daily-question&envId=2024-08-23
//https://www.youtube.com/watch?v=Uh-KE4D2MOM

public class _592_fraction_addition_and_subtraction {
    public static void main(String[] args) {
        String s = "-1/2+1/2";
        System.out.println(fractionAddition(s));
    }


    public static String fractionAddition(String s) {
        int numerator = 0;
        int denominator = 1;
        int n = s.length();
        int i = 0;

        while(i < n){
            char ch = s.charAt(i);
            int currNumerator = 0;
            int currDenominator = 0;

            boolean isNeg = ch == '-';

            // skipping + or - sign
            if(ch == '+' || ch == '-') i++;

            // build the numerator
            while(i < n && Character.isDigit(s.charAt(i))){
                int val = s.charAt(i) - '0';
                currNumerator = currNumerator * 10 + val;
                i++;
            }

            // if there is a negative sign then make the number as negative
            if(isNeg) currNumerator = -currNumerator;
            i++; // for the divisor "/" symbol

            // build the denominator
             while(i < n && Character.isDigit(s.charAt(i))){
                int val = s.charAt(i) - '0';
                currDenominator = currDenominator * 10 + val;
                i++;
             }

             // do the calculation
             numerator = (numerator * currDenominator) + (denominator*currNumerator);
             denominator = denominator * currDenominator;
        }
        int gcd = findGcd(Math.abs(numerator), denominator);
        numerator /= gcd;
        denominator /= gcd;

        return numerator + "/" + denominator;
    }

    private static int findGcd(int numerator, int denominator) {
        int gcd = 1;
        for(int i = 1; i <= Math.max(numerator, denominator); i++){
            if(numerator % i == 0 && denominator % i == 0) gcd = i;
        }
        return gcd;
    }

    // Helper method to calculate the greatest common divisor (GCD) using Euclidean algorithm
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
