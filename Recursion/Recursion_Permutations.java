package Recursion;

import java.util.ArrayList;

public class Recursion_Permutations{
    public static void main(String[] args) {
        System.out.println(permutations("", "RAM"));
    }

    // substring(startIdx, endIdx) ==> [startIdx, endIdx) 
    public static ArrayList<String> permutations(String processed, String unprocessed) {
        
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list; 
        }

        ArrayList<String> store = new ArrayList<String>();
        char ch = unprocessed.charAt(0);
        for(int i=0; i <= processed.length(); i++){         
            String first = processed.substring(0, i);
            String second = processed.substring(i, processed.length());
            store.addAll(permutations(first + ch +second, unprocessed.substring(1)));          
        }
        return store;
    }
}
