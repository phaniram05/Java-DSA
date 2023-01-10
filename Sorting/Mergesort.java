package Sorting;
import java.util.Arrays;

public class Mergesort {
    public static void main(String[] args) {
        int[] test = {22, 0, -8, 5, 784};
        System.out.println("Merge Sorted Array: "+Arrays.toString(mergeSort(test)));
    }

    public static int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length/ 2;

        int[] leftArr = mergeSort(Arrays.copyOfRange(arr, 0, mid)); // copyOfRange function : end value is exclusive
        int[] rightArr = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return mergedArr(leftArr, rightArr);

    }

    public static int[] mergedArr(int[] leftArr, int[] rightArr) {
        int[] resArr = new int[leftArr.length + rightArr.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < leftArr.length && j < rightArr.length){
            if(leftArr[i] < rightArr[j]){
                resArr[k] = leftArr[i];
                i++;
            }else{
                resArr[k] = rightArr[j];
                j++;
            }

            k++;
        }
        
        while(i < leftArr.length){
            resArr[k] = leftArr[i];
            i++;
            k++;
        }

        while(j < rightArr.length){
            resArr[k] = rightArr[j];
            j++;
            k++;
        }

        return resArr;
    }
}
