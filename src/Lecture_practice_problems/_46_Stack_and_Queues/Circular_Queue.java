package Lecture_practice_problems._46_Stack_and_Queues;

public class Circular_Queue {
    int [] data;
    static final int DEFAULT_SIZE=10;
    int end=0;
    int front=0;
    int size=0;

    Circular_Queue(){
        this.data=new int[DEFAULT_SIZE];
    }
    Circular_Queue(int size){
        this.data=new int[size];
    }

    public boolean insert(int element){
        if (isFull()) {
            return false;
        }
        data[end]=element;
        end++;
        end=end%data.length;
        size++;
        return true;
    }
    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is Empty !");
        }
        int removed=data[front++];
        front=front%data.length;
        size--;
        return removed;
    }
    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty !");
        }
        return data[front];
    }
    public void display(){
        if (isEmpty()) {
            System.out.println("Queue is empty !");
            return;
        }
        int i=front;
        do{
            System.out.print(data[i]+" ->");
            i++;
            i%=data.length;
        }while(i!=end);
        System.out.println("END");
    }
    public boolean isEmpty() {
        return size==0;
    }
    public boolean isFull() {
        return data.length==size;
    }
}
