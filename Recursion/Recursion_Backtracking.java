package Recursion;
import java.util.ArrayList;
import java.util.Arrays;

public class Recursion_Backtracking {
    public static void main(String[] args) {
        Boolean[][] maze = {
                            {true, true, true},
                            {true, true, true},
                            {true, true, true}
                            };
        // System.out.println(maze_allDirections("", maze, 0, 0));

        int[][] path = new int[maze.length][maze[0].length];
        maze_PathMatrix("", maze, 0, 0, path, 1);        
        
        // rightTriangle(1);
    }


    // Maze problem where Up, Right, Down, Left movements are allowed

    public static ArrayList<String> maze_allDirections(String processed, Boolean[][] maze, int row, int col){
        
        ArrayList<String> res = new ArrayList<String>();
        if(row == maze.length -1 && col == maze[0].length - 1){
            res.add(processed);
            return res;
        }

        if(!maze[row][col]){
            return res;
        }

        maze[row][col] = false;
        // Code for Upward movement

        ArrayList<String> list = new ArrayList<>();
        if(row > 0){
            list.addAll(maze_allDirections(processed+'U', maze, row - 1, col));
        }

        // Right ward movement
        if(col < maze[0].length - 1){
            list.addAll(maze_allDirections(processed+'R', maze, row, col+1));
        }

        // Downward movement
        if(row < maze.length - 1){
            list.addAll(maze_allDirections(processed+'D', maze, row+1, col));
        }

        // Left ward movement
        if(col > 0){
            list.addAll(maze_allDirections(processed+'L', maze, row, col-1));
        }
        maze[row][col] = true;
        return list;
    }

    // Printing Paths
    public static void maze_PathMatrix(String processed, Boolean[][] maze, int row, int col, int[][] path, int step){
    
        if(row == maze.length -1 && col == maze[0].length - 1){
            path[row][col] = step;
            for(int[] arr:path){
                System.out.println(Arrays.toString(arr));     
            }
            System.out.println(processed);
            System.out.println();
            return;
        }

        if(!maze[row][col]){
            return;
        }

        maze[row][col] = false;
        path[row][col] = step;
        
        // Code for Upward movement   
        if(row > 0){
            maze_PathMatrix(processed+'U', maze, row - 1, col, path, step+1);
        }

        // Right ward movement
        if(col < maze[0].length - 1){
            maze_PathMatrix(processed+'R', maze, row, col+1, path, step+1);
        }

        // Downward movement
        if(row < maze.length - 1){
            maze_PathMatrix(processed+'D', maze, row+1, col, path, step+1);
        }

        // Left ward movement
        if(col > 0){
            maze_PathMatrix(processed+'L', maze, row, col-1, path, step+1);
        }
        
        maze[row][col] = true;
        path[row][col] = 0;
    }


    // Print right triangle
    public static void rightTriangle(int basesize){
        if(basesize == 7){
            System.out.println("*******");
            return;
        }
        for(int i = 0; i < basesize; i++){
            System.out.print('*');
        }
        System.out.println();
        rightTriangle(++basesize);
    }

}
