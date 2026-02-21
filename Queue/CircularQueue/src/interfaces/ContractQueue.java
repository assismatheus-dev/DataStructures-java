package interfaces;

public interface ContractQueue {

    void enqueue(int value);

    int dequeue();

    int peek();

    boolean isEmpty();

    int size();

}


