package interfaces;

public interface QueueContract {

    void enqueue(int value);

    int dequeue();

    int peek();

    boolean isEmpty();

    int size();

    void print();
}

