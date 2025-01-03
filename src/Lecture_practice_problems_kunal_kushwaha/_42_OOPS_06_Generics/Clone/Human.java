package Lecture_practice_problems_kunal_kushwaha._42_OOPS_06_Generics.Clone;

public class Human implements Cloneable{
    int age;
    String name;
    int [] arr;

    // this also does shallow copy
//    public Human(Human other){
//        this.age=other.age;
//        this.name=other.name;
//        this.arr=other.arr;
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
