package BasicProg;
public class Patterns {
    public static void main(String[] args) {
        // pattern1(6);
        // pattern2(7);
        // pattern3(11);
        // pattern4(5);
        // pattern5(6);
        // pattern6(9);
        // pattern7(7);
        // pattern8(6);
        // pattern9(5);
        // pattern10(5);
        // pattern11(7);
        // pattern12(6);
        // pattern13(6);
        //pattern14(6);
        //pattern15(6);
        pattern16(7);

        System.out.println(2/3);
    }

    public static void pattern1(int N) {
        for(int i=1; i <= N; i++){
            for(int j= 1; j <= N - i + 1; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern2(int N) {
        for(int row = 1; row <= N; row++){
            for(int col = 1; col <= row; col++){
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }

    public static void pattern3(int N) {
        int col = -1;
        for(int row = 1; row <= N; row++){
            if(row <= N/2 + 1){
                col = row;
            }else{
                col = N - row + 1;
            }
            for(int j = 1; j <= col; j++){
                System.out.print("* ");
            }
            System.out.println();
        }    
    }

    public static void pattern4(int n) { // n : rows of half pattern 
        
        int cols = 0;
        int spaces = 0;
        for(int row = 1; row <= 2*n -1 ; row++){
            spaces = Math.abs(n - row);
            cols = row >= n ? 2*n - row : row;
            for(int s = 1; s <= spaces; s++){
                System.out.print(" ");
            }

            for(int c = 1; c <= cols ; c++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    public static void pattern5(int N) {
        
        int spaces = 0;
        int nums = 0;
        for(int row = 1; row <= N; row++){
            spaces = N - row;
            nums = row;
            for(int s = 1; s <= spaces; s++){
                System.out.print("  ");
            }

            for(int bwd = nums; bwd >= 1; bwd--){
                System.out.print(bwd+" ");    
            }

            for(int fwd = 2; fwd <= nums; fwd++){
                System.out.print(fwd+" ");    
            }


            System.out.println();
        }
    }

    public static void pattern6(int n) {
        int spaces = 0;
        int nums = 0;

        for(int row = 1; row <= 2*n - 1; row++){
            spaces = Math.abs(n - row);
            nums = row >= n ? 2*n - row : row;

            for(int s = 1; s <= spaces; s++){
                System.out.print("  ");
            }

            for(int bwd = nums; bwd >= 1; bwd--){
                System.out.print(bwd+" ");
            }

            for(int fwd = 2; fwd <= nums; fwd++){
                System.out.print(fwd+" ");
            }
        System.out.println();
        }
    }

    // Superb logic
    public static void pattern7(int N) {
        int n = N/2;
        for(int row = 0; row < N; row++){
            for(int col = 0; col < N; col++){
                System.out.print(1 + n - Math.min(Math.min(row, col), Math.min(N - 1 - row, N - 1 - col))+" ");
            }
            System.out.println();
        }     
    }


    public static void pattern8(int n) {
        int spaces = 0;        
        int stars = 0;
        for(int row = 1; row <= 2*n; row++){
            spaces = row > n ? 2*n - row : row - 1;
            stars = row > n ? Math.abs(row - n) : n-row+1;

            for(int s = 1; s <= spaces; s++){
                System.out.print(" ");
            }
            for(int star = 1; star <= stars; star++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    public static void pattern9(int n) {
        int spaces = 0;
        int stars = 0;
        for(int row = 1; row <= 2*n - 1; row++){
            spaces = Math.abs(n - row);
            stars = row >= n ? 2*n - row : row;
            for(int s=1; s <= spaces; s++){
                System.out.print(" ");
            }
            for(int star = 1; star <= stars; star++){
                System.out.print("* ");
            }    
            System.out.println();
        }
    }


    public static void pattern10(int n) {
        int stars = 0;
        int spaces = 0;
        for(int row=1; row <= 2*n; row++){
            stars = row <= n ? n - row + 1 : Math.abs(n - row);
            spaces = 2*n - 2*stars;
            for(int star=1; star <= stars; star++){
                System.out.print("*");
            }

            for(int s = 1; s <= spaces; s++){
                System.out.print(" ");
            }
                  
            for(int star=1; star <= stars; star++){
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void pattern11(int n) {
        int spaces = 0;
        int stars = 1;
        int internalSpaces = 1;
        for(int row = 1; row <= n; row++){
            spaces = n - row;
            stars = row < n ? (row > 1 ? 2 : 1) : 2*n -1;
            internalSpaces = row < n ? (row > 1 ? internalSpaces+2 : 0) : 0;
            for(int s = 1; s <= spaces ; s++){
                System.out.print(" ");
            }

            for(int star=1; star <= stars; star++){
                System.out.print("*");
                for(int i = 1; i < internalSpaces; i++){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static void pattern12(int n) {
        int value = 1;
        for(int row = 1; row <= n ; row++){
            for(int col = 1; col <= row; col++){
                System.out.print(value+" ");
                value++;
            }
            System.out.println();
        }
    }

    public static void pattern13(int n) {

        int value = 1;
        for(int row = 1; row <= n; row++){
            for(int col = 1; col <= row; col++){
                if(row % 2 == 0){
                    value = col % 2 == 0 ? 1 : 0;
                    System.out.print(value + " ");
                }else{
                    value = col % 2 == 0 ? 0 : 1;
                    System.out.print(value + " ");
                }
                
            }
            System.out.println();
        }
    }


    public static void pattern14(int n) {
        for(int row = 1; row <= n; row++){
            for(int col = n - row + 1; col >= 1; col--){
                System.out.print(row+" ");
            }
            System.out.println();
        }
    }

    public static void pattern15(int n) {
        
        int stars = -1;
        int spaces = -1;
        for(int row = 1; row <= 2*n - 1; row++){
            stars = row > n ? 2*n - row : row;
            spaces = 2*n - 2*stars;
            for(int col = 1; col <= stars; col++){
                System.out.print("*");
            }

            for(int space = 0; space < spaces; space++){
                System.out.print(" ");
            }

            for(int col = 1; col <= stars; col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Pascal's triangle
    public static void pattern16(int N) {
        
        int spaces = 0;
        int value = 1;
        for(int row=0; row < N; row++){

            spaces = N - row;
            for(int s = 1; s <= spaces; s++){
                System.out.print(" ");
            }
            for(int col = 0; col <= row; col++){
                if(row == 0 || col == 0){
                    value = 1;
                }else{
                    value = value * (row - col + 1)/col;
                }
                System.out.print(value+" ");
            }
            System.out.println();
        }
    }






}
