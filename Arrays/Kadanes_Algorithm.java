package Arrays;

/**
 * Kadanes_Algorithm
 */
public class Kadanes_Algorithm {

    public static void main(String[] args) {
        int[] arr1 = {5, -4, -2, 6, -1};
        int[] arr2 = {-2, -3, 4, -1, -2, 1, 5, -3};
        int[] arr = {-2, 1};
        
        System.out.println("Max Sum sub array: "+kadanes(arr1));
        System.out.println("Max Sum sub array: "+kadanes(arr2));
        System.out.println("Max Sum sub array: "+kadanes(arr));
    }


    // Converts O(N^2) Time Complexity into O(N)
    static int kadanes(int[] arr){

        int maxSum = arr[0];
        int currSum = 0;

        for(int i=0; i < arr.length; i++){
            currSum = currSum + arr[i];
            if(currSum > maxSum){
                maxSum = currSum;
            }

            if(currSum < 0){
                currSum = 0;
            }
        }
        return maxSum;
    }

    
}