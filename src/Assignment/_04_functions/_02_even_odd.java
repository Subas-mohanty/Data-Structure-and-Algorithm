package Assignment._04_functions;

public class _02_even_odd {
    public static void main(String[] args) {
        boolean ans=evenOdd(64);
        System.out.println(ans);
    }
    static boolean evenOdd(int num){
        if (num % 2 == 0) {
            return true;
        }
        return false;
    }
}
