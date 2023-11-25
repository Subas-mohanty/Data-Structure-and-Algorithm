package Lecture_practice_problems._56_Heaps;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception{
        Heap<Integer> heap=new Heap<>();
        heap.insert(32);
        heap.insert(90);
        heap.insert(17);
        heap.insert(12);
        heap.insert(76);

//        System.out.println(heap.remove());
//        System.out.println(heap.remove());
//        System.out.println(heap.remove());
//        System.out.println(heap.remove());
        ArrayList<Integer> list = heap.heapSort();
        System.out.println(list);
    }
}
