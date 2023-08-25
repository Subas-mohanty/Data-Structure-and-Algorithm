package Programming_Concepts;

import java.util.function.Function;

public class _02_bisection_method {
    public static void main(String[] args) {
//        Function<Double, Double> targetFunction = x -> x * x + 12 * x + 6;

        double start = chooseA();
        double end = chooseB();
        double root = bisectionMethod(start, end,100);
        System.out.println("Approximate root: " + root);
    }

    private static double chooseA() {
        double x=1;
        double fx=f(x);
        double fnext=f(x+1);
        if(fx<fnext){
            while(fx<0){
                x++;
            }
            return x;
        }
        else{
            while(fx>0){
                x++;
            }
            return x;
        }
    }
    private static double chooseB() {
        double x=1;
        double fx=f(x);
        double fnext=f(x+1);
        if(fx>fnext){
            while(fx>0){
                x++;
            }
            return x;
        }
        else{
            while(fx<0){
                x++;
            }
            return x;
        }
    }

    public static double bisectionMethod(double a, double b, int maxIterations) {
        if (f(a) * f(b) >= 0) {
            throw new IllegalArgumentException("Function values at interval endpoints must have opposite signs.");
        }

        for (int i = 0; i < maxIterations; i++) {
            double c = (a + b) / 2;
            double fC = f(c);

            if ((fC) == 0) {
                return c;
            }
//            if (f(a) * fC < 0) {
//                b = c;
//            } else {
//                a = c;
//            }
            if(f(c)<0){
                a=c;
            }
            else{
                b=c;
            }
        }

        return (a + b) / 2;
    }
    public static double f(double x){
        return 2*(x * x * x) - 2*x - 5;
    }
}
