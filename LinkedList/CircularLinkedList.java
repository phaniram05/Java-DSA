package LinkedList;

public class CircularLinkedList {
    
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
        Node next;

        Node(int data){
            this.data = data;
        }

        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
        
    }

    // Insert at the end of tail
    public void insertAtTail(int data){
        Node node = new Node(data);
        if(tail == null){
            node.next = null;
            head = node;
            tail = node;
            size++;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node; 
        size++;   
    }

    // Display Circular LinkedList
    public void display(){
        Node node = head;
        if(head == null){
            return;
        }
        do {
            System.out.print(node.data + " -> ");
            node = node.next;
        } while (node != head);
        System.out.println(" HEAD ");
        System.out.println();
    }


    // Delete an item based on data
    public void deleteData(int data){
        Node node = head;
        if(node == null){
            return;
        }
        // Takes care of head deletion
        if(data == node.data){
            head = head.next;
            tail.next = head;
            size--;
            return;
        }   

        do{
            Node nextNode = node.next;
            if(nextNode.data == data){
                node.next = nextNode.next;
                size--;
                System.out.println("Deleting : "+data);
                break;
            }
            node = node.next;
        }while(node != head);

    } 


}
