package Programming_Concepts;

// what is modular nCr and Fermat's little theorem ?
// formula for (a * b) % m = [(a % m) * (b % m)] % m
// but for (a/b) % m, we don't have any formula like that
// so we do this : (a * b^-1) % m
// now what is b^-1 ? b^-1 is the modular inverse of b % m
// how do we find this ?
// the formula is : (b * x) % m = 1, where x is the modular inverse of b % m
// how to find this, brute force will be check for 1,2,3.... and so on
// optimal and fermat's little theorem is, x = pow(b, m-2) % m, where x is the modular inverse of b % m

public class _17_modular_nCr_Fermat_little_theorem {
    // TC : O(log m + n) --> for findPow + factorial(with precompute it will be O(1)
    // SC : O(1)
    public int modularnCr(int n, int r, int MOD){
        if(r < 0 || r > n) return 0; // if r > n, we can't choose r values from n no of values so returning 0

        // nCr = n! / (n! * (n-r)!)
        long a = factorial(n);
        long b = (factorial(n) * factorial(n - r)) % MOD;

        return (int) a * findPow(b, MOD - 2) % MOD;
    }

    int findPow(long base, int pow){
        // write the binary exponentiation code
        if(pow == 1) return (int) base;
        int half = findPow(base, pow/2);
        if(pow % 2 == 0) return half * half;
        return half * half * (int) base;
    }
    // precompute this and store this in an array with a single loop for o(n) time
    long factorial(int num){
        if (num == 0 || num == 1) return 1;
        return num * factorial(num - 1);
    }
}
