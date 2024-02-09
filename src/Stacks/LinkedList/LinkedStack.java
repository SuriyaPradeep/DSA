package Stacks.LinkedList;

public class LinkedStack {
    static class Node{
        String item;
        Node next;
        Node(String data){
            this.item=data;
            this.next=null;
        }
    }
    private Node head;
    private int size;
    public LinkedStack(){
        this.head=null;
        this.size=0;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void push(String data){
        Node newnode=new Node(data);
        newnode.next=head;
        head=newnode;
        size++;
    }
    public String pop(){
        Node current=head;
        if(current==null){
            return "Empty Stack";
        }
        head=head.next;
        size--;
        return current.item;
    }
    public int getSize(){
        return size;
    }
    public void items(){
        Node current=head;
        while (current!=null){
            System.out.print(current.item+" ");
            current=current.next;
        }
        System.out.println();
    }
}
