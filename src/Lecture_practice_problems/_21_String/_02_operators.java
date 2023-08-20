package Lecture_practice_problems._21_String;

import java.util.ArrayList;
import java.util.List;

public class _02_operators {
    public static void main(String[] args) {
        System.out.println('a'+'b'); // print ascii value of a + ascii value of b
        System.out.println("a"+"b"); // here it will concatenate the two strings
        System.out.println('a'+3); // convert a to it's ascii value and then sum it with 3 and gives the integer value as answer cause int is greater than char
        System.out.println("a"+1); // concatenate the string with the int , cause the int is converted to Integer wrapper class and it called it's toString method

        System.out.println("subas"+ new ArrayList<>()); // subas[] cause the tostring method of arraylist contains an empty array so string + []
        System.out.println("subas"+new Integer(56));
//        String ans=new Integer(56)+new ArrayList<>(); // + operator can't be applied to complec datatypes it must have at least one string type object
        String ans=new Integer(56)+""+new ArrayList<>();
        System.out.println(ans);
    }
}
