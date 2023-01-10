package Searching;
public class binarySearch {
    public static void main(String[] args) {
        int[] arr = {-24, -22, 0, 2,4,6,911,12,14,20,36,48};
        System.out.println(binarySearch(arr , -22));

        int[] arr2 = {55, 44, 33, 22, 11, -11, -22, -33, -44, -55};
        System.out.println(binarySearchDesc(arr2, -444));

        int[] arr3 = {1, 1, 1, 1, 2, 2, 3, 4, 5};
        System.out.println(orderAgnosticBinarySearch(arr3, 1));
    }

    // for array in ascending order
    public static String binarySearch(int[] arr, int target){
        if(arr.length == 0){
            return "Empty array found";
        }
        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int middle = start + (end-start)/2;
            if(arr[middle] == target){
                return String.valueOf(arr[middle])+" at index "+middle+" found in the array";
            }
            if(arr[middle] < target){
                start = middle + 1;
                continue;
            }

            if(arr[middle] > target){
                end = middle-1;
            }
        }
        return "Element not found";
    }

    // for array in descending order : just < > changes
    public static String binarySearchDesc(int[] arr, int target){
        if(arr.length == 0){
            return "Empty array found";
        }
        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int middle = start + (end-start)/2;
            if(arr[middle] == target){
                return String.valueOf(arr[middle])+" found in the array";
            }
            if(arr[middle] < target){
                end = middle - 1;
                continue;
            }

            if(arr[middle] > target){
                start = middle+1;
            }
        }
        return "Element not found";
    }

    // Order-Agnostic binary Search
    public static String orderAgnosticBinarySearch(int[] arr, int target) {
        if(arr.length == 0){
            return "Empty array found";
        }

        int start = 0;
        int end = arr.length - 1;
        boolean isAscending = arr[start] < arr[end];

        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                return  String.valueOf(arr[mid])+" at index "+mid+" found in the array";
            }
            if(isAscending){
                if(arr[mid] > target){
                    end = mid - 1;
                    continue;
                }
                else if(arr[mid] < target){
                    start = mid+1;
                }
            }else{
                if(arr[mid] < target){
                    end = mid - 1;
                    continue;
                }else if(arr[mid] > target){
                    start = mid+1;
                }
            }
        }
        return "Element not found";
    }
    



}
