package LinkedList;

public class Driver {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertAtFirst(2);
        linkedList.insertAtFirst(3);
        linkedList.insertAtFirst(5);
        linkedList.insertAtFirst(7);
        linkedList.insertAtFirst(11);

        // Print current head and tail
        System.out.println("Head: "+linkedList.getHeadData() + " Tail: "+linkedList.getTailData());

        linkedList.insertAtLast(13);
        linkedList.insertAtLast(17);
        linkedList.insertAtLast(19);
        System.out.println("Head: "+linkedList.getHeadData() + " Tail: "+linkedList.getTailData());
        

        // Insert at a given idx
        linkedList.insert(255, 4);
        linkedList.insert(127, 5);
        System.out.println("Head: "+linkedList.getHeadData() + " Tail: "+linkedList.getTailData());

        linkedList.displayLL();

        // Delete from first
        linkedList.deleteFirst();
        linkedList.displayLL();
        System.out.println("Head: "+linkedList.getHeadData() + " Tail: "+linkedList.getTailData());


        // Delete generic
        linkedList.delete(8);
        linkedList.displayLL();
        System.out.println("Head: "+linkedList.getHeadData() + " Tail: "+linkedList.getTailData());


        // Size of Linkedlist
        System.out.println("Size of Linked list: "+linkedList.getSize());
        // Display LinkedList
        linkedList.displayLL();

        // Get the index value based on the data
        int element = 17;
        System.out.println("Element "+element+" found at index: "+linkedList.getIdx(element)); 

        System.out.println("**********************************");
        LinkedList ll = new LinkedList();
        ll.insertAtFirst(1);
        ll.insertAtLast(2);
        ll.insertAtFirst(5);
        ll.displayLL(); 
        System.out.println("Size of Linked list: "+ll.getSize());
        System.out.println("Head: "+ll.getHeadData() + " Tail: "+ll.getTailData());
        ll.insertRec_Driver(99, 1);
        ll.displayLL(); 
        System.out.println("Size of Linked list: "+ll.getSize());
        System.out.println("Head: "+ll.getHeadData() + " Tail: "+ll.getTailData());

        System.out.println("**********************************");
        ll.insertRec_Driver(999, ll.getSize());
        ll.displayLL(); 
        System.out.println("Size of Linked list: "+ll.getSize());
        System.out.println("Head: "+ll.getHeadData() + " Tail: "+ll.getTailData());

    }
}
