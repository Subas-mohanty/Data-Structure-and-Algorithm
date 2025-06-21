package Programming_Concepts;
import java.util.Arrays;

public class _14_radix_sort {
    // TC : O(digits * (n + digits) )
    // SC : O(n) --> for the output array

    public static void main(String [] args){
        int [] arr = {87, 55, 11, 13, 22, 34, 76, 98, 19, 20, 65, 96};
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static  void radixSort(int [] arr){
        int max = Arrays.stream(arr).max().getAsInt();

        // for number like 471, we will run count sort 3 times which is equal to number of digits in the number
        // O(digits)
        for(int exp = 1; (max/exp) > 0;exp*= 10){
            countSort(arr, exp);
        }
    }
    private static void countSort(int [] arr, int exp){
        int n = arr.length;
        int [] count = new int[10];
        int [] output = new int[n];

        // count digit occurrences
        for(int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // take cumulative sum, to find the actual position of the elements
        // but why and how ?
        // let's say count = {0,3,2,1,0,1,1,1,1,2}
        // now if we take cumulative sum which is count = {0, 3, 5, 6, 6, 7, 8, 9, 10, 12}
        // we will get to know how many elements are their before an element
        // here for example, for index/digit 6, we know that there are 7 elements before it, so we have to put the curr element at 8th position which is 7th index in th output array
        // do a dry run to understand it better
        for(int i = 1; i < 10; i++){
            count[i] += count[i-1];
        }

        // build the output array
        // why going from right to left or end to start ?
        // take this example, count = {0, 3, 5, 6, 6, 7, 8, 9, 10, 12}
        // elements which have digits = 1, their frequency is 3, when we traverse from the end, we will encounter the third element which has digit = 1 first, and when we will put that in output array, it will be in output[3-1] = output[2]
        // and for another two elements having digit = 1, they will be present in output[0] and output[1]
        // notice one thing, in this way the original order of the elements are maintained
        // but if we traverse from the start, the order will be reversed which we don't want
        for(int i = n-1; i >= 0; i--){
            int digit = (arr[i]/exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // copy output to arr
        // src, srcPosition, dest, destPosition, length
        System.arraycopy(output, 0, arr, 0, n);
        // after doing count sort once, for the next time, the output array becomes the original array and we sort that array based on the next left digit place, eg: 1 -> 10 -> 100 and so on
    }
}
