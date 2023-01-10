package Sorting;
import java.util.Arrays;

public class sortingPractice {
    public static void main(String[] args) {
        int[] arr = {-98, 100, 12, -5, 0};
        int[] arr1 = {5, 4, 3, 2, 1};
        //bubbleSort(arr);
        //selectionSort(arr1);
        insertionSort(arr1);
        System.out.println("After sorting : "+Arrays.toString(arr1));


        int[] arr3 = {0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0 , 0, 1, 0};
        int[] arr4 = {1, 1, 1, 1, 0, 0, 0, 0};
        reArrange(arr4);
        System.out.println(Arrays.toString(arr4));
    }

    // Bubble sort

    public static void bubbleSort(int[] arr) {
     //   Boolean isSwapped = false;
        int N = arr.length;
        for(int i=0; i < N-1; i++){
            for(int j=0; j < N-1 -i; j++){
                if(arr[j+1] < arr[j]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void selectionSort(int[] arr) {
        int N = arr.length;
        for(int i=0; i < N - 1; i++){
            int startIdx = i;
            int minIdx = minIdx(arr, startIdx, N);
            swap(arr, minIdx, startIdx);
        }
    }


    public static int minIdx(int[] arr, int startIdx, int endIdx) {
        int minIdx = startIdx;
        for(int i=startIdx; i < endIdx; i++){
            if(arr[minIdx] > arr[i]){
                minIdx = i;
            }
        }
        return minIdx;
    }

    public static void insertionSort(int[] arr) {
        for(int i = 0; i <= arr.length - 2; i++){
            for(int j = i+1; j > 0; j--){
                if(arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                }else{
                    break;
                }
            }
        }
    }


    public static void reArrange(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            if(arr[start] == 0){
                start++;
                continue;
            }else if(arr[start] == 1 && arr[end] == 1){
                end--;
                continue;
            }else if(arr[start] == 1 && arr[end] == 0){
                arr[start] = arr[start] + arr[end];
                arr[end] = arr[start] - arr[end];
                arr[start] = arr[start] - arr[end];
            }
        }
    }




}
