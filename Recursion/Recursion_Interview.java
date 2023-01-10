package Recursion;

import java.util.ArrayList;

public class Recursion_Interview {
    public static void main(String[] args) {
        // dialPad("", "12");  
        // ArrayList<String> finalList = dialPad_Return("", "1234");
        // System.out.println(finalList);
        // System.out.println("Total count of given combination: "+count("", "1234"));
        System.out.println(dice_permutations("", 7, 7).size()) ;
    }

    // Modified Letters of a Phone number
    // Note: This is not the Leet code one, there is a difference
    /*
        Google Interview  
     *          1       2       3 
     *         abc     def     ghi
     *      
     *          4       5       6
     *         jkl     mno     pqr
     * 
     *          7       8       9  
     *         stu     vwx     yz     
     * 
     *    Input: "23" ==> Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"] 
     *    By pressing 1 we can get a/b/c
     *                2 we can get d/e/f  and we need combinations possible             
     */

    
    public static void dialPad(String processed, String unProcessed){
        if(unProcessed.isEmpty()){
            System.out.println(processed);
            return;
        }
    
        int digit = unProcessed.charAt(0) - '0';
        for(int i = 3 * (digit - 1); i < 3 * digit; i++){
            char ch = (char) ('a' + i);
            dialPad(processed+ ch, unProcessed.substring(1));
        }  
    }

    // This method returns the list of all possible combinations
    public static ArrayList<String> dialPad_Return(String processed, String unProcessed){
                
        if(unProcessed.isEmpty()){
            ArrayList<String> res = new ArrayList<String>();
            res.add(processed);
            return res;
        }
    
        ArrayList<String> list = new ArrayList<>();
        int digit = unProcessed.charAt(0) - '0';
        for(int i = 3 * (digit - 1); i < 3 * digit; i++){
            char ch = (char) ('a' + i);
            list.addAll(dialPad_Return(processed+ ch, unProcessed.substring(1)));
        }
        return list;  
    }


    // Return total count of combinations
    public static int count(String processed, String unProcessed){
                
        if(unProcessed.isEmpty()){     
            return 1;
        }
    
        int count = 0;
        int digit = unProcessed.charAt(0) - '0';
        for(int i = 3 * (digit - 1); i < 3 * digit; i++){
            char ch = (char) ('a' + i);
            count = count + count(processed+ ch, unProcessed.substring(1));
        }
        return count;  
    }



    /*
        Amazon
     *  Problem 2: Dice throw combinations 
     * 
     *  Given a fair dice and a target, find all the possible permutations of dice
     *  Eg: Target = 4
     *  Possible outcomes: 
     *  1 1 1 1
     *  1 2 1
     *  2 1 1
     *  1 1 2
     *  1 3
     *  3 1 
     *  2 2
     *  4
     * 
     */

    public static ArrayList<String> dice_permutations(String processed, int target, int faces){
        if(target == 0){
            ArrayList<String> res = new ArrayList<String>();
            res.add(processed);
            return res;
        }

        ArrayList<String> list = new ArrayList<>();
        for(int i = 1; i <= target && i <= faces; i++){
            list.addAll(dice_permutations(processed+i, target-i, faces));
        }
    return list;
    }


}
