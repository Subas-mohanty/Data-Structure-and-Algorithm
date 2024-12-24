package Lecture_practice_problems_kunal_kushwaha._26_maths_for_DSA_02;

public class _04_NewtonSQRT {
    public static void main(String[] args) {

        System.out.println(sqrt(40));
    }
    static double sqrt(double n){
        double x=n;
        double root;
        while (true) {
            root=0.5*(x+(n/x));
            if(Math.abs(root-x)<0.5){
                break;
            } else{
                x=root;
            }
        }
        return root;
    }
}
