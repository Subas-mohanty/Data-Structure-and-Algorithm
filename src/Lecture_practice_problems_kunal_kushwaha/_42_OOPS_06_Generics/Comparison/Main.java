package Lecture_practice_problems_kunal_kushwaha._42_OOPS_06_Generics.Comparison;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student subas = new Student(2,76.5f);
        Student manas = new Student(20,73.5f);
        Student rohan = new Student(17,70.8f);
        Student saurav = new Student(23,65.f);
        Student satya = new Student(14,92.1f);

        Student[] list={subas,manas,rohan,saurav,satya};
        System.out.println(Arrays.toString(list));
        Arrays.sort(list, new StudentComparator());
        System.out.println(Arrays.toString(list));

//        if(subas.compareTo(manas)>0){
//            System.out.println("Subas got more marks");
//        }
    }
}
