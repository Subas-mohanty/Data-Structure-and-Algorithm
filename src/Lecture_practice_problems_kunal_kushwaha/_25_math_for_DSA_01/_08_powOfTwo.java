package Lecture_practice_problems_kunal_kushwaha._25_math_for_DSA_01;
//https://leetcode.com/problems/power-of-two/submissions/1260550809/
public class _08_powOfTwo {
    public static void main(String[] args) {
        int n=32;
        // but why this is true
        // any number which is power of two, will only have one set bit, and its previous number will have no bit common with it, so if no common bit is present then it's a power of two
        boolean ans=(n&(n-1))==0;
        if(n==0){
            ans=false;
        }
        System.out.println(ans);
    }
    public boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        } else{
            while(n%2==0){
                n/=2;
            } if(n==1){
                return true;
            }
        }
        return false;
    }

    public boolean isPowerOfTwo2(int n) {
        if(n == 1) return true;
        if(n < 1) return false;
        // if number is odd other than 1 , then it is not a power of two
        if(n % 2 != 0) return false;
        return isPowerOfTwo(n/2);
    }
    public boolean isPowerOfTwo3(int n) {
        // any number which is a power of two has only one set bit, and we are checking that
        // Ex : 1 in binary is 0001
        //2 in binary is 0010
        //4 in binary is 0100
        //8 in binary is 1000

        int count = 0;
        while( n > 0){
            int last = n & 1;
            if(last == 1) count++;
            n = n>>1;
        }
        return count == 1;
    }
}
