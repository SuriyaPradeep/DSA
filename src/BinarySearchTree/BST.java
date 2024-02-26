package BinarySearchTree;

public class BST<T extends Comparable<T>> {
    private class Node {
        private T value;
        private Node left, right;
        private int size;

        public Node(T value) {
            this.value = value;
            this.left = this.right = null;
            this.size = 1; // Initialize size to 1 for the new node
        }
    }

    private Node root;

    public BST() {
        root = null;
    }
    public BST(T value){
        root=insert(root,value);
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public void insert(T value) {
        root = insert(root, value);
    }

    private Node insert(Node node, T value) {
        if (node == null) {
            return new Node(value);
        }
        int cmp = value.compareTo(node.value);
        if (cmp < 0) {
            node.left = insert(node.left, value);
        } else if (cmp > 0) {
            node.right = insert(node.right, value);
        }
        // Update size of the current node
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    public boolean search(T key) {
        Node cur_node = root;
        while (cur_node != null) {
            int cmp = key.compareTo(cur_node.value);
            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                cur_node = cur_node.left;
            } else {
                cur_node = cur_node.right;
            }
        }
        return false;
    }

    public void delete(T key) {
        root = delete(root, key);
    }

    private Node delete(Node node, T key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.value);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            // Node to be deleted found
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            // Node to be deleted has two children
            Node successor = min(node.right); // Find successor (minimum value in the right subtree)
            node.value = successor.value; // Replace node's value with successor's value
            node.right = delete(node.right, successor.value); // Delete the successor
        }
        // Update size of the current node
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    public Node min(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    public Node max(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
    public  void printInorder(Node node)
    {
        if (node == null)
            return;
        // Traverse left subtree
        printInorder(node.left);
        // Visit node
        System.out.print(node.value + " ");
        // Traverse right subtree
        printInorder(node.right);
    }
    public  void printPreorder(Node node)
    {
        if (node == null)
            return;
        // Visit node
        System.out.print(node.value + " ");
        // Traverse left subtree
        printPreorder(node.left);
        // Traverse right subtree
        printPreorder(node.right);
    }
    public void printPostorder(Node node)
    {
        if (node == null)
            return;
        // Traverse left subtree
        printPostorder(node.left);
        // Traverse right subtree
        printPostorder(node.right);
        // Visit node
        System.out.print(node.value + " ");
    }
    public void printInorder(){
        printInorder(root);
    }
    public void printPreorder(){
        printPreorder(root);
    }
    public void printPostorder(){
        printPostorder(root);
    }
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        System.out.println(tree.size());
        tree.insert(100);
        tree.insert(20);
        tree.insert(200);
        tree.insert(10);
        tree.insert(30);
        tree.insert(150);
        tree.insert(300);
        tree.printInorder();//10 20 30 100 150 200 300
        System.out.println();
        tree.printPreorder();//100 20 10 30 200 150 300
        System.out.println();
        tree.printPostorder();//10 30 20 150 300 200 100
        System.out.println();
        System.out.println(tree.search(150));
        System.out.println(tree.size());
        tree.delete(150);
        System.out.println(tree.search(150));
        System.out.println(tree.size());
    }
}
