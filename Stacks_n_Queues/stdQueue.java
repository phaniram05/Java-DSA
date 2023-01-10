package Stacks_n_Queues;

import java.util.LinkedList;
import java.util.Queue;

public class stdQueue {
    public static void main(String[] args) {
        /*
         *  Don't get tempted to write 
         *  Queue<String> persons = new Queue<>();
         * 
         *  Bcoz, Queue in Java is not a class but an interface
         * 
         *  NOTE: Whenever there is an interface, there should be a class that implements those abstract methods
         *        
         *        For Queue Interface, there is LinkedList class             
         * 
         * 
         *  Internally, LinkedList which is a class will take care of its implementation
         * 
         *  Counter =  p1 p2 p3 p4 p5 .........
         *  
         *  add(p6) : adds new person to the last of queue
         *  Counter = p1 p2 p3 p4 p5 p6 ..
         *  remove(): removes first person infront of counter 
         *  Counter = p2 p3 p4 p5 p6 .... 
         *  peek() => p2
         *  Checks who is there FIRST infront the counter and returns 
         */

        Queue<Integer> numsQueue = new LinkedList<>();
        // add() from LinkedList adds element at the end
        numsQueue.add(12);
        numsQueue.add(24);
        numsQueue.add(36);
        numsQueue.add(48);

        // remove() from LinkedList removes element from the front
        numsQueue.remove();
        System.out.println("nums Queue: "+numsQueue);

        // peek() : returns the first person in the queue without removing
    }
}
