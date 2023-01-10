package Arrays;

import java.util.Arrays;

public class CustomArrayList {
    
    public int[] data;
    public static final int DEFAULT_SIZE = 10;
    public int size =0;

    public CustomArrayList(){
        this.data = new int[DEFAULT_SIZE];
    }

    // Adding an element at the end
    public void add(int num){
        // Checks if the data array is full
        if(isFull()){
            // If full resize
            resize();
        }
        data[size++] = num;
    }
    
    public Boolean isFull(){
        return size ==  data.length;
    }

    public void resize(){
        int[] temp = new int[data.length * 2];
        for(int i=0; i < data.length; i++){
            temp[i] = data[i];
        }
        data = temp;
    }
    
    // Remove the last element
    public int remove(){
        int lastEle = data[--size];
        return lastEle;
    }

    // Set an element
    public void set(int idx, int value) {
        data[idx] = value;
    }

    // Get an element at an idx
    public int get(int idx){
        return data[idx];
    }


    @Override
    public String toString(){
        return Arrays.toString(data);
    }

    public static void main(String[] args) {
        CustomArrayList obj = new CustomArrayList();
        obj.add(12);
        obj.add(13);
        obj.add(41);
        obj.add(-254);

        System.out.println(obj);
        System.out.println(obj.remove());
        System.out.println(obj);
        obj.add(124);
        System.out.println(obj);
        obj.set(0, 25);
        System.out.println(obj);
        System.out.println(obj.get(3));
        
    }
}
