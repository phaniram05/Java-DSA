package Stacks_n_Queues;

import java.util.*;
public class NearestSmallerElement {
    public static void main(String[] args) {
        int[] arr1 = {12, -25, 24, 0, 36, -1};
        System.out.println("Next smaller right: "+Arrays.toString(nearestSmallerRight(arr1)));
        System.out.println("Next smaller left: "+Arrays.toString(nearestSmallerLeft(arr1)));
    }

    public static void reverseArray(int[] res){
        int n = res.length;
        for(int i = 0; i < n/2; i++){
            res[i] = res[i] + res[n-i-1];
            res[n-i-1] = res[i] - res[n-i-1];
            res[i] = res[i] - res[n-i-1];
        }
    }


    // Nearest smaller to the right
    public static int[] nearestSmallerRight(int[] arr){

        if(arr == null){
            return new int[]{Integer.MAX_VALUE};
        }

        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        int idx = 0;

        for(int i = n-1;i >= 0; i--){
            if(stack.isEmpty()){
                res[idx++] = -1;
            }
            else if(!stack.isEmpty() && stack.peek() < arr[i]){
                res[idx++] = stack.peek();
            }
            else if(!stack.isEmpty() && stack.peek() >= arr[i]){
                while( !stack.isEmpty() && stack.peek() >= arr[i]){
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

    // Nearest smaller to the left
    public static int[] nearestSmallerLeft(int[] arr){
        if(arr == null){
            return new int[]{Integer.MAX_VALUE};
        }

        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        int resIdx = 0;

        for(int i = 0; i < n; i++){

            if(stack.isEmpty()){
                res[resIdx++] = -1;
            }

            else if(!stack.isEmpty() && stack.peek() < arr[i]){
                res[resIdx++] = stack.peek();
            }

            else if(!stack.isEmpty() && stack.peek() >= arr[i]){
                while(!stack.isEmpty() && stack.peek() >= arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[resIdx++] = -1;
                }
                else{
                    res[resIdx++] = stack.peek();
                }                
            }
            stack.push(arr[i]);
        }
        return res;
    }
}
