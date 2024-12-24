package Lecture_practice_problems_kunal_kushwaha._25_math_for_DSA_01;

public class _09_power {
    public static void main(String[] args) {
        int base=2;
        int power=3;
        int ans=1;
        while(power>0) {
            if ((power&1)==1) {
                ans*=base;
            }
            base*=base;
            power=power>>1;
        }
        System.out.println(ans);
    }
}
