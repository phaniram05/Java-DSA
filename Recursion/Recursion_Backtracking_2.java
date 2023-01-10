package Recursion;
public class Recursion_Backtracking_2 {
    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];
        // System.out.println(N_Queens(board, 0)); 
        
        // N_Knights(board, 0, 0, 4);



    }

    public static int N_Queens(boolean[][] board, int row){

        // Base Condition
        if(row == board.length){
            printBoard(board, 'Q');
            System.out.println();
            return 1;
        }

        int count = 0;

        for(int col = 0; col < board[0].length; col++){
            // For a given row, Queen will sweep all the columns
            if(isSafe(board, row, col)){
                board[row][col] = true;
                count += N_Queens(board, row+1);
                board[row][col] = false;
            } 
        }
        return count;
    }

    public static void printBoard(boolean[][] board, char ch){
        for(boolean[] row : board){
            for(boolean cell : row){
                if(cell){
                    System.out.print(ch+" ");
                }else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    public static boolean isSafe(boolean[][] board, int row, int col){

        // Left cross Check
        if(row > 0 && col > 0){
            for(int leftCross = 1; leftCross <= Math.min(row, col); leftCross++){
                if(board[row-leftCross][col-leftCross]){
                    return false;
                }
            }
        }
        
        // Upward Check
        if(row > 0){
            for(int up = 1; up <= row; up++){
                if(board[row-up][col]){
                    return false;
                }
            }
        }
        
        // Right Cross Check
        if(row > 0 && col < board[0].length - 1){
            for(int rightCross = 1; rightCross <= Math.min(row, board[0].length - col - 1); rightCross++){
                if(board[row-rightCross][col+rightCross]){
                    return false;
                }
            }
        }
        
        return true;
    }


    // N Knights problem
    public static void N_Knights(boolean[][] board, int row, int col, int knights){

        if(knights == 0){
            printBoard(board, 'K');
            System.out.println();
            return;
        }

        if(row == board.length - 1 && col == board.length){
            return;
        }

        if(col == board[0].length){
            N_Knights(board, row+1, 0, knights);
            return;
        }

        if(safePos(board, row, col)){
            board[row][col] = true;
            N_Knights(board, row, col+1, knights -1);
            board[row][col] = false;
        }

        N_Knights(board, row, col+1, knights);
    }

    // check for safe position of a Knight
    public static boolean safePos(boolean[][] board, int row, int col){

        if(withInBounds(board, row-2, col-1)){
                // Up Up Left
            if(board[row-2][col-1]){
                return false;
            }
        }
        

        if(withInBounds(board, row-2, col+1)){
                // Up Up Right
            if(board[row-2][col+1]){
                return false;
            }
        }
        

        if(withInBounds(board, row-1, col-2)){
                // Up Left Left
            if(board[row-1][col-2]){
                return false;
            }
        }
        

        if(withInBounds(board, row-1, col+2)){
                // Up Right Right
            if(board[row-1][col+2]){
                return false;
            }
        }   
        return true;
    }

    public static boolean withInBounds(boolean[][] board, int row, int col){

        if(row >= 0 && row <= board.length - 1 && col >= 0 && col <= board.length - 1 ){
            return true;
        }
        return false;
    }
}
