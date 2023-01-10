package BasicProg;
/**
 * MathsForDSA
 */
public class MathsForDSA {
    public static void main(String[] args) {
        // int[] arr = {3, 5, 7, 9, 2, 9, 7, 5, 3};
        // System.out.println(nonRepeatElement(arr)); 
        int n = 45;
        System.out.println(Integer.toBinaryString(n & -n));
        System.out.println(noOfSetBits(n));
    }   


    public static int nonRepeatElement(int[] arr) {
        int res = arr[0];
        for(int i = 1; i < arr.length; i++){
            res = res ^ arr[i];
        }
        return res;
    }

    
    public static int noOfSetBits(int n) {
        int count = 0;
        while(n > 0){
            count++;
            n = n - (n & -n);
            System.out.println(n +" : "+Integer.toBinaryString(n));
        }
        return count;
    }


}