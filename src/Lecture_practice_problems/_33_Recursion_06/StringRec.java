package Lecture_practice_problems._33_Recursion_06;

public class StringRec {
    public static void main(String[] args) {
        f("abc", 4);
    }
    static void f(String s, int count){
        if(count == 0){
            System.out.println(s);
            return;
        }
        // this will be updated in every funtion call
        s="hello";
        f(s, count-1);
    }
}
