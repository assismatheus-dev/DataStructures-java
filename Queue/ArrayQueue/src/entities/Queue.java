package entities;
import interfaces.QueueContract;

public class Queue implements QueueContract{
    
    private int[] elements;
    private int last;

    public Queue() {
        this.elements = new int[10];
        this.last = -1;
    }

    @Override
    public void enqueue(int value) {
        if (isFull()) {
            resize();
        }
        
        elements[++last] = value;
    }
    
    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Empty queue!");
        }
            int removed = elements[0];
            for(int i = 0; i < last; i++) {
                elements[i] = elements[i + 1];
            }
            
            last--;
            return removed;
    }
    
    @Override
    public boolean isEmpty() {
        return last == -1;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Empty queue!");
        }
        
        return elements[0];
    }
    
    @Override
    public int size() {
        return last + 1;
    }
    
    public boolean isFull() {
        return last == elements.length - 1;
    }

    private void resize() {
        int newSize = elements.length * 2;
        int[] newVet = new int[newSize];
        
        for(int i = 0; i <= last; i++) {
            newVet[i] = elements[i];
        }
        
        elements = newVet;
    }
    
    @Override
    public void print() {
        if (isEmpty()) {
            System.out.print("[]");
        } 
        
        else {
            System.out.print("[");
            System.out.print(elements[0]);
            for(int i = 1; i <= last; i++) {
                System.out.print(" " + elements[i]);
            }
        }
        
        System.out.print("]");
    }
}
