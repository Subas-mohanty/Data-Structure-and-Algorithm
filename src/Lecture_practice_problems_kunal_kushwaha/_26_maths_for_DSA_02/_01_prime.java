package Lecture_practice_problems_kunal_kushwaha._26_maths_for_DSA_02;

public class _01_prime {
    public static void main(String[] args) {
//        int n=20;
//        for (int i = 2; i < n; i++) {
//            System.out.println(i+" "+isPrime(i));
//        }
//        System.out.println(isPrime(4));

        int n=20;
        System.out.println("All the prime numbers less than "+ n +" are :");
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }
    static boolean isPrime(int n){
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n) ; i++) {
            if (n % i == 0) {
                return false; // not prime
            }
        }
        return true; // prime
    }
}
