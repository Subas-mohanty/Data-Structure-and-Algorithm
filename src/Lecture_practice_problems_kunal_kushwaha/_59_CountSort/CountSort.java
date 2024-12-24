package Lecture_practice_problems_kunal_kushwaha._59_CountSort;

import java.util.Arrays;

class CountSort{
    public static void main(String[] args) {
        int [] arr = {3,2,4,5,1,1,1};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void countSort(int [] arr){
        if(arr == null || arr.length <=1){
            return;
        }
        // finding the max element in the array
        int max=arr[0];
        for(int element: arr) {
            if (element > max) {
                max = element;
            }
        }
        // creating a new array of size max element + 1
        int [] countArray=new int[max+1];

        // creating the frequency array
        for(int num: arr){
            countArray[num]=countArray[num]+1;
//            countArray[num]++;
        }
        int index=0;
        // updating the original array
        for(int i=0; i<=max; i++){
            while(countArray[i]>0){
//                arr[index]=i;
//                index++;
                // OR
                arr[index++]=i;
                countArray[i]--;
            }
        }
    }
}
