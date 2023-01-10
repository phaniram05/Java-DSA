package Stacks_n_Queues;

import java.util.*;

public class StdStack {
    public static void main(String[] args) {
        /*
         * 
         *  Stack:  first ..........last
         *  push:   first...........last, newItem 
         *  peek:   Checks who is there top most and returns // newItem 
         *  pop:    removes who is there top most   // newItem
         *  Stack:   first..........last
         */
        Stack<String> names = new Stack<>();
        // Push = Adds element at the last
        names.push("Rama");
        names.push("Sita");
        names.push("Laxmana");
        names.push("Hanuma");

        System.out.println("names : "+names);
        // Pop = Removes element from the last
        System.out.println("Popping: "+names.pop());
        // System.out.println("Popping: "+names.pop());
        // System.out.println("Popping: "+names.pop());
        // System.out.println("Popping: "+names.pop());
        // System.out.println("Popping: "+names.pop());
        
        // Now, the stack is empty. If we perform pop() / Peek() operation it will give EmptyStackException
        // System.out.println("Popping: "+names.pop());

        // Peek = Checks and returns the last element without removing it
        System.out.println("Peeking: "+names.peek());

        // empty() : returns true if the stack is empty
        System.out.println("Is stack empty ? "+names.empty());

        System.out.println("names : "+names);

        // search(data) : Based on 1-based index system from reverse & returns the index of the data
        //                returns -1 if not found
        System.out.println("Index : "+names.search("Rama"));
        System.out.println("Index : "+names.search("Krishna"));  

        
        /*
            Although a stack internally is an array .. We are not calling it an array
            Why?
            Because, the internal array implementation is not accessible to us
            Stack<String> names = new Stack<>();
            We cannot write names[idx] to access the elements.         
        */    



    }
}
