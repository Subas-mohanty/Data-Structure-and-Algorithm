package Lecture_practice_problems._42_OOPS_06_Generics.ExceptionHandling;

public class Main {
    public static void main(String[] args) {
        int a=3;
        int b=0;
        try {
//            divide(a, b);
            // mimicing
            String name = "subas";
            if (name.equals("subas")) {
                throw new MyException("name is subas");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("normal exception");
        } finally {
            System.out.println("this will always execute");
        }
    }
    static int divide(int a, int b) throws ArithmeticException{
        if (b == 0) {
            throw new ArithmeticException("Can't divide by zero");
        }
        return a/b;
    }
}
