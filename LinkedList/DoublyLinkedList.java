package LinkedList;

/**
 * DoublyLinkedList
 */
public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public int getHeadData(){
        return head.data;
    }

    public int getTailData(){
        return tail.data;
    }

    public int getSize(){
        return size;
    }

    private class Node{
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data = data;
        }

        Node(int data, Node prev, Node next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    // Insert at first

    public void insertFirst(int data){
        /*
         * 1. create a node
         * 2. Set its prev as null 
         * 3. Check for next node
         * 4. If present, node.next = Next
         * 5. Also, Next.prev = node
         * 6. head = node
         * 
         */

        Node node = new Node(data);
        if(head == null){
            head = node; 
            tail = head;
            size++;
            return; 
        }

        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;
        size++;

    }

    // Insert at last
    public void insertLast(int data){   

        if(tail == null){
            insertFirst(data);
        }

        Node node = new Node(data);
        node.prev = tail;
        node.next = null;
        tail.next = node;
        tail = node;
        size++;
    }


    // Insert at a given idx

    public void insert(int data, int idx){  

        if(idx == 0){
            insertFirst(data);
            return;
        }

        if(idx >= size){
            insertLast(data);
            return;
        }
        // 1. Create a new Node
        Node node = new Node(data);
        // 2. get currNode at idx we want to insert
        Node currNodeAtIdx = getNode(idx);
        
        node.prev = currNodeAtIdx.prev;
        node.next = currNodeAtIdx;
        currNodeAtIdx.prev.next = node;
        currNodeAtIdx.prev = node;
        size++;
    }

    // Insert After some data
    public void insertAfter(int insertAfter, int data){

        Node prevNode = getNodeBasedOnData(insertAfter);
        if(prevNode == null){
            System.out.println("Value not found to be inserted after");
            return;
        }

        Node node = new Node(data);
        node.next = prevNode.next;
        prevNode.next.prev = node;    
        prevNode.next = node;
        node.prev = prevNode;
        System.out.println("Successfully inserted "+ data +" after "+insertAfter);
        size++;
    }

    // Get node based on data
    public Node getNodeBasedOnData(int data){
        Node node = head;
        while(node != null){    
            if(node.data == data){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    // Get the node based on Idx 
    public Node getNode(int idx){
        Node node = head;
        if(idx == 0){
            return node;
        }
        for(int i=1; i <= idx; i++){
            node = node.next;
        }
        return node;
    }


    // Delete an element from DLL and return it

    /*
     *      1 <=> 2 <=> 3 <=> 4 <=> 5
     * 
     * 
     * 
     */

    public int deleteFirst(){
        if(head != null){
            head = head.next;
            size--;
            return head.data;
        }
        size--;
        return -1;
    }

    public int deleteLast(){
        if(head == null){
            return -1;
        }
        int delElement = tail.data; 
        tail = tail.prev;
        size--;
        return delElement;
    }    

    public int delete(int idx){
        if(idx >= size){
            System.out.println("Index size exceeded");
            return -1;
        }

        if(idx == 0){
            return deleteFirst();
        }

        if(idx == size-1){
            return deleteLast();
        }

        Node node = getNode(idx);
        
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        return node.data;
    }


    // Print the Doubly LinkedList

    public void displayDLL(){
        Node node = head;
        while(node != null){
            System.out.print(node.data + " <=> ");
            node = node.next;
        }
        System.out.print(" END ");
        System.out.println();
    }

    // Display DLL in reverse
    public void displayReverse(){
        Node node = tail;
        while(node != null){
            System.out.print(node.data+" <=> ");
            node = node.prev;
        }
        System.out.print(" START ");
        System.out.println();
    }
    
}