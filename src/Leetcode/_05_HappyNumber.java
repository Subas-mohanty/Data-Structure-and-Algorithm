package Leetcode;

public class _05_HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(112));
    }
    static public boolean isHappy(int n) {
        int slow=n;
        int fast=n;

        // can't use while loop cause the initial condition will always be true and it will never terminate, cause we have taken fast=slow=n
        do {
            slow=sumSq(slow); // move slow pointer by one step ahead
            fast=sumSq(sumSq(fast)); // move fast pointer by two step
        }while(slow!=fast);

        if (slow == 1) {
            return true;
        }
        return false;
    }
    static int sumSq(int n){
        int sum=0;
        while (n != 0) {
            int rem=n%10;
            int sq=rem*rem;
            n=n/10;
            sum+=sq;
        }
        return sum;
    }
}
