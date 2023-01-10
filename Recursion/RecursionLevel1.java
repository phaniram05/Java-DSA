package Recursion;

public class RecursionLevel1 {
    public static void main(String[] args) {
        //foo(5);
        //fooRev(5);
        System.out.println(factorial(4));
        System.out.println(reverse(10001, 0));
    }


    // Print numbers from N to 1 given N
    public static void fooRev(int N) {
        if(N == 0){
            return;
        }
        // printing N while the call stack is filling
        System.out.println(N);
        fooRev(N-1);
    }


    // Print numbers from 1 to N given N
    public static void foo(int N) {
        if(N == 0){
            return;
        }
        foo(N-1);
        // printing N while the call stack is clearing
        System.out.println(N);
    }


    // Factorial of a number
    public static int factorial(int N) {
        if(N == 0 || N == 1){
            return 1;
        }
        return N * factorial(N-1);
    }

    public static int reverse(int n, int residue) {
        if(n == 0){
            return residue+ n;
        }
        return reverse(n / 10, residue * 10 + (n % 10));
    }
}
