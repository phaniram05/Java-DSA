package Recursion;
import java.util.ArrayList;
public class Recursion_Maze {
    public static void main(String[] args) {
    //    System.out.println(right_down_paths(0, 0, 4)); 
    //    System.out.println(r_d_return("", 0, 0, 4));
    //    System.out.println(r_b_diag_return("", 0, 0, 3));

    Boolean[][] maze = {
                        {true, true, true }, 
                        {true, false, true}, 
                        {true, true, true}
                    };
    maze_Obstacles("", 0, 0, maze);


    }

    /*
     *  Given a matrix of size 'n'. Count how many ways to travel from (0, 0) till (n, n) 
     *                              by moving either RIGHT or DOWN  (No diagonal/ UP/ LEFT)    
     */
    public static int right_down_paths(int row, int col, int size){

        if(row == size-1 || col == size-1){
            return 1;
        }
        return right_down_paths(row, col+1, size) + right_down_paths(row+1, col, size);
    }

    // Above problem return an ArrayList

    public static ArrayList<String> r_d_return(String processed, int row, int col, int size) {

        ArrayList<String> res = new ArrayList<>();
        if(row == size-1 && col == size-1){
            res.add(processed);
            return res;
        }

        ArrayList<String> right_list = new ArrayList<>();
        ArrayList<String> down_list = new ArrayList<>();
        if(col < size-1){
            right_list = r_d_return(processed+'R', row, col+1, size);
        }
         
        if(row < size-1){
            down_list = r_d_return(processed+'D', row+1, col, size);
        }

        right_list.addAll(down_list);
        return right_list;
    }

    // Allow diagonal travel as well
    // Simple: Except at last row/ last col reduce both row & col by 1
    public static ArrayList<String> r_b_diag_return(String processed, int row, int col, int size) {

        ArrayList<String> res = new ArrayList<>();
        if(row == size-1 && col == size-1){
            res.add(processed);
            return res;
        }

        ArrayList<String> list1 = new ArrayList<>();

        // Diagonal
        if(row < size-1 && col < size-1){
            list1.addAll(r_b_diag_return(processed+'D', row+1, col+1, size));
        }
        // Right
        if(col < size-1){
            list1.addAll(r_b_diag_return(processed+'H', row, col+1, size));
        }
        // Bottom
        if(row < size-1){
            list1.addAll(r_b_diag_return(processed+'V', row+1, col, size));
        }

        return list1;
    }


    // Maze problem with obstacles 
    // We will be given a Boolean array, we have to skip the recursion call at that point
    /*                       0     1      2
        Boolean [] [] =  0 true  true   true
                         1 true  false  true 
                         2 true  true   true  

        From the above, when we are at position (1,1) skip recursion                   
    */  

    public static void maze_Obstacles(String processed, int row, int col, Boolean[][] maze) {

        if(row == maze.length - 1 && col == maze[0].length -1){
            System.out.println(processed); 
            return;
        }

        if(!maze[row][col]){
            return;
        }

        if(row < maze.length -1 && col < maze[0].length - 1){
            maze_Obstacles(processed + 'D', row+1, col+1, maze);
        }

        if(col < maze[0].length -1){
            maze_Obstacles(processed+'H', row, col+1, maze);
        }
         
        if(row < maze.length - 1){
            maze_Obstacles(processed+'V', row+1, col, maze);
        }
    }


}
