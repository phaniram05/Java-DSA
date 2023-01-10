package Stacks_n_Queues;

import java.util.*;

public class customStack {
    
    public int[] data;
    public static final int DEFAULT_SIZE = 8;
    int pointer = -1; // Holds the index of the array and increments with addition

    // Default constructor calls the parametrized constructor using this keyword
    customStack(){
        this (DEFAULT_SIZE);
    }
    public customStack(int size){
        this.data = new int[size];
    }

    // push()
    public boolean push(int value){
        if(isFull()){
            System.out.println("Custom Stack size exceeded, Cannot be inserted");
            return false;
        }

        pointer++;
        this.data[pointer] = value;
        System.out.println("Successfully inserted "+value);
        return true;
    }

    // pop()
    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Empty Stack found");
        }
        return this.data[pointer--];
    }

    // peek()
    public int peek()throws Exception{
        if(isEmpty()){
            throw new Exception("Empty Stack found");
        }
        return this.data[pointer]; 
    }

    // isFull()
    public boolean isFull(){
        return pointer == this.data.length - 1;
    }

    // isEmpty()
    public boolean isEmpty(){
        return pointer == -1;
    }

    @Override
    public String toString(){
        return Arrays.toString(data);
    }

    public static void main(String[] args) throws Exception{
        customStack stacky = new customStack(10);
        stacky.push(2);
        stacky.push(3);
        stacky.push(5);
        stacky.push(7); 
        System.out.println("Peeking: "+stacky.peek());
        System.out.println("Is empty? "+stacky.isEmpty());

        System.out.println(stacky.pop());
        System.out.println(stacky.pop());
        System.out.println(stacky.pop());
        System.out.println(stacky.pop());

        System.out.println("Is empty? "+stacky.isEmpty());

        System.out.println("Stacky : "+stacky);
    }
}
