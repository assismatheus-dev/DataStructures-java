package entities;

public class Queue {
    
    private int[] elements;
    private int front;
    private int last;

    public Queue() {
        this.elements = new int[10];
        this.last = -1;
        this.front = 0;
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }
    
    private boolean isFull() {
        return last == elements.length - 1;
    }
    
    private void resize() {
        int newSize = elements.length * 2;
        int[] newVet = new int[newSize];
        int index = 0;

        for (int i = front; i <= last; i++) {
            newVet[index++] = elements[i];
        }

        last = index - 1;
        front = 0;
        elements = newVet;
    }
    
    public void enqueue(int value) {
        if (isFull()) {
            resize();
        }
        
        elements[++last] = value;
    }
    
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Empty queue!");
        }
        return elements[front++];
    }
    
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Empty queue!");
        }
        
        return elements[front];
    }
    
    public int size() {
        return last - front + 1;
    }
    
    public void print() {
        if (isEmpty()) {
            System.out.print("[]");
        } 
        
        else {
            System.out.print("[");
            System.out.print(elements[front]);
            for(int i = front + 1; i <= last; i++) {
                System.out.print(" " + elements[i]);
            }
        }
        
        System.out.print("]");
    }
}
