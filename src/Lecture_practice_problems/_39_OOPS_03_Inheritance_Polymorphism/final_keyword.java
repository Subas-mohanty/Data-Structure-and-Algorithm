package Lecture_practice_problems._39_OOPS_03_Inheritance_Polymorphism;

class Super{
    final void greet(){
        System.out.println("Hello!");
    }
    static void say(){
        System.out.println("I am from parent class");
    }
}
class Sub extends Super{
    // can't override because greet is declared as final in Super class
//    @Override
//    void greet(){
//        System.out.println("I am from child");
//    }

    static void say(){
        System.out.println("I am in child class");
    }
    // as we know overriding depends on object and static methods doesn't depend on objects so static methods can't be overridden. static method doesn't depend on objects , so the method in the parent class will always run no-matter from which object we call it. static method can be inherited but can't be overridden
//    @Override
//    static void say(){
//        System.out.println("I am in child class");
//    }
}
public class final_keyword {
    public static void main(String[] args) {
        Super base=new Super();
        Sub child=new Sub();
        base.greet();
        child.greet();

        Super obj=new Sub();
//        Sub ob=new Super(); // can't possible cause a sub class reference can not be given to a super class object and child class constructor also can't be called from the base class but the vice versa is possible so the above declaration is correct
        obj.greet();
        Super.say();
        Sub.say();

        Super obj2=new Super();
        Super obj3= new Sub();
        obj2.say();// will print the Super class say method
        obj3.say(); // this will also print Super class say method because the say method is not overridden
    }
}
