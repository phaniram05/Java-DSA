package Searching;
import java.util.Arrays;

public class binarySearchIn2DArr{
    

    public static void main(String[] args){
        int[][] arr = {
                {8, 6, 5, 4},
                {7, 2, 3},
                {2, 1},
                {-1}

        };

        int[][] arrAsc = {
            {2, 4, 6, 8},
            {3, 6, 9, 12},
            {4, 8, 12, 6},
            {5, 10, 15, 20}
        };
        int target = 7;
        // int[] res = binarySearchIN2dArr(arr, target);
        // int[] resAsc = binarySearchIN2dArr(arrAsc, target);
        // System.out.println("Element found at : "+Arrays.toString(res));
        // System.out.println("Element found at : "+Arrays.toString(resAsc));

        int[][] pureSort = { { 0, 6, 8, 9, 11 },
        { 20, 22, 28, 29, 31 },
        { 36, 38, 50, 61, 63 },
        { 64, 66, 100, 122, 128 } };
        System.out.println("Purely Sorted index : "+Arrays.toString(purelySorted(pureSort, 31)));

    }


    // All the row elements and Columns are sorted in Ascending order

    public static int[] binarySearchIN2dArr(int[][] arr, int target) {
        int row = 0;
        int col = arr[row].length - 1;
        Boolean isDesc = arr[0][0] > arr[0][arr[row].length - 1];

        while(row < arr.length && col >= 0){
            int ele = arr[row][col];
            if(ele == target){
                return new int[]{row, col};
            }
            if(isDesc){
                if(ele < target){
                    col--;
                }else{
                    row++;
                }
            }else{
                if(ele > target){
                    col--;
                }else{
                    row++;
                }
            }
            
        }
        return new int[]{-1, -1};
    }

    public static int[] purelySorted(int[][] arr, int target) {
        int start = 0;
        int end = arr.length -1 ;

        while(start <= end){
            int mid = start + (end - start)/2;
            
            int arrStart = arr[mid][0];
            int arrEnd = arr[mid][arr[mid].length - 1];

            if(target > arrStart && target < arrEnd){
                int eleCol = binarySearch(arr[mid], target);
                if(eleCol != -1){
                    return new int[]{mid, eleCol};
                }
                start++;
            }else if(target <= arrStart){
                if(target == arrStart){
                    return new int[]{mid, 0};
                }
                end = mid - 1;
            }else if(target >= arrEnd){
                if(target == arrEnd){
                    return new int[]{mid, arr[mid].length-1};
                }
                start = mid+1;
            }
        }   
        return new int[]{-1, -1};
    }

    public static int binarySearch(int[] arr, int target) {
        
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                return mid;
            }else if(mid > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        
        }   
        return -1;
    }
}