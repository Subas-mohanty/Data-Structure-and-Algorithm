package Lecture_practice_problems._43_OOPS_07_CollectionFramework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        list2.add(23);
        list2.add(56);
        list2.add(72);
        list2.add(98);
        System.out.println(list2);

        List<Integer> vector = new Vector<>();
        vector.add(23);
        vector.add(25);
        vector.add(29);
        vector.add(13);
        System.out.println(vector);
    }
}
