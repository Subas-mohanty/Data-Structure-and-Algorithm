package Lecture_practice_problems._46_Stack_and_Queues;

public class Dynamic_Stack extends Custom_Stack{
    Dynamic_Stack(){
        // this will call the no parameter constructor
        super();
    }
    Dynamic_Stack(int size){
        // this will call the single parameter constructor
        super(size);
    }

    // now we have to override the push method of Custom_Stack
    @Override
    boolean push(int element) {
        // this take care of it being full
        if(this.isFull()){
            // double the array size
            int [] temp=new int[data.length*2];

            // copy all previous items to new data
            for (int i = 0; i < data.length; i++) {
                temp[i]=data[i];
            }
            data=temp;
        }
        // at this point we know the array is not full because we double the length
        // insert item
        return super.push(element);
    }
}
