package Lecture_practice_problems_kunal_kushwaha._30_MergeSort;

import java.util.Arrays;

public class _01_MergeSort {
    public static void main(String[] args) {
//        int [] arr={5,4,3,2,1};
//        arr=mergeSort(arr); // Here the original array is not modified
//        System.out.println(Arrays.toString(arr));

        int [] arr={5,4,3,2,1};
        mergeSortInPlace(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    static int [] mergeSort(int [] arr){
        if (arr.length == 1) {
            return arr;
        }
        int mid=arr.length/2;
        int [] left= mergeSort(Arrays.copyOfRange(arr,0,mid));
        int [] right= mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left,right);
    }

    private static int[] merge(int[] firstArr, int[] secondArr) {
        int [] mix=new int [firstArr.length+secondArr.length];
        int i=0;
        int j=0;
        int k=0;

        while(i<firstArr.length && j<secondArr.length){
            if(firstArr[i]<secondArr[j]){
                mix[k]=firstArr[i];
                i++;
            } else{
                mix[k]=secondArr[j];
                j++;
            }
            k++;
        }

        // It may be possible that one of the arrays is not complete
        // copy the remaining elements to the returning array
        while (i < firstArr.length) {
            mix[k] = firstArr[i];
            i++;
            k++;
        }
        while (j < secondArr.length) {
            mix[k] = secondArr[j];
            j++;
            k++;
        }
        return mix;
    }


    static void mergeSortInPlace(int [] arr,int s, int e){
        if (e-s == 1) {
            return;
        }
        int mid=s+(e-s)/2;
        mergeSortInPlace(arr,s,mid);
        mergeSortInPlace(arr,mid,e);

        mergeInPlace(arr, s, mid, e);
    }

    private static void mergeInPlace(int[] arr, int s, int m, int e) {
        int [] mix=new int [e-s];
        int i=s;
        int j=m;
        int k=0;

        while(i<m && j< e){
            if(arr[i]<arr[j]){
                mix[k]=arr[i];
                i++;
            } else{
                mix[k]=arr[j];
                j++;
            }
            k++;
        }

        // It may be possible that one of the arrays is not complete
        // copy the remaining elements to the returning array
        while (i < m) {
            mix[k] = arr[i];
            i++;
            k++;
        }
        while (j < e) {
            mix[k] = arr[j];
            j++;
            k++;
        }
        for (int l = 0; l < mix.length; l++) {
            arr[s+l] =mix[l];
        }
    }
}
