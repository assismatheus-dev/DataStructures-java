package interfaces;

public interface TreeContract {

    void insert(int value);
    void delete(int value);
    boolean search(int value);
    void inOrder();
    void preOrder();
    void postOrder();
}



