package entities;
import interfaces.ContractQueue;

public class CircularQueue implements ContractQueue {
   
    private int[] elements;
    private int head;
    private int tail;
    private int size;
    
    public CircularQueue() {
        elements = new int[10];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }
    
    @Override
    public void enqueue(int value) {
        if (isFull()) {
            resize();
        }
            elements[tail] = value;
            tail = (tail + 1) % elements.length;
            size++;
    }
    
    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot remove: The queue is empty");
        }
        
        int removed = elements[head];
        head = (head + 1) % elements.length;
        size--;
        return removed;
    }
    
    @Override
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        
        return elements[head];
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == elements.length;
    }

    @Override
    public int size() {
        return size;
    }
    
    private void resize() {
        int[] newVet = new int[elements.length * 2];
        
        for(int i = 0; i < size; i++) {
            newVet[i] = elements[(i + head) % elements.length];
        }
        
        elements = newVet;
        head = 0;
        tail = size;
    }
    
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
    
        for (int i = 0; i < size; i++) {
            int index = (head + i) % elements.length;
            sb.append(elements[index]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
    
        sb.append("]");
        return sb.toString();
    }
}
