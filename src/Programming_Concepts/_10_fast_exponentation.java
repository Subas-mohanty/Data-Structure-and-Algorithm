package Programming_Concepts;

import java.math.BigInteger;

public class _10_fast_exponentation {
    public static void main(String[] args) {
        int base = 2;
        int pow = 290000;
        long first = System.nanoTime();
        long ans = 1;
        System.out.println(Math.log(Math.pow(10, 12)));
        BigInteger b = new BigInteger(String.valueOf(BigInteger.valueOf(ans)));
        for (int i = 0; i < pow; i++) {
            b = b.multiply(BigInteger.valueOf(base));
        }
        System.out.println(b);
        long last = System.nanoTime();
        System.out.println(last - first);

        long start = System.nanoTime();
        System.out.println(findPow(base, pow));
        long end = System.nanoTime();
        System.out.println(end - start);
    }

    static BigInteger findPow(int base, int pow){
        if(pow == 1) return BigInteger.valueOf(base);
        BigInteger half = findPow(base, pow/2);
        BigInteger ans = half.multiply(half);
        if(pow % 2 == 0) return ans;
        return ans.multiply(BigInteger.valueOf(base));
    }
}
