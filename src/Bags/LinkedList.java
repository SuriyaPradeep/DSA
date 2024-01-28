package Bags;

import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item>{
    class Node{
        private Item item;
        private Node next;
        Node(Item data){
            this.item=data;
            this.next=null;
        }
    }
    private Node head;
    private int size;
    public LinkedList(){
        this.head=null;
        this.size=0;
    }
    public void add(Item data){
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
    }
    public int getSize(){
        return size;
    }
    public Iterator<Item> iterator(){
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>{
        private Node current=head;
        public boolean hasNext(){
            return current!=null;
        }
        public Item next(){
            Item item=current.item;
            current=current.next;
            return item;
        }
    }
}
