package SlidingWindow;

import java.util.ArrayList;

public class Max_Sum_Subarray {
    public static void main(String[] args) {
        // int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        // int k = 20;
        // System.out.println("Maximum sum sub-array of size "+ k +" is "+maxSum(arr, k));
    
        int[] arr1 = {12, -1, -7, 8, -15, 30, 16, 28};
        // firstNeg(arr1, 3);
        test(arr1, 3);
    
    }


    // Maximum sum subarray of size 'k' (window size = k)
    public static int maxSum(int[] arr, int k){

        if(k > arr.length){
            return Integer.MAX_VALUE;
        }
        // Start creating a window: start, end defines the window
        // Window size = end - start + 1
        int start = 0; int end = 0;
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        while(end < arr.length){
            sum = sum + arr[end];
            // Increment j until the window size is fixed
            if(end - start + 1 < k){
                end++;
            }
            // Once window size is fixed maintain it and perform calculation
            else if(end - start + 1 == k){
                maxi = Math.max(maxi, sum);
                sum = sum - arr[start];
                start++;
                end++;
            }
        }
    return maxi;
    }


    // Print first negative number from the subarray of size k
    public static void firstNeg(int[] arr, int k) {

        if(k > arr.length){
            System.out.println("Invalid input");
            return;
        }


        // The moment we print something, start++, end++
        for(int i = 0; i < arr.length - k + 1; i++){
            Boolean check = false;
            for(int j = i; j < i+k; j++){
                if(arr[j] < 0){
                    check = true;
                    System.out.println(arr[j]);
                    break;
                }
            }
            if(!check){
                System.out.println(0);
            }
        }
 }

    public static void test(int[] arr, int k) {
        
        int start = 0;
        int end = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        while(end < arr.length){
            
        }
        


    }



}
