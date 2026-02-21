package entities;
import interfaces.StackContract;

public class Stack implements StackContract{
    private int[] elements;
    private int top;

    public Stack() {
        this.elements = new int[10];
        this.top = -1;
    }

    @Override
     public void push(int value) {
        if (isFull()) {
            resize();
        }

        elements[++top] = value;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("The stack is empty");
        }
        // Elemento excluído logicamente, mas ainda existe fisicamente dentro do array elements até ser sobrescrito
        return elements[top--];
    }

    @Override
    public int peek() {
        if (isEmpty()) { 
            throw new RuntimeException("The stack is empty");
        }

        return elements[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == elements.length - 1;
    }

    @Override
        public int size() {
        return top + 1;
    }

    private void resize() {
        int newSize = elements.length * 2;
        int[] newVet = new int[newSize];

        for (int i = 0; i < elements.length; i++) {
            newVet[i] = elements[i];
        }

        elements = newVet;
    }

    @Override
    public void print() {
        if (isEmpty()) {
            System.out.print("[]");
        } else {
            System.out.print("[" + elements[top]);

            for (int i = top - 1; i >= 0; i--) {
                System.out.print(" " + elements[i]);
            }
        }
        System.out.print("]");
    }
 }
