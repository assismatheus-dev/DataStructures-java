package application;

import entities.BinaryTree;

public class Main {

    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();

        bt.insert(10);
        bt.insert(9);
        bt.insert(8);
        bt.insert(11);
        bt.insert(14);
        bt.insert(13);
        bt.insert(17);

        System.out.println("Root: " + bt.getRoot().getValue());

        System.out.println("\nO nó 70 existe? " + bt.search(70));
        System.out.println("O nó 40 existe? " + bt.search(40));

        System.out.print("\nCaminho IN ORDER: ");
        bt.inOrder();
        System.out.print("\nCaminho PRE ORDER: ");
        bt.preOrder();
        System.out.print("\nCaminho POST ORDER: ");
        bt.postOrder();

    }
}
