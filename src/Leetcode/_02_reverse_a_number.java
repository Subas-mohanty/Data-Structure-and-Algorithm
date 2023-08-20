package Leetcode;

public class _02_reverse_a_number {
    public static void main(String[] args) {
        System.out.println(reverse(-78547));
    }
    static int reverse(int x) {
        long finalNum=0;
        while(x!=0){
            int lastDigit=x%10;
            finalNum=finalNum*10;
            finalNum+=lastDigit;
            // finalnNum=finalNum*10;
            x/=10;
        }
        // Here we are using finalNum instead of x cause maybe there can be an input where x is in the integer range but its reverse is not i.e, 1534236469
        if(finalNum<Integer.MIN_VALUE || finalNum>Integer.MAX_VALUE){
            return 0;
        }
        // check case for negative numbers
        if(x<0){
            return (int)(0-finalNum); // we can also use "-finalNum"
        }
        return (int)finalNum;
    }
}
