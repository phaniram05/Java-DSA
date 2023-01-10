package Stacks_n_Queues;

import java.util.Arrays;

public class CustomQueue {
    
    int[] data;
    static final int DEFAULT_SIZE = 10;
    int pointer = 0;
    
    CustomQueue(){
        this (DEFAULT_SIZE);
    }

    CustomQueue(int size){
        this.data = new int[size];
    }

    // add()
    public boolean add(int value){
        if(isFull()){
            System.out.println("Queue is full");
            return false;
        }

        this.data[pointer] = value;
        pointer++;
        return true;
    }

    // remove() =>  O(N)
    public int remove(){
        if(isEmpty()){
            System.out.println("Empty Queue .. What to remove ?");
            return Integer.MIN_VALUE;
        }

        int deletedValue = this.data[0];
        shiftItemsBefore(this.data);
        pointer--;
        return deletedValue;

    }

    // shiftItemsBefore(): 
    /*
     *  Though this removes the first element and shifts the next elements
     *  We need to identify that there is a catch
     *  
     *                1   2   3   4   5   6   7   8
     *  Remove 1 ==>  2   3   4   5   6   7   8   0
     *  But with the logic written below it will be 
     *                2   3   4   5   6   7   8   8
     *                                      pointer   
     * Notice the last element
     * But the good thing is pointer is at the desired last element
     * 
     * Nothing to worry about: When we add next time the unwanted last element will be replaced
     * 
     */
    public void shiftItemsBefore(int[] data){
       if(data.length == 1){
         data = new int[]{};
       }
        for(int i=1; i < pointer; i++){
            data[i-1] = data[i];
        }
    }

    // peek()
    public int peek() throws Exception{
        if(pointer == 0){
            throw new Exception("Empty Queue found"); 
        }
        return this.data[0];
    }

    // isFull()
    public boolean isFull(){
        return pointer == this.data.length;
    }

    // isEmpty()
    public boolean isEmpty(){
        return pointer == 0;
    }

    public void display(){
        if(pointer== 0){
            return;
        }
        for(int i=0; i < pointer; i++){
            System.out.print(data[i]+" <-");
        }
        System.out.print(" END ");
    }   


    public static void main(String[] args) throws Exception{
        CustomQueue cQueue = new CustomQueue();
        cQueue.add(1);
        cQueue.add(2);    
        cQueue.add(3);
        cQueue.add(4);
        cQueue.add(5);
        cQueue.add(1);
        cQueue.add(2);
        cQueue.add(3);
        cQueue.add(4);
        cQueue.add(5);

        cQueue.display();
        

        cQueue.remove();
        cQueue.remove();
    
        System.out.println(cQueue.data.length);
        System.out.println(cQueue.pointer);
        cQueue.display();
    }


}
