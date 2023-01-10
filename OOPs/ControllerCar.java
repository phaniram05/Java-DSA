package OOPs;

public class ControllerCar {

    private Engine engine;
    
    public ControllerCar(){
        engine = new ElectricEngine();
    }

    public ControllerCar(Engine engine){
        this.engine = engine;
    }

    public interface test{
        int sum(int x, int y);
    }


    public static void main(String[] args) {
        
        // The problem is when we have the similar name methods, it causes problem
        Media carMedia = new Automobile(); 
        carMedia.start();
        carMedia.stop();

        // Solution is to create classes that implement Engine and Media 

        Engine engine = new PowerEngine();
        ControllerCar newCar = new ControllerCar(engine);
        newCar.engine.start();
        newCar.engine.stop();


        // Call the method from class C
        ControllerCar obj = new ControllerCar.C();
        obj.sum(5, 6);
        C.greet();

        // Call from clss B
        B obj2 = new B();
        obj2.sum(1, 3);

    }

    static class C extends ControllerCar implements test{

        int c;
        C(){
            super();
            this.c = 12345; 
        }

        @Override
        public int sum(int p, int q){
            System.out.println("From C > sum()");
            return p+q;
        }

        static void greet(){
            System.out.println("Hello from static C method");
        }

    }

    public int sum(int x, int y){
        System.out.println("From A > sum()");
        return x+y;
    }


}


// I want to use the sum(x, y) method from the interface test
class B implements ControllerCar.test{

    @Override
    public int sum(int x, int y){
        System.out.println("From B > sum()");
        return x+y;
    }

}