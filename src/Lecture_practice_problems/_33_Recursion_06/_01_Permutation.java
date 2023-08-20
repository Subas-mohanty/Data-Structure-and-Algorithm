package Lecture_practice_problems._33_Recursion_06;

public class _01_Permutation {
    public static void main(String[] args) {
        String s="abc";
        permutations("",s);
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
}
