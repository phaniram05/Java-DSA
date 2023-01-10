package BasicProg;
public class factors {
    public static void main(String[] args) {
        factorsBruteforce(50);
        factorsOptimized(36);

    }


    // Complexity O(N)
    public static void factorsBruteforce(int N) {
        for(int i = 1; i <= N; i++){
            if(N % i == 0){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // Optimised search

    public static void factorsOptimized(int N) {
        for(int i = 1; i * i <= N; i++){
            if(N % i == 0){
                if(N/i == i){
                    System.out.print(i);
                }else{
                    System.out.print(i+" "+ N/i+" ");
                }
                
            }
        }
    }

}
