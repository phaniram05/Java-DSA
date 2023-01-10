package Stacks_n_Queues;

public class DynamicCircularQueue extends CircularQueue{

    DynamicCircularQueue(){
        this (DEFAULT_SIZE);
    }   

    DynamicCircularQueue(int size){
        super(size);
    }

    
    @Override 
    public boolean insert(int value){
        if(isFull()){
            int[] resizedQueue = new int[2*data.length];

            for(int i=0; i < data.length; i++){
                resizedQueue[i] = data[(frontIdx + i) % data.length];
            }

            frontIdx = 0;
            nextInsertAt = data.length;
            data = resizedQueue; 
        }

        return super.insert(value);
    }

    public static void main(String[] args) {
        CircularQueue dcQueue = new DynamicCircularQueue();
        dcQueue.insert(2);
        dcQueue.insert(3);
        dcQueue.insert(5);
        dcQueue.insert(7);
        dcQueue.insert(11);
        dcQueue.insert(13);
        dcQueue.insert(17);
        dcQueue.insert(19);
        dcQueue.insert(11);
        dcQueue.insert(13);
        dcQueue.insert(17);
        dcQueue.insert(19);

        dcQueue.display();
        

    }
}
