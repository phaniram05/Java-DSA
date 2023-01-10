package Recursion;

public class Recursion_Skip_Character{
    public static void main(String[] args){
        skipping_1("", "bcdaaadcb");
        System.out.println(skipping_2("Sai Phani Ram Popuri"));
        System.out.println(skipping_3("Phani Ram Niagara Naigara Popuri"));
    }

    public static void skipping_1(String processed, String unProcessed){
        if(unProcessed.isEmpty()){
            System.out.println(processed);
            return;
        }

        char ch = unProcessed.charAt(0);
        if(ch == 'a'){
            skipping_1(processed, unProcessed.substring(1));
        }else{
            skipping_1(processed + ch, unProcessed.substring(1));
        }

    }


    // Approach 2
    public static String skipping_2(String str){
        if(str.isEmpty()){
            return "";
        }

        char ch = str.charAt(0);

        if(ch == 'a'){
            return skipping_2(str.substring(1));
        }else{
            return ch + skipping_2(str.substring(1));
        }
    }


    // Similar Approach for Skipping a word
    static String word_to_be_Skipped = "Niagara";

    public static String skipping_3(String str){

        if(str.isEmpty()){
            return "";
        }

        if(str.startsWith(word_to_be_Skipped)){
            return skipping_3(str.substring(word_to_be_Skipped.length()));
        }else{
            return str.charAt(0) + skipping_3(str.substring(1));
        }

    }

    }
