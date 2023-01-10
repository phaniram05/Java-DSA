package Recursion;

import java.util.ArrayList;
import java.util.List;

import Sorting.Sorting;

public class Recursion_Subset {
    public static void main(String[] args) {
        // ArrayList<String> res = print_subsets("", "PHANIRAM");
        // System.out.println(res);
        // System.out.println(count);
        int[] arr = {1, 2, 3};
        List<List<Integer>> res = subset_Iter(arr);
        System.out.println(res);

        int[] arr_duplicate = {5, 5};
    //    List<List<Integer>> res_duplicate_1 = subset_duplicate_1(arr_duplicate);
        List<List<Integer>> res_duplicate_2 = subset_duplicate_2(arr_duplicate);
    //    System.out.println(res_duplicate_1);
        System.out.println(res_duplicate_2);
     }
    

    // recursive Approach
    static int count = 0;
    public static ArrayList<String> print_subsets(String processed, String unProcessed){
        if(unProcessed.isEmpty()){
            ++count;
            ArrayList<String> list = new ArrayList<String>();
            list.add(processed);
            return list;
        }

        
        ArrayList<String> left = print_subsets(processed +  unProcessed.charAt(0), unProcessed.substring(1));
        ArrayList<String> right = print_subsets(processed , unProcessed.substring(1));
        
        left.addAll(right);
        return left;

    }
    

    // Iterative Approach
    /*
    *   Eg Array: [1, 2, 3] ==> [], [1], [2], [3], [1, 2], [2, 3], [1, 3], [1, 2, 3]       
    *                   
            Start:       ans =       [] / [1, 2, 3]
                               
    *   Take first ele 1     []/ [2, 3]             [1] / [2, 3]            (Accept 1 or reject 1)
        Take next ele 2           
    *                     []/ [3]    [2]/ [3]      [1]/[3]      [1, 2]/ [3]  (Accept 2 or reject 2)
        Take next ele 3  
        Final Ans:     [],[3] [2],[2, 3]  [1],[1,3] [1, 2],[1, 2, 3] 
        
    
        Observation:    ans = []
                        Add [1] to ans    ==> ans = [[], [1]]
                        Add [2], [1, 2] to ans  ==> ans = [[], [1], [2], [1,2]]
                        Add [3], [2, 3], [1,3], [1, 2, 3] to ans ==> [[], [1], [2], [1,2], [3], [2, 3], [1,3], [1, 2, 3]]    
    
        Repeat this step for all the elements inside the array

        1 element -- 2 subsets
        2 elements -- 4 subsets
        3 elements -- 8 subsets
        4 elements -- 16 subsets
        Total no of subsets = power(2, N)
        
        Time Complexity = O(# of levels * # of subsets) = O(N * 2^N)

        Space Complexity = O( # of subsets * Space taken by each subset) = O( 2^N * N)


    */


    public static List<List<Integer>> subset_Iter(int[] arr){
        
        List<List<Integer>> outer_list = new ArrayList<>();
        
        // Add initial empty list inside list []
        outer_list.add(new ArrayList<>());

        for(Integer i : arr){
            int size = outer_list.size();
            for(int j = 0; j < size; j++){
                List<Integer> inner_list = new ArrayList<Integer>(outer_list.get(j));
                System.out.println("Inner List: "+inner_list);
                inner_list.add(i);
                outer_list.add(inner_list);
            }
        }      
        return outer_list;
    }


    // Subset with duplicate elements
    /*
    *   Eg: [1, 2, 2]  ==> ans : [[], [1], [2], [1, 2], [2, 2], [1, 2, 2]]

        Breakdown of steps:
            -                                          []
            copy above + add ele 1 into it          []       [1]                
    *       copy above + add ele 2 into it      []    [1]  [2]  [1, 2]
    *       (ele 2 == ele 3)       
    *       copy above + add ele 3 only into prev new lists [2], [1, 2]
                ==> [[], [1], [2], [1, 2], [2, 2], [1, 2, 3]]
            
            Need for SORTING:
            To acheive this duplicate check and subset creation must be adjacent to each other, else it becomes difficult
            to keep a track of newly created lists from above.    
    */

    // My approach: When there is a duplicate, add only to prev. created last 2 lists
    // NOT ACCURATE
    public static List<List<Integer>> subset_duplicate_1(int[] arr){

        if(arr.length == 0){
            System.out.println("Empty Array found");
        }else{
            Sorting.bubbleSorting(arr);
        }

        List<List<Integer>> outer_list = new ArrayList<>();
        outer_list.add(new ArrayList<>());

        for(int i = 0; i < arr.length; i++){
            
            int size = outer_list.size();
            Boolean duplicate_found = false;
            if(i > 0 && arr[i] == arr[i-1]){
                duplicate_found = true;
            }       
                
            Integer counter = 0;
            for(int j = size -1; j >= 0; j--){
                counter++;              
                List<Integer> inner_List;  
                inner_List = new ArrayList<>(outer_list.get(j));                     
                inner_List.add(arr[i]);
                outer_list.add(inner_List);
                if(duplicate_found && counter == 2){
                    break;
                }
            }    
        }
     return outer_list;
    }
 
    // Approach in videos: ACCURATE APPROACH FOR ALL EDGE CASES
    public static List<List<Integer>> subset_duplicate_2(int[] arr){

        if(arr.length == 0){
            System.out.println("Empty Array found");
        }else{
            Sorting.bubbleSorting(arr);
        }

        List<List<Integer>> outer_list = new ArrayList<>();
        outer_list.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for(int i = 0; i < arr.length; i++){
            start = 0;
            int size = outer_list.size();

            if(i > 0 && arr[i] == arr[i-1]){
                start = end + 1;
            }
            end = outer_list.size() - 1;
            
            for(int j = start; j < size; j++){                     
                List<Integer> inner_List;  
                inner_List = new ArrayList<>(outer_list.get(j));                     
                inner_List.add(arr[i]);
                outer_list.add(inner_List);        
            }    
        }
     return outer_list;
    }
}
