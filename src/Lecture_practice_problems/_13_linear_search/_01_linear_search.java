package Lecture_practice_problems._13_linear_search;

public class _01_linear_search {
    public static void main(String[] args) {
        int [] arr = {12,43,78,56,98};
        int target=78;
        int ans=linearSearch(arr,target);
        System.out.println(ans);
    }
    static int linearSearch(int [] arr,int target){
        if(arr.length==0){
            return 0;
        }
        for (int element : arr) {
            if (element == target) {
                return element;
            }
        }
        // this line will execute if none of the above return statements are executed
        // hence target not found
        return -1;
    }
}
