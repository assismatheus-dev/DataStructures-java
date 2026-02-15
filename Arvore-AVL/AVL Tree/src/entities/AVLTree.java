package entities;

import interfaces.AVLTreeContract;

public class AVLTree implements AVLTreeContract {
    private Node root;


    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    // escolhe o caminho mais profundo do nó e soma +1 a ele
    private void updateHeight(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    @Override
    public void insert(int value) {
        root = recursiveInsert(value, root);
    }

    private Node recursiveInsert(int value, Node current) {
        if(current == null) {return new Node(value);}
        if(current.value < value) {current.right = recursiveInsert(value, current.right);}
        else if(current.value > value) {current.left = recursiveInsert(value, current.left);}
        else {return current;}

        updateHeight(current);

        int balance = getBalance(current);

        //ROTAÇÃO SIMPLES À DIREITA
        if(balance > 1 && value < current.left.value)
            return rotateRight(current);

        //ROTAÇÃO SIMPLES À ESQUERDA
        if(balance < -1 && value > current.right.value)
            return rotateLeft(current);

        //ROTAÇÃO DUPLA À DIREITA
        if(balance > 1 && value > current.left.value) {
            current.left = rotateLeft(current.left);
            return rotateRight(current);
        }

        //ROTAÇÃO DUPLA À ESQUERDA
        if(balance < -1 && value < current.right.value) {
            current.right = rotateRight(current.right);
            return rotateLeft(current);
        }

        return current;
    }

    @Override
    public void delete(int value) {
        root = recursiveDelete(value, root);
    }

    private Node recursiveDelete(int value, Node current) {
        if(current == null) {return null;}
        if(value > current.value) {current.right = recursiveDelete(value, current.right);}
        else if(value < current.value) {current.left = recursiveDelete(value, current.left);}

        else {
            if(current.left == null || current.right == null) {
                Node temp = (current.left == null) ? current.right : current.left;
                //TRATAMENTO DE CASOS -> 1 OU 0 FILHOS: O CURRENT PODE RECEBER TANTO O FILHO ESQUERDA/DIREITA QUANTO NULL
                current = temp;
            }

            else {
                //PROCURA PELO MENOR NÓ DA SUBÁRVORE À DIREITA
                Node sucessor = minValueNode(current.right);
                current.value = sucessor.value;
                current.right = recursiveDelete(sucessor.value, current.right);
            }
        }

        if(current == null) {return null;}

        updateHeight(current);

        int balance = getBalance(current);

        //ROTAÇÃO SIMPLES À DIREITA
        if(balance > 1 && getBalance(current.left) >= 0)
            return rotateRight(current);

        //ROTAÇÃO SIMPLES À ESQUERDA
        if(balance < -1 && getBalance(current.right) <= 0)
            return rotateLeft(current);

        //ROTAÇÃO DUPLA À DIREITA
        if(balance > 1 && getBalance(current.left) < 0) {
            current.left = rotateLeft(current.left);
            return rotateRight(current);
        }

        //ROTAÇÃO DUPLA À ESQUERDA
        if(balance < -1 && getBalance(current.right) > 0) {
            current.right = rotateRight(current.right);
            return rotateLeft(current);
        }

        return current;
    }

    private Node minValueNode(Node node) {
        while(node.left != null) {
            node = node.left;
        }

        return node;
    }

    @Override
    public boolean search(int value) {
        return recursiveSearch(value, root);
    }

    private boolean recursiveSearch(int value, Node current) {
        if(current == null) {return false;}
        if(value == current.value) {return true;}

        if(value > current.value) {
            return recursiveSearch(value, current.right);
        }
        else {
            return recursiveSearch(value, current.left);
        }
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
