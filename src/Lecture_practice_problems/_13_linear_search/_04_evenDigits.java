package Lecture_practice_problems._13_linear_search;

public class _04_evenDigits {
    public static void main(String[] args) {
        int [] nums={12,345,2,6,7896};
        System.out.println(digits(-75642));
        int ans = findNumbers(nums);
        System.out.println(ans);
    }
    static int findNumbers(int [] nums){
        int count=0;
        for(int num:nums){
            if(even(num)){
                count++;
            }
        }
        return count;
    }
    // function to check whether a number contains even digit or not
    public static boolean even(int num) {
        int noOfDigits=digits(num);
//        if (noOfDigits % 2 ==  0) {
//            return true;
//        }
//        return false;
        return noOfDigits % 2 ==  0;
    }
    // function to check the digits of a number
    static int digits(int num){
        if (num < 0) {
            num*=-1;
        }
        if (num == 0) {
            return 1;
        }
        int count=0;
        while(num>0){
            num/=10;
            count++;
        }
        return count;
    }
}
