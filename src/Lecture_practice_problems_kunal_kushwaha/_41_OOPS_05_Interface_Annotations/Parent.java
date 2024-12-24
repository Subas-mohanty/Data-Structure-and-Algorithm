package Lecture_practice_problems_kunal_kushwaha._41_OOPS_05_Interface_Annotations;

public class Parent extends AbstractClass {
    public static void main(String[] args) {
        Parent parent=new Parent();
        AbstractClass pita=new Parent(); // abstract class reference and Parent class object (dynamic method dispatch)
        AbstractClass.myName();
//        AbstractClass abs=new AbstractClass(); // can't be done
    }
    static void hii(){
        System.out.println("Hii this is me !");
    }
    @Override
    void greet() {
        System.out.println("Good evening");
    }
}
