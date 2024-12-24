package Lecture_practice_problems_kunal_kushwaha._34_Recursion_07;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class _01_PhonePad {
    public static void main(String[] args) {
//        pad("","12");
        String s="23";
        int a=s.charAt(0); // it will give the ascii value of the first character
        int b=a-'0'; // by subtracting  ascii value 0 from ascii value of a will give 50-48=2
        int c='0'; // ascii value of 0 is 48
//        System.out.println(c);
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(s.charAt(1));

//        ArrayList<String> list=letterCombinations("12");
//        System.out.println(list);

        System.out.println(padRet("","12"));
        System.out.println('4'-'0');

    }
    static ArrayList<String> letterCombinations(String digits) {
        return helper("",digits,new ArrayList<>());
    }
    static ArrayList<String> helper(String p,String up,ArrayList<String> list){
        if(up.isEmpty()){
            list.add(p);
            return list;
        }
        char ch = '0';
        int digit=up.charAt(0)-'0';
        System.out.println(digit);
        for (int i = (digit-1)*3; i < (digit*3); i++) {
            ch=(char) ('a'+i);
            helper(p+ch,up.substring(1),list);
        }
        return list;
    }
    static ArrayList<String> padRet(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans=new ArrayList<>();
        char ch = '0';
        int digit=up.charAt(0)-'0'; // up.charAt returns the ascii value of the 0th element and by subtracting with char 0 we can get the integer value of that character
        for (int i = (digit-1)*3; i < (digit*3); i++) { // this loop will run 3 times for every number with corresponding alphabet value
            ch=(char) ('a'+i);// now when we add char 'a' with an integer value it will give an ascii value, then we cast it to char to get the alphabet
            ans.addAll(padRet(p+ch,up.substring(1)));
        }
        // now we add that char to p and in the main string we remove the first character
        return ans;
    }
    static void pad(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit=up.charAt(0)-'0'; // up.charAt returns the ascii value of the 0th element and by subtracting with char 0 we can get the integer value of that character
        for (int i = (digit-1)*3; i < (digit*3); i++) { // this loop will run 3 times for every number with corresponding alphabet value
            char ch=(char) ('a'+i); // now when we add char 'a' with an integer value it will give an ascii value, then we cast it to char to get the alphabet
            pad(p+ch,up.substring(1)); // now we add that char to p and in the main string we remove the first character
        }
    }
}
