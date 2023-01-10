package Stacks_n_Queues;

import Arrays.CustomArrayList;

public class DynamicStack extends customStack {
     
    public DynamicStack(){
        super();
    }

    public DynamicStack(int size){
        super(size);
    }

    // push()
    @Override
    public boolean push(int value){

        if(isFull()){
            resize();
        }

        return super.push(value);
    }

    // resize()
    public void resize(){
        int[] temp  = new int[2 * this.data.length];
        for(int i=0; i < data.length; i++){
            temp[i] = this.data[i];
        }
        this.data = temp;
    }






    public static void main(String[] args) throws Exception{
        // Custom Stack : size is fixed
        customStack cStack = new customStack(4);
        cStack.push(1);
        cStack.push(2);
        cStack.push(3);
        cStack.push(4);
        System.out.println("cStack : "+cStack);
        cStack.push(5);  // It will throw an exception

        // Dnamic Stack : Size is doubled once full
        DynamicStack dStack = new DynamicStack(4);
        dStack.push(1);
        dStack.push(2);
        dStack.push(1);
        dStack.push(2);
        dStack.push(1); // At this point, the size of the array is doubled 
        dStack.push(2);   
        
        System.out.println("dStack: "+dStack);

        // 3rd variant
        customStack stack = new DynamicStack();
        // Access will be based on the members of the customStack class
        // Which method to call will be based on the DynamicStack
        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(11);
        System.out.println("stack : "+stack);

    }
}
