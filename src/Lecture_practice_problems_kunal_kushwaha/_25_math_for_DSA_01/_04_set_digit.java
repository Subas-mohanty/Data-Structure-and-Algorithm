package Lecture_practice_problems_kunal_kushwaha._25_math_for_DSA_01;

public class _04_set_digit {
    public static void main(String[] args) {
            int num=25;
            findBit(num,3); // this will give the third digit indexing from 1

//            int temp = num^11;
//        System.out.println(temp);
//        System.out.println(Integer.toBinaryString(num));
//        System.out.println(Integer.toBinaryString(temp));

        }
        static void findBit(int num,int digit) {
        int mask= 1<<digit-1; // This will set the mask = 100 (the number of zeros on the right side will be equal to number of ith digit from right of the num
            // And then:
            // for ex,
//            1011 -> num
//            0100 ->mask
//            1111 -> this is the num after setting the ith set bit and by doing OR with it we get the num

            int mask2 = ~(1<<digit-1); // ~ performs one's compliment
            System.out.println(mask);
            System.out.println(mask2);
            int result=(num|mask);
            int result2 = (num & mask2);
            System.out.println(result + " " + result2);
        }
}
