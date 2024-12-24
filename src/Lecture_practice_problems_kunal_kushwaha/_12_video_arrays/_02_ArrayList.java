package Lecture_practice_problems_kunal_kushwaha._12_video_arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class _02_ArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
//        list.add(3);
//        list.add(5);
//        list.add(35);
//        list.add(78);
//        list.add(87);
//        System.out.println(list);
//        list.set(0,256);
//        System.out.println(list);
//        list.remove(2);
//        System.out.println(list);
//        System.out.println(list.contains(546));

        for (int i = 0; i < 5; i++) {
            list.add(sc.nextInt());
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i));
        }
    }
}
