package Searching;
import java.util.ArrayList;

public class search2DArray {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 105}, {7, 8, 9, -154}};
        // System.out.println("Element found ? "+searchElement(arr, -154));

        System.out.println(_2dArrayRowSum(arr)); 

        // int[] scores = {22, 255, 1246, -1254, 0};
        // ArrayList<Integer> finalcount = new ArrayList<Integer>();
        // for(int i : scores){           
        //     int digitCount = digitCount(i);
        //     finalcount.add(digitCount);
        // }
        // System.out.println(finalcount);
        
        wednesFun(1534236469);
    //    int num = 9646324351;
        int num2 = 1056389759;
    }

    public static Boolean searchElement(int[][] arr,int target) {
        if(arr.length == 0){
            System.out.println("Empty array");
            return false;
        }
        for(int row=0; row < arr.length; row++){
            for(int col=0; col < arr[row].length; col++){
                if(arr[row][col] == target){
                    return true;
                }
            }
        }
        return false;
    }

    // check # of digits
    public static int digitCount(int a) {
        int digits = 0;
        /* Below are the edge cases for negative number and 0*/
        if(a < 0){
            a *= -1;
        }if(a == 0){
            return 1;
        }
        while(a > 0){
            a = a/10;
            digits++;
        }
        return digits;
    }

    public static int _2dArrayRowSum(int[][] arr) {
        int maxRowSum = 0;
        for(int[] row : arr){
            int rowSum = 0;
            for(int i : row){
                rowSum += i;
            }
            if(rowSum > maxRowSum){
                maxRowSum = rowSum;
            }
        }
        return maxRowSum;
    }


    public static int wednesFun(int n){
        int rever = 0;
        while(n > 0){
            int rem = n%10;
            rever = rever * 10 + rem;
            n = n/10;
        }
        System.out.println("reverse : "+rever);
        return rever;

    }

}
