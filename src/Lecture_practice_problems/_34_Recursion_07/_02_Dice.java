package Lecture_practice_problems._34_Recursion_07;

import java.util.ArrayList;

public class _02_Dice {
    public static void main(String[] args) {
        dice("",3);
//        System.out.println(diceCount("",4));
        ArrayList<ArrayList<String>> list = dice3("", 4);
        for(ArrayList<String> ans : list){
//            System.out.println(ans);
        }
    }
    static void dice(String ans, int target){
        if(target == 0){
            System.out.println(ans);
            return;
        }
        for(int i =1; i<= 6 && i <= target; i++){
            dice(ans+i, target - i);
        }
    }
    static ArrayList<String> dice2(String p, int target){
        if (target == 0) {
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans=new ArrayList<>();
        for (int i = 1; i <= target ; i++) {
            ans.addAll(dice2(p+i,target-i));
        }
        return ans;
    }
    static int diceCount(String p,int target){
        if (target == 0) {
            return 1;
        }
        int count=0;
        for (int i = 1; i <=6 && i<=target ; i++) {
            count +=diceCount(p+i,target-i);
        }
        return count;
    }
    static ArrayList<ArrayList<String>> dice3(String ans, int target){
        ArrayList<ArrayList<String>> outer = new ArrayList<>();
        if(target == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            outer.add(list);
            return outer;
        }
        for(int i =1; i<= 6 && i <= target; i++){
            ArrayList<ArrayList<String>> res = dice3(ans+i, target - i);
            outer.addAll(res);
        }
        return outer;
    }
}
