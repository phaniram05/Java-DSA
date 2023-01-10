package Recursion;

public class RecursionBasics {
    public static void main(String[] args) {
    //   print(1);
       System.out.println(fibo(9));
        
       int[] arr = {2, 3, 5, 7, 11, 13, 17, 19};
       System.out.println(binSearch(arr, 19, 0, arr.length - 1));
    }

    public static void print(int n) {
        if(n == 5){
            System.out.println(5);
            return;
        }
        System.out.println(n);
        print(++n);
    }

    // Linear recursive function
    public static int fibo(int n) {
        if(n < 2){
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }


    // Divide and Conquer recursive relation

    public static int binSearch(int[] arr, int target, int start, int end) {
        
        if(start > end){
            return -1;
        }

        int mid = start + (end - start) / 2 ;
        if(arr[mid] == target){
            return mid;
        }else if(arr[mid] < target){
            return binSearch(arr, target, mid+1, end);
        }else{
            return binSearch(arr, target, start, mid-1);
        }
    }
}
