package Lecture_practice_problems._42_OOPS_06.Clone;

public class Human implements Cloneable{
    int age;
    String name;
    int [] arr;

//    public Human(Human other){
//        this.age=other.age;
//        this.name=other.name;
//    }
    public Human(int age, String name) {
        this.age = age;
        this.name = name;
        this.arr=new int[]{3,2,4,5,9,1};
    }
//    public Object clone() throws CloneNotSupportedException{
//        // this does the shallow copy which means that the primitives will be copied as well but the non-primitives will not be copies they will just point to same object
//        return super.clone();
//    }
    public Object clone() throws CloneNotSupportedException{
        Human twin=(Human)super.clone(); // this is shallow copy

        // make a deep copy
        twin.arr=new int[twin.arr.length];
        for (int i = 0; i < twin.arr.length; i++) {
            twin.arr[i]=this.arr[i];
        }
        return twin;
    }
}
