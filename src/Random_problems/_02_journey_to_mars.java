package Random_problems;

import java.util.Scanner;

public class _02_journey_to_mars {
    // TC : O(log n) --> binary exponentiation
    // SC : O(1)
    static final double LOG2 = Math.log10(2);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            long N = sc.nextLong();
            int K = sc.nextInt();

            // total no of ways to reach n is 2^(n - 1)
            // | n | Paths from 0 to n                  | Ways            | Explanation |
            // | - | ---------------------------------- | --------------- | ------------ |
            // | 1 | [0->1]                             | 1               | only one step |
            // | 2 | [0->1->2], [0->2]                  | 2               | two ways      |
            // | 3 | [0->1->2->3], [0->1->3], [0->2->3], [0->3] | 4        |               |
            // | 4 | 8 ways                             | pattern doubles |               |

            // Compute last K digits
            long mod = (long) Math.pow(10, K);
            long lastK = modPow(2, N - 1, mod);
            // found the number 2^(n - 1)
            // when we mod it with 10^k, we will get the remainder as k digit number and that is the last k digit that we need

            // Compute first K digits
            // log10(2^n-1) = (n - 1) log10 2 --> this gives the logarithmic value of log10 2^(n - 1)
            // now we will find the Integer part and the fractional part from this value
            // lets say log10(2^n-1) = exp
            // exp = i + f --> integer part + fractional part
            // log10(2^n-1) = i + f
            // solving the log (taking to the right)
            // => 2^(n - 1) = 10^(i + f)
            // => 2^(n - 1) = 10^i * 10^f
            // 10^i just sets the magnitude (it means the number has i + 1 digits)
            // and 10^f is the decimal value between 0 and 1, which actually contains the leading digits

            //  | True number | log10 form | f        | 10^f |
            //  | ----------- | ---------- | -------- | ---- |
            //  | 512         | 2.709...   | 0.709... | 5.12 |
            //  | 32768       | 4.515...   | 0.515... | 3.27 |

            // we can see from the above table that 10^f gives the leading digits, we just have to take the first k digit
            // so if we multiply the number with 10^(k - 1), why k - 1 and not k ?
            // because we already have one digit before the decimal, and now we only need k - 1 digit and when we multiply the number with 10^(k - 1) we will get the exact k digits from the beginning

            double exp = (N - 1) * LOG2; // --> this gives the logarithmic value
            double frac = exp - Math.floor(exp); // we get the fractional value only by subtracting the integer part from it
            long firstK = (long) Math.pow(10, frac + K - 1);

            // here we return the sum of firstK and lastK digits as asked in the question
            System.out.println(firstK + lastK);
        }
        sc.close();
    }

    // Fast modular exponentiation
    // binary exponentiation with mod
    static long modPow(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}
