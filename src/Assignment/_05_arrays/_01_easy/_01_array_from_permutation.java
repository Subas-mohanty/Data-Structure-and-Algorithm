package Assignment._05_arrays._01_easy;

import java.util.Arrays;
import java.util.Scanner;

public class _01_array_from_permutation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of the array: ");
        int length=sc.nextInt();
        int [] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i]=sc.nextInt();
        }
        int [] ans = new int[arr.length];
        for (int i = 0; i <arr.length; i++) {
            ans[i]=arr[arr[i]];
        }
        System.out.println(Arrays.toString(ans));
    }
}
