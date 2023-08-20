package Lecture_practice_problems._38_OOPS_02;

public class StaticBlock {
    static int a=5;
    static int b;

    // will only run once, when the first object is created i.e, when the class is loaded for the first time
    // in case we create more objects than one still the static block will only run once
    static {
        System.out.println("I am in static block");
        b=a*5;
    }

    public static void main(String[] args) {
        StaticBlock obj=new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);
        StaticBlock.b+=3;

        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        StaticBlock obj2=new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);
    }
}
