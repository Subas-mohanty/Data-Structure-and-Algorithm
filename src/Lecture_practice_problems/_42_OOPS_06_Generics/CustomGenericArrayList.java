package Lecture_practice_problems._42_OOPS_06_Generics;

import java.util.ArrayList;
import java.util.Arrays;
// https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html#createObjects

public class CustomGenericArrayList<T> {
    private Object [] data;
    private static int DEFAULT_SIZE=10;
    int size=0;

    public CustomGenericArrayList(){
        this.data=new Object[DEFAULT_SIZE];
    }

    public void add(T element){
        if(isFull()){
            resize();
        }
        data[size++]=element;
    }

    private void resize() {
        // first we will create a temporary array of size=data.length*2
        Object [] temp=new Object[data.length*2];

        // copy all the elements to the temp
        for (int i = 0; i < data.length; i++) {
            temp[i]=data[i];
        }
        data=temp;
    }

    private boolean isFull() {
        return size==data.length;
    }

    public T remove(){
        T removed=(T)(data[--size]); // here we do --size because after all the elements has been added the size will be last index + 1 so, we have to first reduced the size then we can perform the task
        return removed;
    }
    public T get(int index){
        return (T)(data[index]);
    }
    public int size(){
        return size;
    }
    public void set(int index, T value){
        data[index]=value;
    }

    @Override
    public String toString() {
        return "CustomGenericArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        CustomGenericArrayList<Integer> list=new CustomGenericArrayList<>();
//        list.add(3);
//        list.add(23);
//        list.add(56);
//        list.add(33);
//        System.out.println(list.size());
//        System.out.println(list.get(1));
//        System.out.println(list.remove());
//        System.out.println(list);
        for (int i = 0; i < 14; i++) {
            list.add(2*i);
        }
        System.out.println(list);
//        list.add("subas"); // now we can't add string to it as we have declared the generics as Integer
    }
}
