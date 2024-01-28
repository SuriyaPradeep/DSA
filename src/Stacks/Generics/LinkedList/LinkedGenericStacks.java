package Stacks.Generics.LinkedList;

import java.util.NoSuchElementException;

public class LinkedGenericStacks<Item> {
    class Node{
        Item item;
        Node next;
        Node(Item data){
            this.item=data;
            this.next=null;
        }
    }
    private Node head;
    private int size;
    public LinkedGenericStacks(){
        this.head=null;
        this.size=0;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void push(Item data){
        Node newnode=new Node(data);
        newnode.next=head;
        head=newnode;
        size++;
    }
    public Item pop(){
        Node current=head;
        if(current==null){
            throw new NoSuchElementException("Stack underflow");
        }
        head=head.next;
        return current.item;
    }
    public int getSize(){
        return size;
    }
}
