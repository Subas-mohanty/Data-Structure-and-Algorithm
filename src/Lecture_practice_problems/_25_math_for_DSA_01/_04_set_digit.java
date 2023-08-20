package Lecture_practice_problems._25_math_for_DSA_01;

public class _04_set_digit {
    public static void main(String[] args) {
            int num=100;
//            System.out.println(findBit(num,2));
            // not working properly
            findBit(num,2);
        }
        static void findBit(int num,int digit) {
        int mask=1<<digit; // This will set the mask = 100 (the number of zeros on the right side will be equal to number of ith digit from right of the num
            // And then:
            // for ex,
//            1011 -> num
//            0100 ->mask
//            1111 -> this is the num after setting the ith set bit and by doing OR with it we get the num

            System.out.println(mask);
            int result=(num|mask)|1;
            System.out.println(result);
        }
}
