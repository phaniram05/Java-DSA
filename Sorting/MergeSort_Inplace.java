package Sorting;
import java.util.Arrays;

public class MergeSort_Inplace {
    public static void main(String[] args) {
        int[] test = {22, 0, -8, 5, 784};
        System.out.println(Arrays.toString(test));  
    }

    public static void mergeSort(int[] arr, int startIdx, int endIdx){
        if(endIdx - startIdx == 1){
            return;
        }

        int mid = (startIdx + endIdx)/ 2;

        mergeSort(arr, startIdx, mid); 
        mergeSort(arr, mid, endIdx);

        mergedArrInplace(arr, startIdx, mid, endIdx);

    }

    public static void mergedArrInplace(int[] arr, int startIdx, int mid, int endIdx) {

        int[] resArr = new int[endIdx - startIdx];

        int i = startIdx;
        int j = endIdx;
        int k = mid;

        while(i < mid && j < endIdx){
            if(arr[i] < arr[j]){
                resArr[k] = arr[i];
                i++;    
            }else{
                resArr[k] = arr[j];
                j++;
            }

            k++;
        }
        
        while(i < mid){
            resArr[k] = arr[i];
            i++;
            k++;
        }

        while(j < endIdx){
            resArr[k] = arr[j];
            j++;
            k++;
        }

        for(int l = 0; l < resArr.length ; l++){
            arr[startIdx+l] = resArr[l];
        }
    }



}
