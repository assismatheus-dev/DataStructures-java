package application;
import entities.Stack;

public class Main {
    public static void main(String[] args) {
        Stack pilha = new Stack();
        pilha.push(1);
        pilha.push(2);
        pilha.push(3);
        pilha.push(4);
        pilha.push(5);
        pilha.push(6);
        
        System.out.println("Topo: " + pilha.peek());
        pilha.print();
        System.out.println("\n");

        for (int i = 0 ; i != 3; i++) {
            System.out.println("Elemento removido: " + pilha.pop());
        }
        
        System.out.println();
        pilha.print();
    }
}
