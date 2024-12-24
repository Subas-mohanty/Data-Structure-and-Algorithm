package Lecture_practice_problems_kunal_kushwaha._42_OOPS_06_Generics;

import java.util.Arrays;

public class CustomArrayList {
    private int [] data;
    private static int DEFAULT_SIZE=10;
    int size=0;

    public CustomArrayList(){
        this.data=new int[DEFAULT_SIZE];
    }

    public void add(int element){
        if(isFull()){
            resize();
        }
        data[size++]=element;
    }

    private void resize() {
        // first we will create a temporary array of size=data.length*2
        int [] temp=new int[data.length*2];

        // copy all the elements to the temp
        for (int i = 0; i < data.length; i++) {
            temp[i]=data[i];
        }
        data=temp;
    }

    private boolean isFull() {
        return size==data.length;
    }

    public int remove(){
        int removed=data[--size]; // here we do --size because after all the elements has been added the size will be last index + 1 so, we have to first reduced the size then we can perform the task(wo here we should not use size--)
        return removed;
    }
    public int get(int index){
        return data[index];
    }
    public int size(){
        return size;
    }
    public void set(int index, int value){
        data[index]=value;
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        CustomArrayList list=new CustomArrayList();
        list.add(3);
        list.add(23);
        list.add(56);
        list.add(33);
        System.out.println(list.size());
        System.out.println(list.get(1));
        System.out.println(list.remove());
        System.out.println(list.remove());
        list.add(111);
        System.out.println(list);
    }
}
