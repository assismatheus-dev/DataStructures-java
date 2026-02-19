package application;
import entities.Queue;

public class Main {
	public static void main(String[] args) {
		Queue fila = new Queue();
		for(int i = 1; i <= 11; i++) {
		    fila.enqueue(i);
		}
		
		fila.print();
		
		System.out.println(" -> Topo: " + fila.peek() + "\n");

		
		System.out.println("Remoção do elemento: " + fila.dequeue());
		System.out.println("Remoção do elemento: " + fila.dequeue());
		System.out.println("Remoção do elemento: " + fila.dequeue());
		System.out.println("Remoção do elemento: " + fila.dequeue() + "\n");
		
		fila.print();
		System.out.println(" -> Topo: " + fila.peek());
		
	}
}
