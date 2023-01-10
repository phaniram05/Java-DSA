package Arrays;

import java.util.Arrays;

public class Generic_CustomArrayList<T> {
    public Object[] data;
    public static final int DEFAULT_SIZE = 10;
    public int size =0;

    public Generic_CustomArrayList(){
        this.data = new Object[DEFAULT_SIZE];
    }

    // Adding an element at the end
    public void add(T value){
        // Checks if the data array is full
        if(isFull()){
            // If full resize
            resize();
        }
        data[size++] = value;
    }
    
    public Boolean isFull(){
        return size ==  data.length;
    }

    public void resize(){
        Object[] temp = new Object[data.length * 2];
        for(int i=0; i < data.length; i++){
            temp[i] =  data[i];
        }
        data = temp;
    }
    
    // Remove the last element
    public T remove(){
        T lastEle = (T) (data[--size]);
        return lastEle;
    }

    // Set an element
    public void set(int idx, T value) {
        data[idx] = value;
    }

    // Get an element at an idx
    public T get(int idx){
        return (T) (data[idx]);
    }


    @Override
    public String toString(){
        return Arrays.toString(data);
    }

    public static void main(String[] args) {
        Generic_CustomArrayList<String> obj = new Generic_CustomArrayList<>();
        System.out.println("From Generic CustomArrayList<String> ");
        obj.add("Ram");
        obj.add("Sita");
        obj.add("Laxman");
        obj.add("Hanuman");

        System.out.println(obj);
        System.out.println(obj.remove());
        System.out.println(obj);
        obj.add("Ravana");
        System.out.println(obj);
        obj.set(0, "Vishnu");
        System.out.println(obj);
        System.out.println(obj.get(3));

        // Trying with Integer
        Generic_CustomArrayList<Integer> obj2 = new Generic_CustomArrayList<>();
        System.out.println("From Generic CustomArrayList<Integer>");
        obj2.add(12);
        obj2.add(13);
        obj2.add(41);
        obj2.add(-254);

        System.out.println(obj2);
        System.out.println(obj2.remove());
        System.out.println(obj2);
        obj2.add(124);
        System.out.println(obj2);
        obj2.set(0, 25);
        System.out.println(obj2);
        System.out.println(obj2.get(3));
        
    }
}
