package Lecture_practice_problems._42_OOPS_06_Generics.Comparison;

public class Student implements Comparable<Student>{
    int rollNo;
    float marks;

    public Student(int rollNo, float marks) {
        this.rollNo = rollNo;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return rollNo+" " +marks;
    }

    @Override
    public int compareTo(Student object) {
        int diff=(int)(this.marks-object.marks);

        // if diff == 0 : means both are equals
        // if diff < 0 : means object is bigger else object is smaller

        return diff;
    }
}
