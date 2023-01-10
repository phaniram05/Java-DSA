package BasicProg;
import java.util.Scanner;

// This is the SOURCE CODE file
// To Convert this to BYTE CODE type "javac <fileName.java>" in the command prompt
// This will create <fileName.class> file which is the Byte code (We cannot understand)
public class Main {
    // String[] args : Command-line arguments
    // java Main "Phani" "Ram" 30..    ["Phani", "Ram", "30" ...] will be stored in the args 
    static int x = 90; // top level variable
    public static void main(String[] args) {
        
        // Primitives : Which cannot be further divided. int, char, float, double, long, boolean
        // String = "PHANI" non-primitive because "PHANI" can be further divided into 'P', 'H', 'A', 'N', 'I'
        
        // By default all decimal values are double unless we add 'f' at the end
        // By default all integer values are int unless we add 'L' at the end
       

        // Scanner input = new Scanner(System.in);
        // System.out.print("Please Enter temperature in deg C : ");
        // float tempC = input.nextFloat();

        // float tempF = (tempC * 9/5) +32;
        // System.out.println("Temp in Fahrenheit is : "+tempF);

        // System.out.println("Phani Ram popuri ...");
        //Fibonacci_No(15);
        // System.out.print("Please enter a valid string : ");
        // Scanner input = new Scanner(System.in);
        // String reversedString = reverseString(input.next());
        // System.out.println("Reversed String : "+reversedString);

        // System.out.println(armStrong(370));
        // System.out.println(nth_Fibonacci(13));
        // System.out.println(calcDigitOccurences(256889558, 8));
        // System.out.println(palindrome(122));
        //System.out.println(prod_minus_sum(1234));
        
        // System.out.print("Enter any fictional character : ");
        // Scanner input = new Scanner(System.in);
        // String fictionalCharacter = input.nextLine();

        //  we can achieve the same using the if-else condition
        //  But, if checks every condition in sequence and executes. 
        //  switch case directly jumps to the respective case 

        // switch (fictionalCharacter) {
        //     case "HarryPotter":
        //         System.out.println("JK Rowling");    
        //         break;
        //     case "SpiderMan":
        //         System.out.println("Stan Lee");
        //         break;
        //     case "MickeyMouse":
        //         System.out.println("Walt Disney");
        //         break;
        //     case "Tom and Jerry":
        //         System.out.println("Cartoon Network");
        //         break; // if we dont break, it will execute the next case as well.
        //     default:
        //         System.out.println("no matching character found");
        //         break;
        // }


        // int a = 10;
        // int b = 20;
        // trickyMethod(a, b);
        // System.out.println(a + " "+ b);

        // int[] arr1 = {55, 56, 57};
        // for(int i = 0; i<arr1.length; i++){
        //     System.out.println("Array element before change : "+arr1[i]);
        // }
        // changeMethod(arr1);
        // for(int i = 0; i<arr1.length; i++){
        //     System.out.println("Array element after change : "+arr1[i]);
        // }
    //    int x = 80; // variabe inside main 
        System.out.println("Printing x : "+x);
        // First checks within the main for 'x' if not found checks at higher scope.

        System.out.println(isPrime(8));

        //listArmstrong();

        
        Scanner in = new Scanner(System.in);
        int sum = 0;
        while(true){
            System.out.print("Enter a number : ");
            int num = in.nextInt();
            if(num == 0){
                break;
            }else{
                sum+= num;
            }
        }
        System.out.println("Sum of all numbers entered : "+sum);


}

    public static void test(int num, int divisor){
        if(num % divisor == 0){
            System.out.println(num +" is divisible by "+divisor);
        }else{
            System.out.println(num +" is not divisible by "+divisor);
        }

    }

    // Program to print upto n Fibonacci numbers
    public static void Fibonacci_No(int n){
        int a = 0;
        int b = 1;
        int counter = 0;    
        while(counter < n){
            System.out.print(a+" ");
            int c = a+b;
            a=b;
            b=c;
            counter++;
        }
    } 

    // String reverse
    public static String reverseString(String name){
        if(name.isEmpty()){
            return "Please enter a non-empty String";
        }
        String revString = "";
        for(int i=name.length()-1;i>=0; i--){
            revString += name.charAt(i);
        }
        return revString;
    }

    // Armstrong number
    public static String armStrong(int n) {
        if(n==1){
            return "Armstrong number";
        }else{
            // Count digits
            int no_of_digits = (int) Math.log10(n) + 1;
            int storeInt = n;
            int sum = 0;
            int rem = 0;
            while(n > 0){
                rem = n%10;
                sum += Math.pow(rem, no_of_digits);
                n = n/10;
            }
            if(sum == storeInt){
                return "Armstrong";
            }return "Not an Armstrong";
        }   
    }

    public static int nth_Fibonacci(int n){
        if(n==1){
            return 0;
        }if(n==2 || n==3){
            return 1;
        }else{
            int a=0, b=1;
            int res=0;
            for(int count=0;count<n-2;count++){
                res = a+b;
                a=b;
                b=res;
            }return res;
        }
    }

    public static int calcDigitOccurences(int n, int interested){
        // String intToString = String.valueOf(n);
        // int countOfInterested = 0;
        // System.out.println("int to String converted : "+intToString);
        // for(int i=0;i<intToString.length();i++){
        //     if(intToString.charAt(i) == String.valueOf(interested).charAt(0)){
        //         countOfInterested++;
        //     }
        // }
        // return countOfInterested;
        int noOfOccurences = 0;
        while(n>0){
            int remainder = 0;
            remainder = n%10;
            n = n/10;
            if(remainder == interested){
                noOfOccurences++;
            }
        }  return noOfOccurences;  

    }



    // Reverse of a number
    public static String palindrome(int n) {
        int store = n;
        int revInt = 0;
        int rem = 0;
        while(n > 0){
            rem = n%10;
            revInt = revInt*10 + rem;
            n = n/10;
        }if(revInt == store){
            return "PALINDROME";
        }return "NOT A PALINDROME";
    }

    // Product - sum of individual digits in a number
    public static int prod_minus_sum(int n) {
        int prod = 1;
        int sum = 0;
        while(n > 0){
            int rem = 0;
            rem = n%10;
            prod *= rem;
            sum += rem;
            n = n/10;
        }
        return prod-sum;
    }

    public static void tables() {
        // Multiplication tables
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        for(int i=1;i<11;i++){
        System.out.println(number+" * "+i + " = " +number*i);
        }
    }


    public static void trickyMethod(int a, int b) {
        a += 10;
        b += 10;
    }

    // Pass b value original object change
    public static void changeMethod(int[] arr) {
        arr[0] = 3;
    }

    // Prime number function
    public static boolean isPrime(int n){
        if(n <= 1){
            return false;
        }else{
            // check until (<=) square_root(n)
            int idx = 2;
            while(idx*idx <= n){
                if(n%idx == 0){
                    return false;
                }
                idx++;
            }
        }
        return true;
    }

    // All 3 digit armstrong numbers

    public static void listArmstrong(){
        for(int i=1000;i<=9999;i++){
            int sum = 0;
            int idx = i;
            while(idx > 0){
                int rem=0;
                rem = idx%10;
                sum += rem*rem*rem*rem;
                idx = idx/10;    
            }
            if(sum == i){
                System.out.print(i + " - ");
            }
        }
    }

}
