package Lecture_practice_problems_kunal_kushwaha._46_Stack_and_Queues;

public class Custom_Queue {
    int [] data;
    static final int DEFAULT_SIZE=10;
    int end=0;

    Custom_Queue(){
        this.data=new int[DEFAULT_SIZE];
    }
    Custom_Queue(int size){
        this.data=new int[size];
    }

    public boolean insert(int element){
        if (isFull()) {
            return false;
        }
        data[end++]=element; // data[end] is equal to element then end++
        return true;
    }
    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty !");
        }
        int removed=data[0];
        // now we have to shift the elements to left once
        for (int i = 1; i < end; i++) {
            data[i-1]=data[i];
        }
        end--;
        return removed;
    }
    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty !");
        }
        return data[0];
    }

    public void display(){
        for (int i = 0; i < end; i++) {
            System.out.print(data[i]+ "<- ");
        }
        System.out.println("END");
    }
    public boolean isEmpty() {
        return end==0;
    }
    public boolean isFull() {
        return data.length==end;
    }
}
