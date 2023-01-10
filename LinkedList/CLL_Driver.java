package LinkedList;

public class CLL_Driver {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insertAtTail(1);
        cll.insertAtTail(2);
        cll.insertAtTail(3);

        cll.display();
        System.out.println("Head: "+cll.getHeadData()+" Tail: "+cll.getTailData());
        System.out.println("Size of cll : "+cll.getSize());

        cll.deleteData(3);
        cll.display();
        System.out.println("Head: "+cll.getHeadData()+" Tail: "+cll.getTailData());
        System.out.println("Size of cll : "+cll.getSize());
    }
}
