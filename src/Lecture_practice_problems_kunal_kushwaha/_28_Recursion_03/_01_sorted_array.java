package Lecture_practice_problems_kunal_kushwaha._28_Recursion_03;

public class _01_sorted_array {
    public static void main(String[] args) {
        int [] arr={-8};
        System.out.println(sorted(arr,0));

    }
    static boolean sorted(int [] arr,int index){
        // for empty array
        if(arr.length==0){
            return true;
        }
        // base condition
        if (index == arr.length - 1) {
            return true;
        }
        return arr[index]<arr[index+1] && sorted(arr,index+1);
    }
}
