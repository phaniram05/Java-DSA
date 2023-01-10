package Sorting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {
        
        int[] arr = {10, 9, 0, 8, 7, 6, 5, 4, 2, 3, 1};
        //bubbleSorting(arr);
        //selectionSorting(arr);
        //insertionSorting(arr);
        //cyclicSorting(arr);
        // cyclicSortCode2(arr);
        zeroCyclicSort(arr);
        System.out.println("After sorting : "+Arrays.toString(arr));

        int[] missing = {1, 2, 3, 4, 1};
        List<Integer> res = findDisappearedNumbers(missing);
        System.out.println("Missing elements : "+res); 
    }


    public static void bubbleSorting(int[] arr) {   
        int N = arr.length;
        // if No swap means SORTED array : Logic to optimize the program..
        Boolean isSwapped = false;
        for(int i=0; i<N; i++){
            for(int j=1; j < N-i; j++){
                if(arr[j] < arr[j-1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    isSwapped = true;
                }
            }
            if(!isSwapped){
                break;
            }
        }
    }


    public static void selectionSorting(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int lastIdx = arr.length - i -1;
            int maxIdx = maxIdx(arr, 0, lastIdx);
            if(maxIdx != lastIdx){
                swap(arr, maxIdx, lastIdx);
            }
            
        }
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
    public static int maxIdx(int[] arr, int start, int end) {
        int maxIdx = 0;
        for(int i = start; i <= end; i++){
            if(arr[i] > arr[maxIdx]){              // {98, -1, -254, -798, 1000}
                maxIdx = i;
            }
        }
        return maxIdx;
    }


    public static void insertionSorting(int[] arr){
        int N = arr.length;
        for(int i=0; i <= N - 2; i++){
            for(int j = i+1; j > 0; j--){
                if(arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                }else{
                    break;
                }
                }
            }
        }

    
    public static void cyclicSorting(int[] arr) {
        int N = arr.length;
        for(int i=0; i < N; i++){
            while(arr[i] != i+1){
                swap(arr, i, arr[i] - 1);
            }
        }
    }

    public static void cyclicSortCode2(int[] arr) {
        int N = arr.length;
        int i = 0;
        while(i < N){
            if(arr[i] - 1 != i){
                swap(arr, i, arr[i] - 1);
            }else{
                i++;
            }
        }
    }

    // Cyclic sort from 0 to N-1
    public static void zeroCyclicSort(int[] arr) {
        int N = arr.length;
        int i=0;
        while(i < N){
            if(arr[i] != i){
                swap(arr, i, arr[i]);
            }else{
                i++;
            }
        }
    }

    // Google interview problem
    public static List<Integer> findDisappearedNumbers(int[] arr) {   
        int N = arr.length;
        int i = 0;
        while(i < N){
            int correct =  arr[i] - 1;
            if(arr[i] - 1 != i && arr[correct] != arr[i]){
                swap(arr, i, correct);
            }else{
                i++;
            }
        }
        
        List<Integer> res = new ArrayList<Integer>();
        for(int j = 0; j < arr.length; j++){
            if(arr[j] - 1 != j){
                System.out.println(j+1);
                res.add(j+1);
            }
        }
        return res;
    }



}
