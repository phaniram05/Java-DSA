package Stacks_n_Queues;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        System.out.println("Next Greater Right: "+Arrays.toString(nextGreaterRight(arr)));
        System.out.println("Next Greater Left: "+Arrays.toString(nextGreaterLeft(arr)));
    }

    public static void reverseArray(int[] res){
        int n = res.length;
        for(int i = 0; i < n/2; i++){
            res[i] = res[i] + res[n-i-1];
            res[n-i-1] = res[i] - res[n-i-1];
            res[i] = res[i] - res[n-i-1];
        }
    }


    public static int[] nextGreaterRight(int[] arr){

        if(arr == null){
            return new int[]{Integer.MIN_VALUE};
        }
   
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] res = new int[n];
        int idx = 0;

        for(int i = n-1;i >= 0; i--){
            if(stack.isEmpty()){
                res[idx++] = -1;
            }
            else if(!stack.isEmpty() && stack.peek() > arr[i]){
                res[idx++] = stack.peek();
            }
            else if(!stack.isEmpty() && stack.peek() <= arr[i]){
                while( !stack.isEmpty() && stack.peek() <= arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[idx++] = -1;  
                }else{
                    res[idx++] = stack.peek();
                }
            }
       stack.push(arr[i]);
    }
    reverseArray(res);
    return res;
}

    public static int[] nextGreaterLeft(int[] arr){
        
        if(arr == null){
            return new int[]{Integer.MIN_VALUE};
        }
   
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] res = new int[n];
        int idx = 0;

        for(int i = 0;i < n; i++){
            if(stack.isEmpty()){
                res[idx++] = -1;
            }
            else if(!stack.isEmpty() && stack.peek() > arr[i]){
                res[idx++] = stack.peek();
            }
            else if(!stack.isEmpty() && stack.peek() <= arr[i]){
                while( !stack.isEmpty() && stack.peek() <= arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[idx++] = -1;  
                }else{
                    res[idx++] = stack.peek();
                }
            }
       stack.push(arr[i]);
    }
    System.out.println("Reverse of array: "+Arrays.toString(res));
    return res;

    }

}
