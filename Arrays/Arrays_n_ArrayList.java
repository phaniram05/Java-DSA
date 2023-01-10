package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Arrays_n_ArrayList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // int[] userInput = new int[5];
        // String[] str = {"Ram", "Sita", "Hanuman"};

        // // for each loop
        // for(int i : userInput){
        //     System.out.print(i+ " ");
        // }

        // System.out.println("Final Array: "+Arrays.toString(str));

        // 2D array with varing columns in each row

        // int[][] interestingArray = {
        //         {1,2,3},
        //         {4},
        //         {5,6,7,8}
        // };
        // Row size is mandatory in array
        

        // for(int i=0;i<interestingArray.length;i++){     
        //     System.out.println("Rows : "+Arrays.toString(interestingArray[i] ));
        // }

        // // input
        // System.out.print("Enter row size > 0 : ");
        // int rowSize = input.nextInt();
        // System.out.print("Enter column size > 0 : ");
        // int colSize = input.nextInt();
        // int[][] arr = new int[rowSize][colSize];
        // for(int row=0;row<arr.length;row++){
        //     for(int col=0;col<arr[row].length;col++){
        //         System.out.print("Enter an element : ");
        //         arr[row][col] = input.nextInt();
        //     }
        // }

        // for(int[] a : arr){
        //     System.out.println(Arrays.toString(a));
        // }


        // No need to specify the size
        // ArrayList<Integer> stocksHold = new ArrayList<Integer>();
        // // add elements at last
        // stocksHold.add(153);
        // stocksHold.add(370);
        // stocksHold.add(371);
        // stocksHold.add(155);
        // stocksHold.add(254);

        // // add elements at specified index
        // stocksHold.add(1, 369);

        // // No limitation. U can add any number of elements usig add()
        // System.out.println(stocksHold); // Directly prints a list

        // // update values based on index
        // stocksHold.set(0, 999);
        // System.out.println(stocksHold);
        // // Can remove elements based on index
        // stocksHold.remove(3); // This will remove element at index 3
        // System.out.println(stocksHold);
        // System.out.println(stocksHold.size());
       
        // // get elements at any index unsing get()
        // System.out.println(stocksHold.get(2));

        // 2D array with ArrayList

        // Initializing the top-level ArrayList
        // ArrayList<ArrayList<Integer>> arrList2D = new ArrayList<ArrayList<Integer>>();

        // // Initializing the internal ArrayLists
        // for(int i=0; i<3; i++){
        //     arrList2D.add(new ArrayList<Integer>());
        // }

        // // Now adding elements to each internal ArrayList
        // for(int i=0;i<arrList2D.size();i++){
        //     for(int j=0;j < 3;j++){
        //         System.out.print("Enter an element: ");
        //         arrList2D.get(i).add(input.nextInt());
        //     }
        // }

        // System.out.println(arrList2D);


        // Max value of an array in a given range
        // int[] arr1 = {15,265,897,-235,654,8777, 36};
        // System.out.println(maxValueInRange(arr1, 0, arr1.length-1));

        // int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        // System.out.println("Array before reversing : "+Arrays.toString(arr2));
        // System.out.println("Reversed Array : "+Arrays.toString(reverseArray(arr2)));
        // System.out.println("Reversed to original array using two-pointer method : "+Arrays.toString(twoPointerSwapping(arr2)));

        // System.out.print("Enter some string : ");
        // String str = input.nextLine();
        // System.out.println("Character you would like to search: ");
        // char ch = input.nextLine().charAt(0);
        // System.out.println(charSearch(str, ch));

        int[] arr = {12,55,-98,58};
        System.out.println("Min value : "+minValue(arr));
    }

    public static int maxValueInRange(int[] arr1, int start, int end) {
        if(start <= arr1.length && end <=arr1.length){
            int max = arr1[start];
            for(int i=start; i<=end; i++){
                if(arr1[i] >= max){
                    max = arr1[i];
                }
            }
        return max;
        }else{
            System.out.println("Check the index values");
            return -1;
        }
    }

    public static int[] reverseArray(int[] arr){
        for(int i=0;i < arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        return arr;
    }

    // Two pointer method for swaping/ reversing an array
    public static int[] twoPointerSwapping(int[] arr) {
        int startIdx = 0;
        int endIdx = arr.length-1;
        
        while(startIdx < endIdx){
            int temp = arr[startIdx];
            arr[startIdx] = arr[endIdx];
            arr[endIdx] = temp;
            startIdx++;
            endIdx--;
        }
        return arr;
    }

    // Character search

    public static Boolean charSearch(String str, char ch) {
        if(str.length() == 0){
            return false;
        }
        for(int i=0; i < str.length(); i++){
            if(ch == str.charAt(i)){
                return true;
            }
        }

        return false;
    }


    // Print min in an array
    public static String minValue(int[] arr){
        if(arr.length == 0){
            System.out.println("Empty array");
        }
        int min = arr[0];
        for(int i : arr){
            if(i < min){
                min = i;
            }
        }
        return String.valueOf(min);
    }
}
