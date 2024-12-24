package Lecture_practice_problems_kunal_kushwaha._21_String;

public class _01_comparison {
    public static void main(String[] args) {
        String a="subas";
        String b="subas";
        String x=a;
        System.out.println(a==x); // print true as this also pointing to the same object in the heap memory
        System.out.println(a==b); // == operator checks the reference of the objects here both teh objects are pointing to same String pool so it will return true
        String c=new String("subas");
        String d=new String("subas");
        // here two new objects are created so == operator will return false as both object have different reference in the heap memory
        System.out.println(c==d);
    }
}
