package entities;
import interfaces.TreeContract;

public class BinaryTree implements TreeContract {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public Node getRoot() {return this.root;}

    @Override
    public void insert(int value) {
        root = insertRecursive(value, root);
    }

    private Node insertRecursive(int value, Node current) {
        if(current == null) {
            return new Node(value);
        }

        if(value < current.value) {
            current.left = insertRecursive(value, current.left);
        }
        else if(value > current.value) {
            current.right = insertRecursive(value, current.right);
        }

        return current;
    }

    @Override
    public void delete(int value) {
        root = deleteRecursive(value, root);
    }

    private Node deleteRecursive(int value, Node current){
        if(current == null) {return null;}
        if(value < current.value) {deleteRecursive(value, current.left);}
        else if(value > current.value) {deleteRecursive(value, current.right);}

        else {
            if(current.left == null && current.right == null) {return null;}
            else if(current.left == null) {return current.right;}
            else if(current.right == null) {return current.left;}

            //Caso o nó possua filhos na direita e esquerda, pegaremos o nó de menor valor da subárvore à direita
            Node successor = current.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            current.value = successor.value;
            current.right = deleteRecursive(successor.value, current.right);
        }
        return current;
    }

    @Override
    public boolean search(int key) {
        return searchRecursive(key, root);
    }

    private boolean searchRecursive(int key, Node current) {
        if(current == null) {return false;}
        if(current.value == key) {return true;}

        if(key > current.value) {return searchRecursive(key, current.right);}
        else {return searchRecursive(key, current.left);}
    }

    @Override
    public void inOrder() {
        recursiveInOrder(root);
    }

    private void recursiveInOrder(Node current) {
        if(current != null) {
            recursiveInOrder(current.left);
            System.out.print(current.value + " ");
            recursiveInOrder(current.right);
        }
    }

    @Override
    public void preOrder() {
        recursivePreOrder(root);
    }

    private void recursivePreOrder(Node current) {
        if(current != null) {
            System.out.print(current.value + " ");
            recursivePreOrder(current.left);
            recursivePreOrder(current.right);
        }
    }

    @Override
    public void postOrder() {
        recursivePostOrder(root);
    }

    private void recursivePostOrder(Node current) {
        if(current != null) {
            recursivePostOrder(current.left);
            recursivePostOrder(current.right);
            System.out.print(current.value + " ");
        }
    }
}
