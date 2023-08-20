package Assignment._05_arrays._01_easy;

import java.util.ArrayList;
// not solved yet
public class _06_most_candies {
    public static void main(String[] args) {
        int [] arr={2,3,5,1,3};
        ArrayList<Boolean> ans=kidsWithCandies(arr,3);
        System.out.println(ans);
    }
    static ArrayList<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> ans=new ArrayList<>(10);
        for(int i=0;i<=candies.length;i++){
            int max=maxElement(candies);
            if(candies[i]+extraCandies>=max){
                ans.add(i,true);
            }
            else{
                ans.add(i,false);
            }
        }
//        return Arrays.toString(ans);
        return ans;
    }
    static int maxElement (int [] arr){
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
}
