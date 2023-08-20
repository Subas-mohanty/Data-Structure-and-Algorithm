package Lecture_practice_problems._42_OOPS_06.ExceptionHandling;

public class Main {
    public static void main(String[] args) {
        int a=3;
        int b=0;
        try {
            //int c=a/b;
            int c=divide(a,b);
            System.out.println(c);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    static int divide(int a, int b) throws ArithmeticException{
        if (b == 0) {
            throw new ArithmeticException("Can't divide by zero");
        }
        return a/b;
    }
}
