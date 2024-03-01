package BinarySearchTree;

public class RedBlack<T extends Comparable<T>> {
    private static final boolean RED=true;
    private static final boolean BLACK=false;
    class Node{
        private T value;
        private Node left,right;
        private  boolean color;//parents link color
        private int size;
        public Node(T value, boolean color, int size) {
            this.value = value;
            this.color = color;
            this.size = size;
        }
    }
    private Node root;
    private boolean isRed(Node n){
        if(n==null){
            return false;
        }
        return n.color==RED;
    }
    private int size(Node n) {
        if (n == null) return 0;
        return n.size;
    }
    public int size(){
        return size(root);
    }
    public boolean isEmpty(){
        return root==null;
    }
    public boolean Search(T key){
        Node n=root;
        while (n!=null){
            int comp=key.compareTo(n.value);
            if(comp==0){
                return true;
            } else if (comp>0) {
                n=n.right;
            }else {
                n=n.left;
            }
        }
        return false;
    }
    public boolean contains(T key){
        return Search(key);
    }
    /*
    Let n be the right child of h. The rotation will make n the new root of the subtree, with h as its left child. The right subtree of n remains unchanged.
    The left child of n becomes the right child of h, preserving the binary search tree order.
    The color of n becomes the color of h, and the color of h becomes red, ensuring that the properties of a Red-Black Tree are maintained.
     */
    private Node rotateLeft(Node h){
        Node n=h.right;
        h.right=n.left;
        n.left=h;
        n.color= h.color;
        h.color=RED;
        n.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return n;
    }
    /*
    Let n be the left child of h. The rotation will make n the new root of the subtree, with h as its right child. The left subtree of n remains unchanged.
    The right child of n becomes the left child of h, preserving the binary search tree order.
    The color of n becomes the color of h, and the color of h becomes red, ensuring that the properties of a Red-Black Tree are maintained.
     */
    private Node rotateRight(Node h){
        Node n=h.left;
        h.left=n.right;
        n.right=h;
        n.color=h.color;
        h.color=RED;
        n.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return n;
    }
    /*
    The color of the current node h is flipped from red to black, and the colors of its left and right children are flipped from black to red.
    This operation ensures that a red node does not have two red children, which would violate the red-black properties of the tree.
     */
    private void flipColors(Node h){
        h.color=RED;
        h.left.color=BLACK;
        h.right.color=BLACK;
    }
    // Assuming that n is red and both n.left and n.left.left are black, make n.left or one of its children red.
    private Node moveRedLeft(Node n) {
        flipColors(n);
        if (isRed(n.right.left)) {
            n.right = rotateRight(n.right);
            n = rotateLeft(n);
            flipColors(n);
        }
        return n;
    }
    // Assuming that h is red and both h.right and h.right.left
    // are black, make h.right or one of its children red.
    private Node moveRedRight(Node n) {
        flipColors(n);
        if (isRed(n.left.left)) {
            n = rotateRight(n);
            flipColors(n);
        }
        return n;
    }
    private Node balance(Node n) {
        if (isRed(n.right) && !isRed(n.left))    n = rotateLeft(n);
        if (isRed(n.left) && isRed(n.left.left)) n = rotateRight(n);
        if (isRed(n.left) && isRed(n.right))     flipColors(n);
        n.size = size(n.left) + size(n.right) + 1;
        return n;
    }
    private Node insert(Node n,T value){
        if(n==null){
            return new Node(value,RED,1);
        }
        int comp=value.compareTo(n.value);
        if(comp>0){
            n.right=insert(n.right,value);
        } else if (comp<0) {
            n.left=insert(n.left,value);
        }
        return balance(n);
    }
    public void insert(T value){
        root=insert(root,value);
    }
    private Node delete(Node n,T key){
        if (key.compareTo(n.value) < 0)  {
            if (!isRed(n.left) && !isRed(n.left.left))
                n = moveRedLeft(n);
            n.left = delete(n.left, key);
        }
        else {
            if (isRed(n.left))
                n = rotateRight(n);
            if (key.compareTo(n.value) == 0 && (n.right == null))
                return null;
            if (!isRed(n.right) && !isRed(n.right.left))
                n = moveRedRight(n);
            if (key.compareTo(n.value) == 0) {
                Node x = min(n.right);
                n.value = x.value;
                // h.val = get(h.right, min(h.right).key);
                // h.key = min(h.right).key;
                n.right = deleteMin(n.right);
            }
            else n.right = delete(n.right, key);
        }
        return balance(n);
    }
    public void delete(T value){
        if (!contains(value)) return;

        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;

        root = delete(root, value);
        if (!isEmpty()) root.color = BLACK;
    }
    public Node min(Node n){
        while (n.left!=null){
            n=n.left;
        }
        return n;
    }
    private Node deleteMin(Node n) {
        if (n.left == null) {
            return null;
        }
        if (!isRed(n.left) && !isRed(n.left.left)) {
            n = moveRedLeft(n);
        }
        n.left = deleteMin(n.left);
        n.size = size(n.left) + size(n.right) + 1;
        return balance(n);
    }
    public Node max(Node n){
        while (n.right!=null){
            n=n.right;
        }
        return n;
    }
    private void printInorder(Node n){
        if(n==null){
            return;
        }
        printInorder(n.left);
        System.out.print(n.value+" ");
        printInorder(n.right);
    }
    public void printInorder(){
        printInorder(root);
    }
    public static void main(String[] args) {
        RedBlack<Integer> redBlack=new RedBlack<>();
        redBlack.insert(100);
        redBlack.insert(20);
        redBlack.insert(200);
        redBlack.insert(10);
        redBlack.insert(30);
        redBlack.insert(150);
        redBlack.insert(300);
        redBlack.printInorder();//10 20 30 100 150 200 300
        System.out.println();
        System.out.println(redBlack.size());
        redBlack.delete(150);
        System.out.println(redBlack.size());
        System.out.println(redBlack.contains(150));
    }
}
