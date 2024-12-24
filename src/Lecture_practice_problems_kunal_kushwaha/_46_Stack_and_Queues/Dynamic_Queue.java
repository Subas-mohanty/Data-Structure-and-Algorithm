package Lecture_practice_problems_kunal_kushwaha._46_Stack_and_Queues;

public class Dynamic_Queue extends Circular_Queue{
    Dynamic_Queue(){
        // this will call the no parameter constructor
        super();
    }
    Dynamic_Queue(int size){
        // this will call the single parameter constructor
        super(size);
    }

    @Override
    public boolean insert(int element) {
        // this take care of it being full
        if(this.isFull()){
            // double the array size
            int [] temp=new int[data.length*2];

            // copy all previous items to new data
            for (int i = 0; i < data.length; i++) {
                temp[i]=data[(front+i)]%data.length; // cause our queue starts from front so, we will put elements in the temp from front and that % is for when the index will go out of the length
            }
            front=0;
            end=data.length;
            data=temp;
        }
        // at this point we know the array is not full because we double the length
        // insert item
        return super.insert(element);
    }
}
