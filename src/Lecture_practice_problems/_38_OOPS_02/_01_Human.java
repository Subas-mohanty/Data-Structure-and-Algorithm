package Lecture_practice_problems._38_OOPS_02;

public class _01_Human {
        int age;
        String name;
        int salary;
        boolean married;
        static int population;

        static void message(){
            System.out.println("hello");
//            System.out.println(this.age); // can't use this over here
        }
         _01_Human(int age, String name, int salary, boolean married){
            this.age=age;
            this.name=name;
            this.salary=salary;
            this.married=married;
            _01_Human.population+=1;
    }

}
