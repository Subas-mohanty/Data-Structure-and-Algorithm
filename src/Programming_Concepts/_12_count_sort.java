package Programming_Concepts;
import java.util.Arrays;

public class _12_count_sort {
    // TC : O(n + k) --> k is the range or diff between max and min
    // SC : O(k)
    //    Find the maximum value in the array.
    //    Create a count array of size max + 1 and count the occurrences of each number.
    //    Modify the count array so that it contains positions of elements.
    //    Build the output array using the count array.
    public static void main(String [] args){
        int [] arr = {3,2,4,5,6,1};
        System.out.println(Arrays.toString(arr));
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void countSort(int [] arr){
        if(arr.length == 0) return;
        int max = Arrays.stream(arr).max().getAsInt();
        int [] count = new int[max + 1];
        for(int a : arr) count[a]++;


        // build the sorted array
        int index = 0;
        // this is O(n + k) not n * k
        // because for loop is running for k times and while will totally run n times, number of elements in the count array which is n
        // so total time is n + k
        for(int i = 0; i < count.length; i++){
            while(count[i]-- > 0){
                arr[index++] = i;
            }
        }
    }
}
