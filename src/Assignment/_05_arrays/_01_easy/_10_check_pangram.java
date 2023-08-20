package Assignment._05_arrays._01_easy;


import java.util.HashSet;

//https://leetcode.com/problems/check-if-the-sentence-is-pangram/
public class _10_check_pangram {
    public static void main(String[] args) {
        String sentence="thequickbrownfoxjumpsoverthelazydog";
//        String sentence="suba";
        boolean ans=checkIfPangram(sentence);
        System.out.println(ans);
    }
//    static boolean checkIfPangram(String sentence) {
//        for(int i=0;i<sentence.length();i++){
//            boolean flag=false;
//            if(((int)(sentence.charAt(i)) >=97 && ((int)(sentence.charAt(i)))<=122)){
//                flag=true;
//            }
////            if (flag == true) {
////                return true;
////            }
////            else
////                return false;
////        }
//
//    }
    static boolean checkIfPangram(String sentence) {
        HashSet<Character> set=new HashSet<>(); //characterset.

        for(int i = 0; i < sentence.length();i++){
            set.add(sentence.charAt(i)); //adding char to set.
        }
        return set.size() == 26; //if set.size == 26 all the alphabet are there at least one hence true else false.
    }
}
