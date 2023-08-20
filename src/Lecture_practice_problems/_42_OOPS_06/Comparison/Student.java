package Lecture_practice_problems._42_OOPS_06.Comparison;

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
    public int compareTo(Student o) {
        int diff=(int)(this.marks-o.marks);

        // if diff == 0 : means both are equals
        // if diff < 1 : means o is bigger else o is smaller

        return diff;
    }
}
