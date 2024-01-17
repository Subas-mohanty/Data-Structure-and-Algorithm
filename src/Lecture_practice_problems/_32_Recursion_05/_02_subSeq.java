package Lecture_practice_problems._32_Recursion_05;

import java.util.ArrayList;

public class _02_subSeq {
    public static void main(String[] args) {
//        subSeq("","abc");

//        ArrayList<String> ans=subSeqRet("","abc");
//        System.out.println(ans);

      subSeqAscii("","abc");
    }
    static void subSeq(String p,String up){
      if (up.isEmpty()){
        System.out.println(p);
        return;
      }
      char ch=up.charAt(0);
      subSeq(p+ch,up.substring(1));
      subSeq(p,up.substring(1));
    }
    static ArrayList<String> subseq(String text, String ans, ArrayList<String> list){
      if(text.isEmpty()){
        list.add(ans);
        return list;
      }
      char ch = text.charAt(0);
      subseq(text.substring(1), ans+ch, list);
      subseq(text.substring(1), ans, list);
      return list;
    }
    static ArrayList<String> subSeqRet(String p, String up){
      if (up.isEmpty()){
        ArrayList<String> list=new ArrayList<>();
        list.add(p);
        return list;
      }
      char ch=up.charAt(0);
      ArrayList<String> left =subSeqRet(p+ch,up.substring(1));
      ArrayList<String> right =subSeqRet(p,up.substring(1));

      //combining left and right
        left.addAll(right);
        return left;
    }

    static void subSeqAscii(String p,String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        subSeqAscii(p+ch,up.substring(1));
        subSeqAscii(p,up.substring(1));
        subSeqAscii(p+(ch+0),up.substring(1));
    }
}
