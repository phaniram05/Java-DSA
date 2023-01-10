package BasicProg;
public class GCD_LCM{
    public static void main(String[] args) {
        int a = 105, b = 224;
        System.out.println("GCD of "+a+" and "+b+" is : "+gcd(a,b));
        System.out.println("LCM of "+a+" and "+b+" is : "+lcm(a,b));
    }

    public static int gcd(int a, int b){
        if(a == 0){
            return b;
        }
        return gcd(b % a, a);
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

}
