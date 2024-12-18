package Leetcode.Stack;

import java.util.Arrays;
import java.util.Stack;
//https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/?envType=daily-question&envId=2024-12-18

public class _1475_final_price_with_special_discount {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(finalPrices(arr)));
    }

    // brute force
    // TC : O(n * n)
    // SC : O(N)
    public int[] finalPrices2(int[] prices) {
        int [] ans = prices.clone();
        int n = ans.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(prices[j] <= prices[i]){
                    ans[i] = ans[i] - prices[j];
                    break;
                }
            }
        }
        return ans;
    }

    // monotonic stack, next smaller element
    // TC : O(n + n)
    // SC : O(n)
    public static int[] finalPrices(int [] prices){
        int n = prices.length;
        Stack<Integer> stack = new Stack<>();
        int [] nse = new int[n];
        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() > prices[i]) stack.pop();
            if(!stack.isEmpty()){
                nse[i] = stack.peek();
            }
            stack.push(prices[i]);
        }
        int [] ans = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = prices[i] - nse[i];
        }
        return ans;
    }
}
