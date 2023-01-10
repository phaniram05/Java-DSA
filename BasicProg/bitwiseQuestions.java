package BasicProg;
public class bitwiseQuestions {
    public static void main(String[] args) {
        //System.out.println(addBinary("11", "1")); 
        // String s1 = "111";
        // String s2 = "111";
        // System.out.println(Integer.parseInt("111") == 111);
        // System.out.println(s1 == s2);
        // System.out.println(s1+ " : "+ s1.hashCode());
        // System.out.println(s2+ " : "+ s2.hashCode());
        // for(int i = 0; i < "1010".length(); i++){
        //     System.out.println("1010".charAt(i) - '0');
        // }

        int n = 00000000000000000000000000001011;
        int count = 0;
        String s= Integer.toBinaryString(n);
        System.out.println(Integer.toBinaryString(n));
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) - '0' == 1){
                count++;
            }
        }
        System.out.println(count);

        String str = "+101111000101011"; 
        System.out.println(Long.parseLong(str, 2));

        System.out.println( 4 ^ 7); 
        System.out.println(Integer.toBinaryString( 4 ^ 7));
        //System.out.println(Integer.toBinaryString(1)); 

        System.out.println(Integer.toBinaryString((1 << 32) ));

        System.out.println(5 ^ 6);
        System.out.println(5 ^ 9);
        

    }

    public static String addBinary(String a, String b) {
        
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1; 
        int j = b.length() - 1;
        int carryFwd = 0;
        while(i >= 0 || j >= 0){
            int sum = carryFwd;
            if(i >= 0){
                sum += a.charAt(i--) - '0';
            }
            if(j >= 0){
                sum += b.charAt(j--) - '0';
            }

            carryFwd = sum > 1 ? 1 : 0; 
            res.append(sum % 2);
        }
        if(carryFwd != 0) res.append(carryFwd);
        return res.reverse().toString();        
    }
   
}
