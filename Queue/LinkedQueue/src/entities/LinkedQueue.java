package entities;
import interfaces.QueueContract;

public class LinkedQueue implements QueueContract {
    
    private Node tail;
    private Node head;
    private int size;
    
    public LinkedQueue() {
        this.tail = null;
        this.head = null;
        this.size = 0;
    }
    
    public void enqueue(int value) {
        Node newNode = new Node(value);
        
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        
        tail = newNode;
        size++;
    }
    
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue empty!");
        }
        
        int removed = head.value;
        head = head.next;
        
        if (head == null) {
            tail = null;
        }
        
        size--;
        return removed;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int peek() {
        if(isEmpty()) {
            throw new RuntimeException("Queue empty!");
        }
        
        return head.value;
    }
    
    public int size() {
        return size;
    }
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        Node current = head;
       while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(" ");
            }
            current = current.next;
        }
        
            sb.append("]");
            return sb.toString();
    }
}

