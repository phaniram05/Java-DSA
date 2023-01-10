package Recursion;

import java.util.Arrays;

public class RecursionPatterns {
    public static void main(String[] args) {
    //  patternStars(8, 0); 
    int[] arr = {-256, 0, 85, -457, 254687, 174, 2, 0};
    //  bubbleSortRecursion(arr, 0, arr.length - 1);
    selectionSortRecursion(arr, 1, arr.length - 1, 0);  
    System.out.println(Arrays.toString(arr));
    }


    public static void patternStars(int row, int col){     
        if(row < 1){
            return;  
        }
        if(col < row){
            patternStars(row, ++col);
            System.out.print("* ");
        }else{
            patternStars(--row, 0);
            System.out.println();
        }
    }

    public static void bubbleSortRecursion(int[] arr, int startIdx, int endIdx){
    if(endIdx == 0){
        return;
    }
    if(startIdx < endIdx){
        if(arr[startIdx] > arr[startIdx + 1]){
        swap(arr, startIdx, startIdx + 1);
    }
        bubbleSortRecursion(arr, ++startIdx, endIdx);
    }
    else{
        bubbleSortRecursion(arr, 0, --endIdx);
    }
}

    public static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }


    public static void selectionSortRecursion(int[] arr, int startIdx, int endIdx, int maxIdx){

    if(endIdx < 0){
        return;
    }
    if(startIdx <= endIdx && endIdx >= 0){
        if(arr[maxIdx] > arr[startIdx]){
            selectionSortRecursion(arr, startIdx + 1, endIdx, maxIdx);
        }else{
            selectionSortRecursion(arr, startIdx + 1, endIdx, startIdx);
        }
    }else{
        swap(arr, maxIdx, endIdx);
        selectionSortRecursion(arr, 1, endIdx - 1, 0);
    }
}

}
