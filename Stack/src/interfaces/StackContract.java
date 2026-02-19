package interfaces;

public interface StackContract {
    void push(int value);
    int pop();
    int peek();
    int size();
    boolean isEmpty();
    void print();

}

