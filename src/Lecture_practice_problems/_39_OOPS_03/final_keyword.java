package Lecture_practice_problems._39_OOPS_03;

class Super{
    final void greet(){
        System.out.println("Hello!");
    }
}
class Sub extends Base{
    @Override
    void greet(){
        System.out.println("I am from child");
    }
}
public class final_keyword {
    public static void main(String[] args) {
        Super base=new Super();
        Sub child=new Sub();
        base.greet();
        child.greet();

        Base obj=new Sub();
//        Child ob=new Base(); // can't possible cause a sub class reference can not be given to a super class object and child class constructor also can't be called from the base class but the vice versa is possible so the above declaration is correct
        obj.greet();
    }
}
