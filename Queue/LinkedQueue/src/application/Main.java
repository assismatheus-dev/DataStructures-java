package application;
import entities.LinkedQueue;

public class Main {
    public static void main(String[] args) {
        
        LinkedQueue queue = new LinkedQueue();

        for(int i = 1; i < 11; i++) {
            queue.enqueue(i);
        }

        System.out.println(queue + " -> Total elements\n");

        System.out.println("Element removed: " + queue.dequeue());
        System.out.println("Element removed: " + queue.dequeue());
        System.out.println("Element removed: " + queue.dequeue());

        System.out.println("\n" + queue + " -> New total elements " + "| Peek: " + queue.peek() + " | Size: " + queue.size());

    }
}
