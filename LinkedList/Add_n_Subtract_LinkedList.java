package LinkedList;

import java.util.ArrayList;

public class Add_n_Subtract_LinkedList {

    ListNode head;
    boolean borrow;
    int carryFwd;
    
    static class ListNode{

        int data;
        ListNode next;
        
        ListNode(int data){
            this.data = data;            
        }

        ListNode (int data, ListNode next){
            this.data = data;
            this.next = next;
        }
    }

    // Length
    public int getLength(ListNode head){

        if(head == null){
            return 0;
        }

        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
      return size;

    }

    // append Zeros at start
    public ListNode appendZeros(ListNode head, int sizeDiff){

        if(head == null){
            return null;
        }

        ListNode returnHead = new ListNode(0); 
        ListNode temp = returnHead;

        for(int i=1; i < sizeDiff; i++) {
            temp.next = new ListNode(0);
            temp = temp.next;
        }

        temp.next = head;
        return returnHead;
    }

    // Subtract Recursive Function
    public ListNode subtract(ListNode node1, ListNode node2){

        if(node1 == null && node2 == null && !borrow){
            return null;
        }

        ListNode prev = subtract(node1.next != null ? node1.next : null, 
                                 node2.next != null ? node2.next : null);


        int data1 = node1.data;
        int data2 = node2.data;

        if(borrow){
            data1--;
            borrow = false;
        }

        if(data1 < data2){
            data1 += 10;
            borrow = true;
        }

        int diff = data1 - data2;

        ListNode curr = new ListNode(diff);
        curr.next = prev;

        return curr;
    }

    public void printLL(ListNode resultHead){

        if(resultHead == null){
            return;
        }

        ListNode temp = resultHead;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("END");
        System.out.println();
    }   


    // Preprocess parameters from main()
    public void preprocessSubtract(ListNode head1, ListNode head2){
        if(head1 == null || head2 == null){
            System.out.println("One of the lists is empty");    
            return;
        }

        ListNode temp1 = head1;
        ListNode temp2 = head2;
        
        int len1 = getLength(temp1);    
        int len2 = getLength(temp2);
        // System.out.println("Length of list1 : "+len1);
        // System.out.println("Length of list2 : "+len2);

        int sizeDiff = Math.abs(len1 - len2);
        ListNode appendHead = null;
        ListNode finalHead = null;

        if(len1 == len2){
            int data1 = 0;
            int data2 = 0;
            temp1 = head1;
            temp2 = head2;

            while(temp1 != null){
                data1 = temp1.data * 10 + data1;
                data2 = temp2.data * 10 + data2;
                temp1 = temp1.next;
                temp2 = temp2.next;
            }

            finalHead = subtract(data1 > data2 ? head1 : head2, data1 > data2 ? head2: head1);
            printLL(finalHead);
            return;
        }

        if(len1 < len2){ 
            appendHead = appendZeros(head1, sizeDiff);
            // System.out.println("AppendHead: ");
            // printLL(appendHead);      
            finalHead = subtract(head2, appendHead);

        }else if(len1 > len2){
            appendHead = appendZeros(head2, sizeDiff);
            // System.out.println("AppendHead: ");
            // printLL(appendHead);
            finalHead = subtract(head1, appendHead);
        }

        printLL(finalHead);
        return;


    }



    //  List<Integer> = {carryFwd, Hold}
    public ArrayList<Integer> returnCarryFwd(int x, int y){

        ArrayList<Integer> res = new ArrayList<Integer>();

        int sum = x + y;
        int hold = 0;
        if(sum > 9){
            hold = sum % 10;
            sum = sum/10;
            res.add(sum);
            res.add(hold);
        }else{
            res.add(0);
            res.add(sum);
        }
        return res;
    }

    // Addition
    public ListNode addition(ListNode node1, ListNode node2){

        // Base condition
        if(node1 == null && node2 == null && carryFwd == 0){
            return null;
        }

        ListNode prev = addition(node1.next != null ? node1.next : null, node2.next != null ? node2.next : null);
    
        if(node1.data == Integer.MAX_VALUE && node2.data == Integer.MAX_VALUE){
            if(carryFwd != 0){
                System.out.println("Carry Fwd: "+carryFwd);
                ListNode pudaka = new ListNode(carryFwd);
                pudaka.next = prev;
                return pudaka;
            }
            return prev;
        }   
        
        int x = node1.data;
        int y = node2.data;
        
        if(carryFwd != 0){
            x += carryFwd;
            carryFwd = 0;
        }
        
        
        ArrayList<Integer> nums = returnCarryFwd(x, y);
        carryFwd = nums.get(0);

        ListNode hold = new ListNode(nums.get(1));
        hold.next = prev; 

        return hold;
    }

    // Add Recursive Function
    public void preprocessAddition(ListNode head1, ListNode head2){

        if(head1 == null || head2 == null){
            System.out.println("Cannot Add: One of the lists is empty");
            return;
        }

        ListNode temp1 = head1;
        ListNode temp2 = head2;
        ListNode appendedHead = null;
        ListNode finalHead = null;

        int len1 = getLength(temp1);
        int len2 = getLength(temp2);

        ListNode dummy1 = new ListNode(Integer.MAX_VALUE);
        ListNode dummy2 = new ListNode(Integer.MAX_VALUE);


        if(len1 != len2){
            appendedHead = appendZeros(len1 > len2 ? temp2 : temp1, Math.abs(len1 - len2));
            dummy1.next = len1 > len2 ? head1 : head2;
            dummy2.next = appendedHead;
            finalHead = addition(dummy1, dummy2);          
        }
        else{
            dummy1.next = head1;
            dummy2.next = head2;
            finalHead = addition(dummy1, dummy2);
        }

        printLL(finalHead);
    }



    public static void main(String[] args) {
        
        ListNode head1 = new ListNode(9);
        head1.next = new ListNode(9);
        head1.next.next = new ListNode(9);
        head1.next.next.next = new ListNode(9);
        head1.next.next.next.next = new ListNode(9);

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(0);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(7);

        Add_n_Subtract_LinkedList obj = new Add_n_Subtract_LinkedList();
        System.out.println("Subtraction: ");
        obj.preprocessSubtract(head1, head2);
    
        System.out.println("Addition: ");
        obj.preprocessAddition(head1, head2);

    }


}
