package Lecture_practice_problems_kunal_kushwaha._56_Heaps;

import java.util.ArrayList;

// heapify: creating a heap from an unsorted array
// DSA-01 dt:12-11-23
//https://chat.openai.com/c/880a7adc-a19f-4d5f-902c-ef454a049ed6

//DSA-01 dt:11-11-23
public class Heap <T extends Comparable<T>> {
    private ArrayList<T> list;
    public Heap(){
        this.list = new ArrayList<T>();
    }

    // we are storing it as an array/arraylist but representing as a complete binary tree so the indexing will be like this. look at the diagram at DSA-01 dt:11-11-23
    private int parent(int index){
        return (index-1)/2; // return the index of the parent
    }
    private int left(int index){
        return index*2+1;
    }
    private int right(int index){
        return index*2+2;
    }

    // inserting in the heap TC: log(N)
    public void insert(T value){
        list.add(value);
        upheap(list.size()-1); // to re-structure the heap
    }

    // go to the last index and check bottom to up. if the child is less than parent then swap
    private void upheap(int index) {
        if (index == 0) {
            return;
        }
        int p=parent(index);
        if(list.get(index).compareTo(list.get(p))<0){
            swap(index,p);
        }
        upheap(p);
    }

    // removing from a heap TC: log(N)
    public T remove() throws Exception{
        if (list.isEmpty()) {
            throw new Exception("Can't remove from an empty heap");
        }
        T removed=list.get(0);
        T last = list.remove(list.size()-1); // remove the last index value and set it to the first index and do downheap to correctly structure the tree
        if (!list.isEmpty()) {
            list.set(0,last);
        }
        downheap(0);

        return removed;
    }

    private void downheap(int index) {

        int min=index;
        int left=left(index);
        int right=right(index);
        // we have to find the min value among three indices i.e, index, left and right

        // left is smaller than current index
        if(left<list.size() && list.get(left).compareTo(list.get(min))<0){
            min=left;
        }

        // right is smaller than current index
        if(right<list.size() && list.get(right).compareTo(list.get(min))<0){
            min=right;
        }

        // when the min value is not the current index swap the min with current and call the downheap with min for below subtree
        if(min!=index){
            swap(min,index);
            downheap(min);
        }
    }

    // this is heap sort just keep removing elements from the list and add in a new list it will be automatically sorted as we are always removing the smallest element and then re-structuring the tree so that the min element come to the first index
    // TC: Nlog(N), for every item its taking log(N) and there are N elements
    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data=new ArrayList<>();
        while (!list.isEmpty()) {
            data.add(this.remove());
        }
        return data;
    }

    // swapping two indices of an arraylist
    private void swap(int first, int second){
        T temp=list.get(first);
        list.set(first,list.get(second));
        list.set(second,temp);
    }
}
