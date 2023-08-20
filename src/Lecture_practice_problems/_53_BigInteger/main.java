package Lecture_practice_problems._53_BigInteger;

import java.math.BigDecimal;
import java.math.BigInteger;

public class main {
    public static void main(String[] args) {
        BD();
    }
    // in floating point operation double and float gives a slight error because they use the exponent and mantissa method
    static void BD(){
        double x = 0.03;
        double y= 0.04;
        // double ans = y-x;
        // System.out.println(ans);

        BigDecimal X = new BigDecimal("0.03");
        BigDecimal Y = new BigDecimal("0.04");
        BigDecimal ans = Y.subtract(X);
        // System.out.println(ans);

        BigDecimal a = new BigDecimal("456576345675.4546376");
        BigDecimal b = new BigDecimal("547634565352.986785764");

        // operations
        System.out.println(b.add(a));
        System.out.println(b.subtract(a));
        System.out.println(b.multiply(a));
        System.out.println(b.pow(2));
        System.out.println(b.negate());

        // constants
        BigDecimal con = BigDecimal.ONE;

    }
    static void Bi() {
        int a = 43;
        int b = 23;

        BigInteger c = BigInteger.valueOf(45);
        BigInteger d = new BigInteger("76866489426494163165476");
        BigInteger X = new BigInteger("4785221556076876");

        //constant
        BigInteger e = BigInteger.ZERO;
        BigInteger F = BigInteger.TEN;

//        BigInteger s = c.add(d);
//        System.out.println(s);

        // operations
        BigInteger s = d.add(X);

        BigInteger m = d.multiply(X);

        BigInteger sub = d.subtract(X);

        BigInteger div = d.divide(X);

        BigInteger rem = d.remainder(X);

        if (X.compareTo(d) < 0) {
            System.out.println("Yes");
        }
        System.out.println(factorial.fact(494509334));
    }
}
