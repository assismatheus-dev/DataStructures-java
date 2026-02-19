package interfaces;

import entities.Node;

public interface AVLTreeContract {

    void insert(int value);
    void delete(int value);
    boolean search(int value);
    void inOrder();
    void preOrder();
    void postOrder();
}







