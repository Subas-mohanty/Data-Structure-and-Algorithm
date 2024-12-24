package Lecture_practice_problems_kunal_kushwaha._40_OOPS_04_AccessControl_and_Built_in_Packages;

public class A {
    int num;
    String name;

    public A(int num, String name) {
        this.num = num;
        this.name = name;
    }
}
class subClass extends A{

    public subClass(int num, String name) {
        super(num, name);
    }

    public static void main(String[] args) {
        subClass obj=new subClass(34,"subas");
        int n=obj.num;
    }
}
