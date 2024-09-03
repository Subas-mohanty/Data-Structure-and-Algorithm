package Leetcode.Strings;
//https://leetcode.com/problems/sum-of-digits-of-string-after-convert/?envType=daily-question&envId=2024-09-03
public class _1945_sum_of_digits {

    // TC : O(n * k)
    // SC : O(n) --> n = s.length;
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();

        // getting each letter's number position in sb
        for(char ch : s.toCharArray()){
            sb.append(ch - 96);
        }

        // converting to string so that [12, 2, 23] becomes 12223
        String str = sb.toString();
        int sum = 0;

        while(k != 0){
            sum = 0;
            for(char ch : str.toCharArray()){ // finding the sum of numbers in the str string and doing that k times
                sum += ch - '0';
            }
            k--;
            str = sum + "";
        }
        return sum;
    }


    // TC : (n * log2 + k * log(digits in sum))
    public int getLucky2(String s, int k) {
        int sum = 0;

        // calculating the first sum here, because it is given that k will atleast be 1
        for(char ch : s.toCharArray()){
            int num = ch - 96;
            while(num > 0){
                int digit = num % 10;
                sum += digit;
                num /= 10;
            }
        }

        // as we have calculated the sum once so now going till k-1
        while(k != 1){
            int num = sum;
            sum = 0;
            while(num > 0){
                int digit = num % 10;
                sum += digit;
                num /= 10;
            }
            k--;
        }
        return sum;
    }
}
