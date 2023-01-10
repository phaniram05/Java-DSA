package Searching;
import java.lang.annotation.Target;
import java.util.Arrays;

import javax.annotation.processing.Generated;

/**
 * binarySearchQuestions
 */
public class binarySearchQuestions {
    public static void main(String[] args) {
        // int[] arr = {2, 3, 5, 7, 11, 12, 13, 17, 19, 23, 29};
        // int target = 20;
        // System.out.println("Ceiling of "+String.valueOf(target)+ " in arr : "+ceiling_Flooring_OfNumber(arr, 20, "C"));
        // System.out.println("Flooring of "+String.valueOf(target)+ " in arr : "+ceiling_Flooring_OfNumber(arr, 20, "F"));
    
        // int[] nums = {5, 5, 7, 7, 7, 7, 8, 8, 9, 10, 11, 11};
        // System.out.println(firstAndLastIndex(nums, 11));
        
        // System.out.println(Arrays.toString(searchIndices(nums, 11)));

        // int[][] arr1 = {{1, 2}, {3, 4}};
        // int[][] arr2 = {{4, 3}, {2, 1}};
        // int[][] res = matrixMultiplication(arr1, arr2);
        // for(int row=0; row < res.length; row++){
        //     for(int col = 0; col < res[row].length; col++){
        //         System.out.println("Element at row "+row + " col "+col+" is "+res[row][col]);
        //     }
        // }   
        // int target = 37;
        // int[] arr = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 47}; 
        // System.out.println(target+" found at the index "+infiniteSortedArray(arr, target));
        // int[] arr2 = {0};   
        // System.out.println(target+" found at the index "+infiniteSortedArray(arr2, target));

        // int[] peakArr1 = {2, 4, 7, 8, 9, 10, 11, 12, 1};
        // int[] peakArr2 = {2, 4, 7, 8, 9, 10, 11, 12, 13, 2, 1};
        // int[] peakArr3 = {0,2,1,0};
        // System.out.println("Peak index : "+peakIndex(peakArr1));    
        // System.out.println("Peak index : "+peakIndex(peakArr2));
        // System.out.println("Peak index : "+peakIndex(peakArr3));

        // int[] arr4 = {-6, -3, 0, 1, 2, 4};
        // System.out.println("Array before squared sort : "+Arrays.toString(arr4));
        // System.out.println("Sorted Square Array : "+Arrays.toString(sorted_SqrArray(arr4)));

        // int target1 = -4;
        // int[] arr5 = {-4, 0, 1, 3, 2, 1, -4};    
        // System.out.println("Least Index of "+target1+" is "+searchInMountainArray(arr5, target1));

        int arr[] = {7, 9, 11, 12, 13, 14, 15, 1};
        System.out.println("Rotations : "+countRotations(arr));

    }   

    // Ceiling : smallest number >= target
    // Flooring: Greatest number <= target
    public static int ceiling_Flooring_OfNumber(int[] arr, int target, String str) {
        // edge cases
        if(arr.length == 0){
            return Integer.MAX_VALUE;
        }
        // Ceiling is not possible if target > last array element
        if(target > arr[arr.length-1] && str.charAt(0) == 'C'){
            return Integer.MAX_VALUE;
        }
        // flooring is not possible if target < first array element
        if(target < arr[0]){
            return Integer.MIN_VALUE;
        }

        boolean isAsc = arr[0] < arr[arr.length -1];
        int start = 0;
        int end = arr.length -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(isAsc){
                if(arr[mid] == target){
                    return arr[mid];
                }else if(arr[mid] < target){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        if(str.charAt(0) == 'C'){
            return arr[start];
        }
        return arr[end];
    }

    // smallest letter greater than the target in the array
    public static int nextGreatestLetter(char[] arr, char ch) {
        
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] > ch){
                end = mid - 1;
            }else if(arr[mid] < ch){
                start = mid + 1;
            }
        }
        return arr[start % arr.length];
    }

    // first and last index of an element in an array

    public static String firstAndLastIndex(int[] arr, int target) {
        int[] res = {-1, -1};
        res[0] = leftOrRightBinarySearch(arr, target, true);
        res[1] = leftOrRightBinarySearch(arr, target, false);
        
        return Arrays.toString(res);
    }


    public static int leftOrRightBinarySearch(int[] arr, int target, Boolean checkLeft){

        int start = 0;
        int end = arr.length - 1;
        int idx = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            
            if(arr[mid] < target){
                start = mid + 1;
            }else if(arr[mid] > target){
                end = mid - 1;
            }else{
                idx = mid;
                if(checkLeft){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
        }
        return idx;   
    }


    // Same problem u,, ,  sing using two pointer method, 
    public static int[] searchIndices(int[] arr, int target){
        int[] res = {-1, -1};
        int endTill = -1;
        for(int i =0 ; i < arr.length; i++ ){
            if(arr[i] == target){
                res[0] = i;
                res[1] = i;
                endTill = i;
                break;
            }
        }
        if(endTill == -1){
            return res;
        }else{
            for(int j = arr.length - 1; j > endTill; j-- ){
                if(arr[j] == target){
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }


    // Infinite sorted array : Don't know the length of array
    // Condition: We should not use arr.length property
    // Technique:  Reverse of BinarySearch (Instead of N --> 1 we go from 2 --> N)
    /*  We know that, array is big enough. 

        indices:     0  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15  16 .....
    sortedElements:  2  3  5  7  11 13 17 19 23 29 31  37  41  43  47  50  51 ..... 

    Target element: Lets say 37
    Now We will check through the chunks or a boxSize and keep doubling the boxSize


    */
    public static int infiniteSortedArray(int[] arr, int target) {
        int start = 0;
        int end = 1;
        
        // Checking the array i  chunks of data
        while(target > arr[end]){
            int newStart = end+1;
            end = end + (end - start + 1)*2;
            start = newStart;
        }if(target <= arr[end]){
            // Apply binary search
            while(start <= end){
                int mid = start + (end - start)/2;
                if(arr[mid] == target){
                    return mid;
                }else if(arr[mid] < target){
                    start = mid + 1;
                }else{
                    end = mid -1;
                }
            }
        }
        return -1;
    }

    
    // Matrix multiplication
    public static int[][] matrixMultiplication(int[][] arr1, int[][] arr2) {      
        int[][] res = new int[2][2];
        int[][] identity = {{1, 0}, {0, 1}};
        int[][] zeroMatrix = {{0, 0}, {0, 0}};
        if(arr1 == identity){
            return arr2;
        }else if(arr2 == identity){
            return arr1;
        }else if(arr1 == zeroMatrix || arr2 == zeroMatrix){
            return zeroMatrix;
        }
        for(int i=0; i < arr1.length ; i++){
            for(int j=0; j < arr2.length; j++){
                int sum = 0;
                for(int k = 0; k < 2; k++){
                    sum += arr1[i][k] * arr2[k][j];
                    res[i][j] = sum;
                }
            }
        }
        return res;
    }

    // Finding peak index: No duplicates in array
    public static int peakIndex(int[] arr) {
        if(arr.length < 3){
            return -1;
        }
        int start = 1;
        int end = arr.length -2;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]){
                return mid;
            }else if(arr[mid] < arr[mid+1]){
                start = mid+1;
            }else if(arr[mid] < arr[mid-1]){
                end = mid-1;
            }
        }
        return -1;
    }

    // Given a sorted array, Square every element and return the ascending-sorted-squared array

    public static int[] sorted_SqrArray(int[] arr) {
        if(arr.length == 0){
            return new int[0];
        }else{
            int start = 0;
            int end = arr.length - 1;
            int[] res = new int[arr.length];

            for(int i = arr.length-1; i >= 0 ; i--){
                if(Math.abs(arr[start]) > Math.abs(arr[end])){
                    res[i] = arr[start] * arr[start];
                    start++;
                }else if(Math.abs(arr[start]) < Math.abs(arr[end])){
                    res[i] = arr[end] * arr[end];
                    end--;
                }  
            }
            return res;
        }
    }

    // Practising Binary Search
    public static int binarySearch(int[] arr, int target, int peakIdx, Boolean checkLeft) {
        if(arr.length == 0){
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;
        
        if(checkLeft){
            end = peakIdx - 1;
        }else{
            start = peakIdx + 1;
        }

        Boolean isAsc = arr[start] < arr[end];
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target){
                if(isAsc){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                if(isAsc){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
                
            }        
        }   
        return -1;
    }

    // Searching an element in the mountain array
    public static int searchInMountainArray(int[] arr, int target) {
        if(arr.length == 0){
            return -1;
        }
        int leftIdx  = -1;
        int rightIdx = -1;
        int start = 1;
        int end = arr.length - 2;
        int peakIdx = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]){
                peakIdx = mid;
                break;
            }else if(arr[mid] < arr[mid+1]){
                start = mid +1;
            }else if(arr[mid] < arr[mid-1]){
                end = mid - 1;
            }
        }
        if(peakIdx == -1){
            return -1;
        }
        if(arr[peakIdx] == target){
            return peakIdx; // only one occurence
        }else{
            leftIdx = binarySearch(arr, target, peakIdx, true);
            rightIdx = binarySearch(arr, target, peakIdx, false);
        }
        return leftIdx != -1 ? leftIdx : (rightIdx != -1 ? rightIdx : -1) ;
    }


    // Rotated Array search
    // Pivot : Target to find the max element in the array
    public static int searchInRotaryArray(int[] arr, int target){
        if(arr.length == 0){
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                return mid;
            }
            int firstElement = arr[0];
            int current = arr[mid];
            
            Boolean currentGTfirst = current >= firstElement;
            Boolean targetGTfirst = target >= firstElement;
            if(currentGTfirst == targetGTfirst){
                if(current < target){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }else{
                if(currentGTfirst){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    // count rotations
    public static int countRotations(int[] arr) {
        if(arr.length == 0){
            return -1;
        }if(arr.length == 1){
            return 0;
        }

        int start = 0;
        int end = arr.length-1;
        int pivotIdx = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mid+1 <= end &&arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]){
                pivotIdx = mid;
                break;
            }else if(mid+1 <= end && arr[mid] < arr[mid+1]){
                start = mid + 1;
            }else if(mid-1 >= start && arr[mid] < arr[mid-1]){
                end = mid - 1;
            }else{
                start++;
            }
        }

        if(pivotIdx != -1){
            return pivotIdx+1;
        }
        return arr.length;

    }


    // split Array Largest Sum
    public static int cloneSplitArr(int[] arr, int m){
        
        int boxSize = arr.length - m + 1;

        int prevMin = 0;
        int count = 0;
        while(count < m){
            int sum = 0;
            for(int i = count; i < boxSize; i++){
                sum += arr[i];
            }
            if(sum < prevMin){
                prevMin = sum;
            }
            count++;
        }
        return prevMin;
    }


}