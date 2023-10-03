package Leetcode;

public class _15_ArrangeCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins2(1804289383));
    }
    public static int arrangeCoins(int n) {
        int num=n;
        int i=1;
        while(num>=i){
            num=num-i;
            i++;
        }
        // when num is less than i, that means till ith row all the rows are filled so at the end we return i-1 for the index
        return i-1;
    }
    public static int arrangeCoins2(int n) {
        return (int) ((- 1 + Math.sqrt((double) 1 + 8 * n))/ 2);
    }
}
