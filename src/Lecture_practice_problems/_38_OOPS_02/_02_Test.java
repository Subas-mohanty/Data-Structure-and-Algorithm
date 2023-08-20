package Lecture_practice_problems._38_OOPS_02;

public class _02_Test {
    public static void main(String[] args) {
//        _01_Human subas=new _01_Human(19,"subas",10245,false);
//        _01_Human manas=new _01_Human(19,"manas",105845,false);

//        System.out.println(subas.age);
        System.out.println(_01_Human.population);


    }

    // This is not dependent on objects
    static void fun(){
//        greeting();// we can't use this because it requires an instance but the function we are using it in does not depend on instances

        // You can't access non static stuff without referencing their instances in a static context

        // hence, here I am referencing it
        _02_Test obj=new _02_Test();
        obj.greeting();
    }
    void fun2(){ // can't be run in main
        greeting();
    }
    // we know that something which is not static, belongs to an object
    void greeting(){
//        fun();// This can be done
        System.out.println("Hello world !");
    }
}
