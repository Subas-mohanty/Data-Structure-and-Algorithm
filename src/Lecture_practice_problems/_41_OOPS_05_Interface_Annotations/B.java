package Lecture_practice_problems._41_OOPS_05_Interface_Annotations;
public interface B {
    default void happy(){
        System.out.println("Having fun in B");
    }
}
