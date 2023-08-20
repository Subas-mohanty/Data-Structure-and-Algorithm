package Lecture_practice_problems._34_Recursion_07;

import java.util.ArrayList;

public class _02_Dice {
    public static void main(String[] args) {
        System.out.println(dice("",4));
    }
    static ArrayList<String> dice(String p, int target){
        if (target == 0) {
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans=new ArrayList<>();
        for (int i = 1; i <= target ; i++) {
            ans.addAll(dice(p+i,target-i));
        }
        return ans;
    }
    static int diceCount(String p,int target){
        if (target == 0) {
            return 1;
        }
        int count=0;
        for (int i = 1; i <=6 && i<=target ; i++) {

            diceCount(p+i,target-i);
            count++;
        }
        return count;
    }
}
