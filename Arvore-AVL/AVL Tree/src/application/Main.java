package application;
import entities.*;

public class Main {
    public static void main(String[] args) {
        AVLTree avl = new  AVLTree();

        avl.insert(5);
        avl.insert(4);
        avl.insert(6);
        avl.insert(3);
        avl.insert(1);
        avl.insert(2);
        avl.insert(7);
        avl.insert(8);

        System.out.print("PRE ORDER: ");
        avl.preOrder();
        System.out.println();
        System.out.print("POST ORDER: ");
        avl.postOrder();
        System.out.println();
        System.out.print("IN ORDER: ");
        avl.inOrder();

        System.out.println("\n");
        System.out.print("O nó 8 existe? " + avl.search(8) + "\n");
        System.out.println("O nó 12 existe? " + avl.search(12) + "\n" );
    }
}







