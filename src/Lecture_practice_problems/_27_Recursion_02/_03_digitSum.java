package Lecture_practice_problems._27_Recursion_02;

public class _03_digitSum {
    public static void main(String[] args) {
        System.out.println(sum(2039));
    }
    static int sum(int n){
        if (n == 0) {
            return 0;
        }
        return (n%10) + sum(n/10); // first it will do n%10 , that will give the last digit than we are calling the recursive call with n/10 which means , now the number is reduced by 1 digit
    }
}
