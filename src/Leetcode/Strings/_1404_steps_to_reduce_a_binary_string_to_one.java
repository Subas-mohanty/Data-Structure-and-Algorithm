package Leetcode.Strings;

//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/?envType=daily-question&envId=2024-05-29


public class _1404_steps_to_reduce_a_binary_string_to_one {
    public static void main(String[] args) {
        String s = "10";
        System.out.println(numSteps(s));
//        char c = s.charAt(s.length()-1);
//        System.out.println(s.equals("1"));
    }

    // TC : O(n)
    // SC : O(1)
    // look at this to understand this function
    // https://www.youtube.com/watch?v=qxt7_HD8Cag&ab_channel=NeetCodeIO&t=635
    // in a brief, everytime we get an odd number we have to perform two operation,
    // one is to add one to it and second one is to chop off the last 0 and the carry will remain same
    public int numSteps2(String s) {
        int res = 0, carry = 0;

        for(int i = s.length() - 1; i> 0; i--){
            res++;
            if(s.charAt(i) - '0' + carry == 1){
                carry = 1;
                res ++;
            }
        }
        return res + carry;
    }

    // TC : O(n^2) --> modifying the string takes O(n) time
    // SC : O(1)
    public static int numSteps(String s) {
        int count = 0;

        while(!s.equals("1")){
            int n = s.length();

            // even case
            // when the binary number is even just remove the last 0 and it will be half
            if(s.charAt(n-1) == '0'){
                s = s.substring(0, n-1);
            }

            // binary number is odd, have 1 in the last position
            else{
                // make the last character 0
                s = s.substring(0,n-1)+'0'+s.substring(n);
                int i;

                for(i = n-2; i >= 0; i--){
                    // if found 0, make it 1 and brake
                    if(s.charAt(i) == '0'){
                        s = s.substring(0,i)+'1'+s.substring(i+1);
                        break;
                    }
                    // if all 1's are present then keep converting them to 0
                    if(s.charAt(i) == '1') s = s.substring(0,i)+'0'+s.substring(i+1);
                }
                // if all 1's are present so at the start add 1 to increase the number by 1
                // for ex : 111, adding 1 to it will be 1000
                if(i == -1){
                    s = "1" + s;
                }
            }
            count++;
        }
        return count;
    }
}
