package Lecture_practice_problems_kunal_kushwaha._56_Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

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
//        ArrayList<Integer> list = heap.heapSort();
//        System.out.println(list);

        // maxHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // minHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(3);
        minHeap.offer(32);
        minHeap.offer(31);
        minHeap.offer(13);
        minHeap.offer(233);
        int size = minHeap.size();
        for (int i = 0; i < size; i++) { // we can't do minHeap.size() directly here as it is changing after every iteration hence all items will not be printed
            System.out.println(minHeap.poll());
        }
    }
}
