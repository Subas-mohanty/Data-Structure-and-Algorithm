package Lecture_practice_problems_kunal_kushwaha._42_OOPS_06_Generics.Clone;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human subas=new Human(21,"subas mohanty");
//        Human twin =new Human(subas);
        Human twin=(Human) subas.clone();
        System.out.println(twin.age);
        System.out.println(twin.name);
        System.out.println(Arrays.toString(twin.arr));
        subas.arr[0]=23; // in shallow copy, if we change value of one object it will change in another object, in case of primitives it copies the values but in case of objects it point to the same object so changing one's value got reflected in another
        System.out.println(Arrays.toString(twin.arr));
        twin.age=55;
        twin.name="twin";
        System.out.println(twin.name);
        System.out.println(subas.name);
        System.out.println(twin.age);
        System.out.println(subas.age);

    }
}
