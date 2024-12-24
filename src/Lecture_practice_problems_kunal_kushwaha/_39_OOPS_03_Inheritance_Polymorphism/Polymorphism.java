package Lecture_practice_problems_kunal_kushwaha._39_OOPS_03_Inheritance_Polymorphism;

class Base{
    void greet(){
        System.out.println("Hello!");
    }
}
class Child extends Base{
    @Override
    void greet(){
        System.out.println("I am from child");
    }
}
public class Polymorphism {
    public static void main(String[] args) {
        Base base=new Base();
        Child child=new Child();
        base.greet();
        child.greet();

        Base obj=new Child();
//        Child ob=new Base(); // can't possible cause a sub class reference can not be given to a super class object and child class constructor also can't be called from the base class but the vice versa is possible so the above declaration is correct
        obj.greet();
    }
}
