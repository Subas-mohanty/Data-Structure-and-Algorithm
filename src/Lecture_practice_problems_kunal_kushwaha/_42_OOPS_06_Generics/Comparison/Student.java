package Lecture_practice_problems_kunal_kushwaha._42_OOPS_06_Generics.Comparison;

import java.util.Comparator;

public class Student implements Comparable<Student>{
    int rollNo;
    float marks;

    public Student(){

    }
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
class StudentComparator implements Comparator<Student> {
    public int compare(Student a, Student b){
        double r1 = (double)a.marks/(double)a.rollNo;
        double r2 = (double) b.marks / (double) b.rollNo;

        if(r1 < r2) return 1; // sort in ascending
        else if(r1 > r2) return 0; // sort in descending
        else return 0; // leave as it is
    }
}
