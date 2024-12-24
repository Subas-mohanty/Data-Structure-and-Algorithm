package Lecture_practice_problems_kunal_kushwaha._27_Recursion_02;

public class _04_digitProduct {
    public static void main(String[] args) {
        System.out.println(product(56));
    }
    static int product(int n){
        if (n%10 == n) {
            return n;
        }
        return (n%10) * product(n/10); // first it will do n%10 , that will give the last digit than we are calling the recursive call with n/10 which means , now the number is reduced by 1 digit
    }
}
