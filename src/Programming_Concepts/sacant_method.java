package Programming_Concepts;

import static Programming_Concepts._02_bisection_method.f;

public class sacant_method {
    public static void main(String[] args) {
        double x0 = 0;
        double x1 = 1;
        double e = Math.pow(10,-65);
        secant(x0, x1, e);
    }

    static int iteration = 0;
    static void secant(double x0, double x1, double e) {
        double x2;
        do{
            x2=((x0*f(x1))-(x1*f(x0))) / (f(x1)-f(x0));
            x0=x1;
            x1=x2;
            iteration++;
        }while(Math.abs(f(x0)-f(x1))>=e);
        System.out.println("Root of the" +
                " given equation=" + x1);

        System.out.println("No. of "
                + "iterations = " + iteration);

    }
//    static void secant(double x0, double x1, double e) {
//        double x2;
//        for (int i = 0; i < iteration; i++) {
//            x2=((x0*f(x1))-(x1*f(x0))) / (f(x1)-f(x0));
//            x0=x1;
//            x1=x2;
//            System.out.printf("x%d = %.50f\n",i,x2);
//            if(Math.abs(f(x0)-f(x1))<=e){
//                break;
//            }
//        }
//    }
}
