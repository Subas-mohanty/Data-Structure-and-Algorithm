package Lecture_practice_problems._41_OOPS_05_Interface_Annotations;
public interface A{
    default void fun(){
        System.out.println("Having fun");
    }
}
