package Leetcode.Array;


// https://leetcode.com/problems/count-items-matching-a-rule/description/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _1773_CountItems {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<List<String>> list=new ArrayList<>();
        for (int i = 0; i <3 ; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                list.get(i).add(sc.next());
            }
        }
        int ans=countMatches(list,"color","silver");
        System.out.println(ans);
    }
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count=0;
        for(int i=0;i<items.size();i++){
            if(ruleKey=="type"){
                if(items.get(i).get(0).equals(ruleValue)){
                    count++;
                }
            }
            if(ruleKey=="color"){
                if(items.get(i).get(1).equals(ruleValue)){
                    count++;
                }
            }
            if(ruleKey=="name"){
                if(items.get(i).get(2).equals(ruleValue)){
                    count++;
                }
            }
        }
        return count;
    }
}

