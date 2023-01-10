package OOPs;

public class Automobile implements Brake, Engine, Media{
    
    public static void main(String[] args) {
        ControllerCar obj = new ControllerCar.C();
        int res = obj.sum(21, 12);
        System.out.println("res from Automobile class"); 
        
        ControllerCar.C.greet();
    }
    
    


    Automobile(){

    }

    @Override
    public void brake(){
        System.out.println("Inside Braking method");
    }

    @Override
    public void start(){
        System.out.println("Inside Engine start");
    }

    @Override
    public void stop(){
        System.out.println("Inside Engine stop");
    }

    @Override
    public void accelerate() {
        System.out.println("Inside accelerate method");   
    }

    // @Override
    // public void startMedia(){
    //     System.out.println("Inside media start");
    // }

    // @Override
    // public void stopMedia(){
    //     System.out.println("Inside media stop");
    // }

}
