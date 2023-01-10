package LinkedList;

public class DLL_Driver {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertFirst(1);
        dll.insertFirst(2);
        dll.insertFirst(3);
        dll.insertFirst(4);
        dll.insertFirst(5);
        dll.insertFirst(25);

        dll.displayDLL();
        // dll.displayReverse();
        System.out.println("Head: "+dll.getHeadData() + " Tail: "+dll.getTailData());

        // Insert at last
        dll.insertLast(6);
        dll.insertLast(7);
        dll.insertLast(8);
        dll.insertLast(9);

        // Insert at random index
        dll.insert(444, 4);
        dll.insert(555, 11);

        dll.insertAfter(7, 1468);
        dll.insertAfter(100, 666);

        dll.displayDLL();
        // Delete
        dll.delete(3);
        dll.displayDLL();

        dll.delete(4);
        dll.displayDLL();
        // dll.displayReverse();
        System.out.println("Head: "+dll.getHeadData() + " Tail: "+dll.getTailData());
        System.out.println("Size of DLL: "+dll.getSize());
    }
}
