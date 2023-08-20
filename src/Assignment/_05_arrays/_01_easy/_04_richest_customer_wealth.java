package Assignment._05_arrays._01_easy;
// https://leetcode.com/problems/richest-customer-wealth/
public class _04_richest_customer_wealth {
    public static void main(String[] args) {
        int [][] accounts={
                {1,2,3},
                {3,2,1},
                {87,76}
        };
        int max=0;

        for (int i = 0; i < accounts.length; i++) {
            int sum=0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum+=accounts[i][j];
            }
            if(sum>max){
                max=sum;
            }
        }
        System.out.println(max);
    }
}
