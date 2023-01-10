package Recursion;

import java.util.ArrayList;

public class RecursionArrayQuestions {
    public static void main(String[] args) {
         int[] arr = {9, 8, 7, 6, 5, 4, 3, 2 , 0, 1, 7};
        // System.out.println("Sorted ? "+isArrSorted(arr, 0));
        
        int[] test = {7, 7, 7, 7, 7};
        // System.out.println("Indices of target : " + findAllIndices(test, 7, 0, new ArrayList<>()));
        System.out.println(findAllIndices_method2(arr, 7, 0));
        System.out.println(idxReverse(arr, 7, 0));

        // int[] arr1 = {4, 5, 6, 7, -1, 0, 1, 2, 3};
        // System.out.println("Element found at index: "+rotatedBS(arr1, 4, 0, arr1.length - 1));

    }   

    public static Boolean isArrSorted(int[] arr, int idx) {
        Boolean isAsc = arr[0] < arr[arr.length - 1];
        if(idx == arr.length - 1){
            return true;
        }
        if(isAsc)
            return isArrSorted(arr, idx + 1) && arr[idx] < arr[idx + 1]; 
        else
            return isArrSorted(arr, idx + 1) && arr[idx] > arr[idx + 1];
        }

    
    public static ArrayList<Integer> findAllIndices(int[] arr, int target, int idx, ArrayList<Integer> list) {
        if(idx == arr.length){
            return list;
        }

        if(arr[idx] == target){
            list.add(idx);
        }
        return findAllIndices(arr, target, idx + 1, list);
    }

    // Return indices of target without having a ArrayList<Integer> param


    // IMP / Remember  technique although space complexity is huge
    public static ArrayList<Integer> findAllIndices_method2(int[] arr, int target, int idx){

        ArrayList<Integer> res = new ArrayList<Integer>();
        if(idx == arr.length){
            return res;
        }

        if(arr[idx] == target){
            res.add(idx);
        }
        
        ArrayList<Integer> list = findAllIndices_method2(arr, target, idx + 1);
        res.addAll(list);
        return res;
    }


    // Rotated binary search
    public static int rotatedBS(int[] arr, int target, int start, int end){
        if(arr.length == 0 || start > end){
            return -1;
        }
     
        int mid = start + (end - start) / 2;
        if(arr[mid] == target){
            return mid;
        }
        
        Boolean midCheck = arr[mid] >= arr[start];
        Boolean targetCheck = target >= arr[start]; 

        if(midCheck == targetCheck){
            return arr[mid] > target ? rotatedBS(arr, target, start, mid - 1) : rotatedBS(arr, target, mid + 1, end);
        }
        return midCheck ? rotatedBS(arr, target, mid + 1, end) : rotatedBS(arr, target, start, mid - 1);
    }


    public static ArrayList<Integer> idxReverse(int[] arr, int target, int idx){

        ArrayList<Integer> res = new ArrayList<Integer>();
        if(idx == arr.length){
            return res;
        }

        if(arr[idx] == target){
            res.add(idx);
        }

        ArrayList<Integer> list = idxReverse(arr, target, idx + 1);
        list.addAll(res);
        return list;

    }
}
