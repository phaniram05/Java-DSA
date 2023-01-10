package LinkedList;

public class LinkedList {
    
    private Node head;
    private Node tail;
    private int size;

    public Node getHead(){
        return head;
    }

    public Node getTail(){
        return tail;
    }
    public int getSize(){
        return size;
    }

    public int getHeadData(){
        return head.data;
    }

    public int getTailData(){
        return tail.data;
    }

    LinkedList(){
        this.size = 0;
    }


    public class Node{
        public int data;
        public Node next;
        
        public Node(){
            
        }
        public Node(int data){
            this.data = data;
        }

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    
    }


    // Insert data at the first position: O(1)
    public void insertAtFirst(int data){
        // 1. Create a Node
        Node node = new Node(data);
        // 2. Attach the node.next to head
        node.next = head;
        // 3. reassign head to node
        head = node;

        if(tail == null){
            tail = node;    
        }
        // Increment LinkedList size by 1 
        size++;

    }

    // Insert data at the last position: O(1)
    public void insertAtLast(int data){

        if(tail == null){
            insertAtFirst(data);
            return;
        }

        // 1. Create a Node
        Node node = new Node(data);
        // 2. Set current tails next as node
        tail.next =  node;
        // 3. Reassign tail to node
        tail = node;
        
        // Increase the size
        size++;
    }

    // Insert anywhere in between head and tail: O(N) since we are traversing
    /*
    *  To impement this, assume
    *  
    * Assume idx: 0  1  2  3   4  5
    *             2->3->5->7->11->13
    * 
    * If we want to insert at idx 3
    *  1. Traverse till index 3-1 starting head, which is 2 using TEMP
    *  2. Create a new Node with data given
    *  3. Set node.next = temp.next;
    *  4. Set temp.next = node;
    */
    public void insert(int data, int idx){

        if(idx > size){
            System.out.println("Please enter a valid index");    
        }

        if(idx == 0){
            insertAtFirst(data);
            return;
        }
        if(idx == size){
            insertAtLast(data);
            return;
        }
            Node temp = head;
            // Step 1
            for(int i=1; i < idx; i++){
            temp = temp.next;
            }
            // Step 2 and 3
            Node node = new Node(data, temp.next);
            // Step 4
            temp.next = node;
        }

    
    // Insert a node recursively instead of for loop    
    /* 
        COMES IN HANDY, WHEN THERE IS NO TAIL
     * 
     *  In Iterative approach we followed, 
     *  1. Traverse till index 3-1 starting head, which is 2 using TEMP
     *  2. Create a new Node with data given
     *  3. Set node.next = temp.next;
     *  4. Set temp.next = node;
     * 
     * In Recursive approach, 
     *  1. we need to reach a particular node where we want to insert by passing a param
     *  2. Once we are there, create a new node there and set node.next = currNode;
     *  3. At base condition, return the newly created node
     *  4. Else, return the node from where it is being returned
     * 
     *  We also need to take care of head/ tail reassignment
     * 
     *  Observation: We could have maintained a variable that counts idx, but we chose to 
     *               decrement the idx value at which we want to insert
     * 
     *          idx: 0      1       2       3       4
     *         data: 1      2       3       4       5
     * 
     *  Assume, we want to insert 6 at position 2
     *  Output should look like:  
     * 
     *          idx: 0      1       2       3       4       5       
     *         data: 1      2       6       3       4       5 
     *          
     *      insertRecursively(6, 2, head)
     *          idx != 0  ==>  insertRecursively(6, 1, head.next)
     *                         idx != 0 ==> Node returnedNode = insertRecursively(6, 0, head.next.next)
     *                                      head.next.next = returnedNode.next
     * 
     *                                      idx == 0 ==> 1. Create a new node
     *                                                   2. Set node.next = head.next.next; (currNode)             
     *                                                   3. Increment size                   
     *                                                   4. return newly created node   
     */
    
    public void insertRec_Driver(int data, int idx){
        // Last returned node will be the head  
        head= insertRecursively(data, idx, head);
    } 

    public Node insertRecursively(int data, int idx, Node currNode){
        if(idx == 0){
            // We have reached the location => Step 1
            Node node = new Node(data, currNode);
            size++;
            return node; // Returning newly created node
        }

        Node returnedNode = insertRecursively(data, idx-1, currNode.next);
        currNode.next = returnedNode;
        return  currNode;
    }
     


    // Delete first: O(1) no traversal
    public int deleteFirst(){

        if(head == null){
            return Integer.MAX_VALUE;
        }

        int res = head.data;
        System.out.println("Deleting : "+res);
        head = head.next;
        if(head == null){
            tail = null;
        }
        size = size-1;
        return res;
    }

    // Delete generic: O(N) since we are traversing the linkedList
    public int delete(int idx){

        if(idx >= size){
            System.out.println("Please enter a valid index");    
        }

        if(idx == 0){
            return deleteFirst(); 
        }

        // First get the Node preceding the Deleting node      
        Node prev = head;
        for(int i=1; i < idx; i++){
            prev = prev.next;
        }
        
        // Get the node to be deleted
        Node curr = prev.next;

        // Collect the data to be deleted to return
        int deletingData = curr.data;
        System.out.println("Deleting : "+deletingData);
        // Assign the prev next to curr next        
        prev.next = curr.next;
        size--;

        // re-assigning tail
        if(curr.next == null){
            tail = prev;
        }

        return deletingData;
    }


    // Get Index based on data
    public int getIdx(int data){

        Node start = head;
        int idx = 0;
        while(start != null){
            if(start.data == data){
                return idx;
            }
            idx++;
            start = start.next;
        }
        return -1;
    }




    // Display LinkedList: O(N) 
    public void displayLL(){
    Node temp = head;
    while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
    }     
    System.out.print("END");
    System.out.println();
    }



    // Merge Sorted Lists
    public Node mergeSortedLists(Node head1, Node head2){

        if(head1 == null && head2 == null){
            return null;
        }

        if(head1 == null){return head2;}
        if(head2 == null){return head1;}

        Node sortedHead = new Node();
        Node tail = sortedHead;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                tail.next = head1;
                head1 = head1.next;
                tail = tail.next; 
            }else{
                tail.next = head2;
                head2 = head2.next;
                tail = tail.next;
            }
        }

        tail.next = (head1 == null) ? head2 : head1;
        return sortedHead.next;

    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        list1.insertAtLast(1);
        list1.insertAtLast(2);
        list1.insertAtLast(4);
        list2.insertAtLast(1);
        list2.insertAtLast(3);
        list2.insertAtLast(4);

        // LinkedList res = new LinkedList();
        // Node head = res.mergeSortedLists(list1.head, list2.head);
        
        // while(head != null){
        //     System.out.print(head.data+" -> ");
        //     head = head.next;
        // }
        // System.out.print("END");
        // System.out.println();


        LinkedList floydList = new LinkedList();
        floydList.insertAtLast(1);
        floydList.insertAtLast(2);
        floydList.insertAtLast(3);
        floydList.insertAtLast(4);
        floydList.insertAtLast(5);
        floydList.insertAtLast(6);

        Node tail = floydList.getTail();
        System.out.println("Tail : "+tail.data);
        Node someNode = floydList.getNode(floydList.head, 2);
        System.out.println("Get someNode: "+someNode.data);
        tail.next = someNode;

        // Cycle Detection
        Boolean hasCycle = floydList.floydCycle(floydList.head);
        System.out.println("Has Cycle ? "+hasCycle);
        System.out.println("Cycle Length : "+floydList.cycleLength(floydList.head));

        LinkedList test = new LinkedList();
        test.insertAtFirst(1);
        test.insertAtLast(2);
        test.insertAtLast(33);
        test.insertAtLast(4);
        test.insertAtFirst(666);
        test.insertAtLast(5);
        test.insertAtLast(77);
        test.displayLL();

        System.out.println("Using recursive approach ");
        test.reverseLL(test.head, null);
        test.displayLL();
        LinkedList test2 = new LinkedList();
        test2.insertAtLast(2);
        test2.insertAtLast(3);
        test2.insertAtLast(5);
        test2.insertAtLast(7);
        test2.insertAtLast(11);
        test2.displayLL();
        System.out.println("Head: "+test2.head.data);
        Node node = test2.inplaceReverse(test2.head);
        test2.head = node;
        System.out.println("Using iterative/ inplace approach");
        test2.displayLL();
    }

    // Get node based on index
    public Node getNode(Node head, int idx){
        Node node = head;
        if(idx < size){
            for(int i = 0; i < idx; i++){
                node = node.next;
            }
            return node;
        }else{
            System.out.println("Index out of bounds");
        }
        return null;

    }


    /* Amazon, Microsoft
     * When ever a question comes like cycle detection
     *  
     *  ==> Go with the Floyd Cycle/ Fast-slow pointer approach for best performance of code
     *      There are other approaches as well using HashMaps
     *  Time Complexity: O(N)
     * 
     */

    public Boolean floydCycle(Node head){

        Node fastPointer = head;
        Node slowPointer = head;

        while(fastPointer != null && slowPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(slowPointer == fastPointer){
                return true;
            }
        }

        return false;
    }

    
    // Follow-up Question
    /*
     *  Length of the Linked List Cycle
     *  1. Firstly find the node at which both the pointers meet 
     *  2. Start Counting from that node 
     *  3. When you again reach that node, return count  
     */
    public int cycleLength(Node head){
        if(head == null){
            return 0;
        }
        Node fastPointer= head;
        Node slowPointer = head;
        int length = 0;

        while(fastPointer != null && slowPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(slowPointer == fastPointer){
                length++;
                slowPointer = slowPointer.next;
                break;
            }
        }

        // Counting cycle length
        while(length >= 1 && slowPointer != fastPointer){
            length++;
            slowPointer = slowPointer.next;
        }

        return length;
    }


    // Reverse a LinkedList
    public Node reverseLL(Node currNode, Node prev){
    
        if(currNode.next == null){
            
            head = currNode;
            currNode.next = prev;
            return head;
        }

        reverseLL(currNode.next, currNode);
        currNode.next = prev;
        return head;

    }


    // In-place reversal

    public Node inplaceReverse(Node head){
        if(head == null){
            return null;
        }

        Node prev = null;
        Node curr = head;
        Node next = curr.next;

        while(curr != null){ 
            // System.out.println("Current : "+curr.data);
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null){
                next = next.next;
            }
        }
        head = prev;
        return head;
    } 


}
