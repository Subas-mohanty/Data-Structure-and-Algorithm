package Assignment._04_functions;

public class _07_prime_or_not {
    public static void main(String[] args) {
        int n=1601;
        int ans=isPrime(n);
        System.out.println(ans);
    }
    static int isPrime(int N){
        if(N==0 || N==1){
            return 0;
        }
        for(int i=2;i<N/2;i++){
            if(N%i==0){
                return 0;
            }
        }
        return 1;
    }
}
