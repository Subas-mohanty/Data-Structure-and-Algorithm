package Lecture_practice_problems_kunal_kushwaha._46_Stack_and_Queues;

public class Custom_Stack {
    int [] data;
    static final int DEFAULT_SIZE=10;
    int ptr=-1;
    // when no parameters is passed then it will create the object using the default size and for this we are using this keyword to call the constructor that takes one integer argument
    Custom_Stack(){
        this.data=new int[DEFAULT_SIZE];
    }
    Custom_Stack(int size){
        this.data=new int[size];
    }
    boolean push(int element){
        if(isFull()){
            System.out.println("Stack is full !!");
            return false;
        }
        ptr++;
        data[ptr]=element;
        return true;
    }
    int pop() throws Exception {
        if(isEmpty()){
            throw new Exception("Can't pop from an empty stack");
        }
//        int removed=data[ptr];
//        ptr--;
//        return removed;
        return data[ptr--];
    }
    int peek() throws Exception {
        if (isEmpty()){
            throw new Exception("Can't peek from an empty stack");
        }
        return data[ptr];
    }

    public boolean isEmpty() {
        return ptr==-1;
    }

    public boolean isFull() {
        return data.length-1==ptr;
    }
}
