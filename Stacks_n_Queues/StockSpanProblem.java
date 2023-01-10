package Stacks_n_Queues;

import java.util.*;
public class StockSpanProblem {
    
    // APPROACH 1: More logical
    // static Stack<int[]> stack = new Stack<>();
    
    // StockSpanProblem(){
        
    // }

    // public int next(int price){

    //     int count = 1;
        
    //     while(!stack.isEmpty() && price >= stack.peek()[0]){
    //         count+= stack.peek()[1];
    //         stack.pop();
    //     }

    //     stack.push(new int[]{price, count});
    //     return count;
    // }
    

    // APPROACH 2: Storing Index of the nearest greatest and subtracting it to get the count     
    
    public int[] stockSpan(int[] arr){

        if(arr == null){
            return null;
        }

        int idx = 0;
        // ArrayList to store left greatest indexes
        int[] leftGreaterIdx = new int[arr.length];
        Stack<int[]> stack = new Stack<>();
        
        for(int i=0; i < arr.length; i++){
            
            if(stack.isEmpty()){
                leftGreaterIdx[idx++] = -1;   
            }

            else if(!stack.isEmpty() && stack.peek()[0] > arr[i]){
                leftGreaterIdx[idx++] = stack.peek()[1];    
            }

            else if(!stack.isEmpty() && stack.peek()[0] <= arr[i]){
                while(!stack.isEmpty() && stack.peek()[0] <= arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    leftGreaterIdx[idx++] = -1;    
                }else{
                    leftGreaterIdx[idx++] = stack.peek()[1];
                }
            }
            stack.push(new int[]{arr[i], i});         
        }

        for(int i=0; i < leftGreaterIdx.length; i++){
            leftGreaterIdx[i] = i - leftGreaterIdx[i];
        }
        return leftGreaterIdx;    
    }    

    public static void main(String[] args) {
        int[] arr = {100,80,60,70,60,75,85};
        StockSpanProblem obj = new StockSpanProblem();
        int[] res = obj.stockSpan(arr);
        System.out.println("Span Array: "+Arrays.toString(res));
    }
}
