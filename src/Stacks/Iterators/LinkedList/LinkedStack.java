package Stacks.Iterators.LinkedList;

import java.util.NoSuchElementException;
import java.util.Iterator;

public class LinkedStack<Item> implements Iterable<Item>{
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
    public LinkedStack(){
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
    public Node getHead(){
        return head;
    }
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node current = head;
        public boolean hasNext() {
            return current != null;
        }
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
