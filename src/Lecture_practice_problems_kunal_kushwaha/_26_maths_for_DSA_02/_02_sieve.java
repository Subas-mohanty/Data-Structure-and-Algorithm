package Lecture_practice_problems_kunal_kushwaha._26_maths_for_DSA_02;

public class _02_sieve {
    public static void main(String[] args) {
        int n=10;
        boolean [] primes=new boolean[n+1];
        sieve(n,primes);
    }
    static void sieve(int n,boolean [] primes){
        for (int i = 2; i*i <= n ; i++) {
            if(!primes[i]){
                for (int j = i*2; j < n; j+=i) {
                    primes[j]=true;
                }
            }
        }
        for (int i = 2; i <  n; i++) {
            if(!primes[i]){
                System.out.print(i+ " ");
            }
        }
    }
}
