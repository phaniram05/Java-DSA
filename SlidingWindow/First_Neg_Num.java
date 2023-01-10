package SlidingWindow;

import java.util.*;

public class First_Neg_Num {

    public static void main(String[] args){
        // Given an array, display the first negative element in the window size k
        
        int[] arr  = {46, -24, -87, 114, 56, -47, 120, -895};
        int windowSize = 3;
        // Output: -24 -24 -87 -47 -47 -47
        
        int start = 0;
        int end = 0;

        Queue<Integer> queue = new LinkedList<>();

        while(end < arr.length){

            if(arr[end] < 0){
                queue.add(arr[end]);
            }
            
            if(end-start+1 < windowSize){
                end++;
            }else if(end-start+1 == windowSize){
                if(queue.isEmpty()){
                    System.out.print(0 + " ");
                }
                else if(arr[start] == queue.peek()){
                    System.out.print(queue.remove()+" ");
                }else{
                    System.out.print(queue.peek()+" ");
                }
            start++;
            end++;
        }
        
    }
 }
}
