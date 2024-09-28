package Lecture_practice_problems._33_Recursion_06;

import java.util.ArrayList;

public class _01_Permutation {
    public static void main(String[] args) {
        String s="abc";
        permutations("",s);
        System.out.println(permutations3("", s));
        System.out.println(permutations4("", s, 0));
    }
    static void permutations(String p, String up){
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first=p.substring(0,i);
            String second=p.substring(i,p.length());
            permutations(first+ch+second,up.substring(1));
        }
    }
    static ArrayList<String> permutations2(String processed, String unprocessed){
        ArrayList<String> ans = new ArrayList<>();
        if(unprocessed.isEmpty()){
            // ArrayList<String> list = new ArrayList<>();
            ans.add(processed);
            return ans;
        }
        char ch = unprocessed.charAt(0);
        // local list
//        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0; i<= processed.length(); i++){
            String fs = processed.substring(0, i);
            String ss = processed.substring(i, processed.length());
            ans.addAll(permutations2(fs+ch+ss, unprocessed.substring(1)));
        }
        return ans;
    }
    // counting no. of permutation
    static int permutations3(String p, String up){
        if (up.isEmpty()) {
            // when unprocessed is empty we found one answer so count is 1
            return 1;
        }
        int count = 0;
        char ch=up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String first=p.substring(0,i);
            String second=p.substring(i,p.length());
            count = count + permutations3(first+ch+second,up.substring(1));
        }
        return count;
    }
    static int permutations4(String p, String up, int count){
        if (up.isEmpty()) {
            // when unprocessed is empty we found one answer so count is 1
            return count+1;
        }
        char ch=up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String first=p.substring(0,i);
            String second=p.substring(i,p.length());
            count = permutations4(first+ch+second,up.substring(1), count);
        }
        return count;
    }
}
