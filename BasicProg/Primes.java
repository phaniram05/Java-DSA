package BasicProg;
public class Primes {
    public static void main(String[] args) {
        int N = 100;
        boolean[] primes = new boolean[N+1]; // By default all values are false 
        // sieveOfErathosthenis(N, primes);
        // generic();

        System.out.println(binarySearchSQRT(40, 3));
        System.out.println("Newton Raphson root : "+newtonRaphsonSQRT(40));
        
    }


    public static void generic() {
        int N = 100;
        // ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=2; i <= N; i++){
            int count = 0;
            for(int j = 2; j < i; j++){
                if(i % j == 0){
                    count++;
                }
            }
            if(count == 0){
                
                System.out.print(i + " ");
            }
    
        }
    }


    public static void sieveOfErathosthenis(int N, boolean[] primes) {
        for(int i = 2; i * i <= N; i++){
            if(!primes[i]){
                for(int k = i*2; k <= N; k+=i){
                    primes[k] = true;
                }
            }
        }
        
        for(int i=2; i <= N; i++){
            if(!primes[i]){
                System.out.print(i + " ");
            }
        }
    }



    public static double binarySearchSQRT(int N, int precision) {
        
        int start = 0;
        int end = N;

        while(start <= end){
            int mid = start + (end - start)/2;
            int prod = mid * mid;
            if(prod == N){
                return (double)mid;
            }else if(prod < N){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        double res = end;
        double incr = 0.1;
        res += incr;
        
        for(int i = 0; i < precision; i++){
            while(res * res <= N){
                 res += incr;
            }
            res -= incr; 
            incr /= 10;
        }
    return res;
    }

    // Newton Raphson
    public static double newtonRaphsonSQRT(int N) {
        
        double guess = N;       
        double root;
        while(true){
            root = 0.5 * (guess + (N / guess));
            if(Math.abs(guess - root) == 0){
                break;
            }
            guess = root;
        }
    return root;
    }


}
