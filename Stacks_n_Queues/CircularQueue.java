package Stacks_n_Queues;

public class CircularQueue {
    int[] data;
    static final int DEFAULT_SIZE = 10;
    
    int frontIdx = 0;
    int nextInsertAt = 0;
    int size = 0;

    CircularQueue(){
        this (DEFAULT_SIZE);
    }

    CircularQueue(int size){
        this.data = new int[size];
    }

    // isFull()
    public boolean isFull(){
         return size == this.data.length;
    }

    // isEmpty()
    public boolean isEmpty(){
        return  size==0;
    }

    // insert()
    public boolean insert(int value){
        if(isFull()){
            System.out.println("Circular Queue full. Cannot insert "+value);
            return false;
        }
        
        data[nextInsertAt++] = value;
        nextInsertAt %= data.length;
        size++;
        return true;
    }

    // remove(): We are not required to shift the elements
    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Empty circular queue found");
        }
        int removedItem = data[frontIdx++];
        frontIdx %= data.length;
        size--;
        return removedItem;
    }

    // Get the front element in the queue
    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Empty circular queue found. No front element");
        }
        
        return data[frontIdx];
    }

    // display()
    public void display(){
        if(size == 0){
            return;
        }
        for(int i = 0; i < size; i++){
            System.out.print(data[(frontIdx+i)%data.length]+" <- ");       
        }
        System.out.print("QUEUE END");
        System.out.println();
    }


    public static void main(String[] args) throws Exception{
        CircularQueue circle = new CircularQueue(8);
        circle.insert(2);
        circle.insert(3);
        circle.insert(5);
        circle.insert(7);
        circle.insert(11);
        circle.insert(13);
        circle.insert(17);
        circle.insert(19);
        
        System.out.println("Removed : "+circle.remove());
        System.out.println("Removed : "+circle.remove());

        System.out.println("Circle size: "+circle.size);
        System.out.println("Circle frontIdx: "+circle.frontIdx);
        System.out.println("Circle nextInsertAt: "+circle.nextInsertAt);

        circle.display();

        circle.insert(29);
        circle.insert(31);

        circle.display();

        System.out.println("Removed : "+circle.remove());
        System.out.println("Removed : "+circle.remove());

        circle.display();

    }
     
}
