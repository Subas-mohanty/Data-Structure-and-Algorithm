package Assignment._05_arrays._01_easy;
// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class _16_evenNoOf_digits {
    public static void main(String[] args) {
        int [] arr={123,55,6754,6,786543,98,67564321};
        int ans=evenDigits(arr);
        System.out.println(ans);
    }
    static int evenDigits(int [] arr){
        int onOfEven=0;
        for (int i = 0; i < arr.length; i++) {
            int count=0;
            while(arr[i]>0){
                count++;
                arr[i]/=10;
            }
            if(count%2==0){
                onOfEven++;
            }
        }
        return onOfEven;
    }
}
