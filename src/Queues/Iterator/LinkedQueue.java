package Queues.Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<Item> implements Iterable<Item> {
    class Node{
        Item item;
        Node next;
        Node(Item data){
            this.item=data;
            this.next=null;
        }
    }
    private Node head,tail;
    private int size;
    public LinkedQueue(){
        this.head=this.tail=null;
        this.size=0;
    }
    public boolean isEmpty(){
        return head==null;
    }
    public void enqueue(Item data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
        } else{
            tail.next=newnode;
        }
        tail=newnode;
        size++;
    }
    public Item dequeue(){
        if(head==null){
            throw new NoSuchElementException("Queue Underflow");
        }
        Item item=head.item;
        head=head.next;
        size--;
        return item;
    }
    public int getSize(){
        return size;
    }
    public Iterator<Item> iterator(){
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>{
        Node current=head;
        public boolean hasNext(){
            return current!=null;
        }
        public Item next(){
            Item item= current.item;
            current=current.next;
            return item;
        }
    }
}
