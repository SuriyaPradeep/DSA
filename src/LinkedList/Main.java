package LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        list.insertAtStart(2);
        list.insertAtEnd(4);
        list.insertAtStart(1);
        list.insert(3,3);
        list.display();
        System.out.println(list.Search(3));
        list.delete(3);
        list.display();
    }
}
