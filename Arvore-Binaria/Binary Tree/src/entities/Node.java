package entities;

public class Node {
    int value;
    Node left;
    Node right;

    public Node(int key) {
        this.value = key;
        this.left = null;
        this.right = null;
    }

    public int getValue() {return value;}
}
