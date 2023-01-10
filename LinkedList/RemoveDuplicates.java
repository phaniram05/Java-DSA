package LinkedList;

public class RemoveDuplicates {
    public static void main(String[] args) {
        
        LinkedList list = new LinkedList();
        list.insertAtLast(1);
        list.insertAtLast(1);
        list.insertAtLast(1);
        list.insertAtLast(2);
        list.insertAtLast(4);
        list.insertAtLast(4);
        list.displayLL();    

        removeDuplicates(list.getHead());
        list.displayLL();

        LinkedList list2 = new LinkedList();
        list2.insertAtFirst(1);
        list2.insertAtLast(1);
        list2.insertAtLast(2);
        list2.insertAtLast(3);
        list2.insertAtLast(3);
        removeDuplicates(list2.getHead());
        list2.displayLL();


    }

    public static void removeDuplicates(LinkedList.Node head){
        if(head == null){
            return;
        }
        LinkedList.Node temp = head;
        while(temp.next != null){
            if(temp.data == temp.next.data){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }     
        } 
    }

}
