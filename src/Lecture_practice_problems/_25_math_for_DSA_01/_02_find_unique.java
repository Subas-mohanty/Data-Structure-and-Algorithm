package Lecture_practice_problems._25_math_for_DSA_01;

public class _02_find_unique {
    public static void main(String[] args) {
        int [] arr={2,3,4,3,2,5,4};
        System.out.println(findUnique(arr));
        System.out.println(5^6^5); // 5^5=0 and 5^6=3 , so when we combine them it runs like 5^6=3^5=6
    }

    private static int findUnique(int[] arr) {
        int ans=0;
        for (int n :arr){
            ans^=n; // ans=ans^n;
            // This is working internally like this
//    if  11=1011
//        10=1010
//      -----------
//           0001   // this is doing xor operation on each digit one by one and returning the resultant as whole, and its of integer type
        }
        return ans;
    }
}
