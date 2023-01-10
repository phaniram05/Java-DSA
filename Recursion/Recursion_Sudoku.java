package Recursion;
import java.util.Arrays;

public class Recursion_Sudoku {
    public static void main(String[] args) {

        int[][] grid = { { 3, 1, 6, 5, 7, 8, 4, 9, 2 },
                        { 5, 2, 9, 1, 3, 4, 7, 6, 8 },
                        { 4, 8, 7, 6, 2, 9, 5, 3, 1 },
                        { 2, 6, 3, 0, 1, 5, 9, 8, 7 },
                        { 9, 7, 4, 8, 6, 0, 1, 2, 5 },
                        { 8, 5, 1, 7, 9, 2, 6, 4, 3 },
                        { 1, 3, 8, 0, 4, 7, 2, 0, 6 },
                        { 6, 9, 2, 3, 5, 1, 8, 7, 4 },
                        { 7, 4, 5, 0, 8, 6, 3, 1, 0 } };

        int[][] allZeros = new int[9][9];

        if(sudokuSolver(allZeros)){
            System.out.println("Solved !!");
            display(allZeros);
        }                    
        // System.out.print(Arrays.toString(sumList));
        System.out.println(count);
    }   
    
    static int count=0;
    
    public static boolean sudokuSolver(int[][] grid){  

        // Finding the blank cells in the grid
        
        int n = grid.length;
        Boolean isSolved = true;
        int r = 0;
        int c = 0;
        
        // Finding an empty cell
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                r = row;
                c = col;
                if(grid[row][col] == 0){
                    isSolved = false;
                    break;
                }
            }
            if(!isSolved){
                break;
            }
        }

        if(isSolved){
            return true;
        }

        // Backtracking starts here
        for(int ele = 1; ele <= 9; ele++){
            if(isSafe(grid, r, c, ele)){
                grid[r][c] = ele;
                if(sudokuSolver(grid)){
                    count++;
                    return true;
                }else{
                    grid[r][c] = 0;
                }
            }
        }

        return false;
    }

    public  static boolean isSafe(int[][] grid, int row, int col, int ele){

        // Check Horizontally 
        for(int i = 0; i < grid.length; i++){
            if(grid[row][i] == ele){
                return false;
            }
        }

        // Check vertically
        for(int j = 0; j < grid.length; j++){
            if(grid[j][col] == ele){
                return false;
            }
        }

        // Check in the box size sqrt(n) * sqrt(n)
        int r_start = 0;
        int r_end = 0;
        int c_start = 0;
        int c_end = 0;
        
        int boxSize = (int) Math.sqrt(grid.length);
        r_start = row - (row % boxSize);
        r_end = r_start + boxSize - 1;
        c_start = col - (col % boxSize);
        c_end = c_start + boxSize - 1;

        for(int p = r_start; p <= r_end; p++){
            for(int q = c_start; q <= c_end; q++){
                if(grid[p][q] == ele){
                    return false;
                }
            }
        }

        return true;
    }


    // display grid
    static int[] sumList = new int[9];  
    public static void display(int[][] grid){
        int n = grid.length;
        for(int r = 0; r < n; r++){
            int sum = 0;
            for(int c = 0; c < n; c++){
                sum += grid[r][c];
                System.out.print(grid[r][c]+" ");
            }
            sumList[r] = sum;
            System.out.println();
        }
    }

}
