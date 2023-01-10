package Stacks_n_Queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class stdDeque {
    /*
     * 
     * Deque (Deck): Deque is a doubly ended queue
     *  
     * In Queue, we add/insert item from back and remove from front
     * Whereas, In deque we can add item both at the front and back
     *                   we can remove item from both the front and back
     * 
     *  NOTE: Whenever there is an interface, there should be a class that implements those abstract methods
              For Deque Interface, there is ArrayDeque class
     * 
     *  Deque is an interface in Java which means 
     *  YOU CANNOT USE:  Deque<Type> deque = new Deque<>();
     */

     public static void main(String[] args) {
        // Creating an object of Deque
        /*
         *  Features of Deque:
         *  1. Add or remove items from both the ends
         *  2. No capacity restrictions
         *  3. Faster than LinkedList and Stack because of feature #1
         *  4. null items are not allowed
         *  5. Not thread safe 
         */
        Deque<Integer> deque = new ArrayDeque<>();
        /*
         *  add(): Adds item at last
         *  remove(): Removes from front
         */
        deque.add(2);
        System.out.println("Deque: "+deque);
        deque.addFirst(3);
        System.out.println("Deque: "+deque);
        deque.add(5);
        System.out.println("Deque: "+deque);
        deque.remove();
        System.out.println("Deque: "+deque);
        deque.removeFirst();
        System.out.println("Deque: "+deque);
        deque.removeLast();
        System.out.println("Deque: "+deque);
     }
    
}
