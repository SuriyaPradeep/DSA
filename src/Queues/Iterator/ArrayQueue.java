package Queues.Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<Item> implements Iterable<Item>{
    private Item[] arr;
    private int n,head,tail;
    public ArrayQueue(){
        this.head=this.tail=this.n=0;
        this.arr=(Item[]) new Object[1];
    }
    public boolean isEmpty(){
        return n==0;
    }
    public int getSize(){
        return n;
    }
    public void resize(int length){
        Item[] copy=(Item[]) new Object[length];
        System.arraycopy(arr,head,copy,0,n);
        arr=copy;
        head=0;
        tail=n;
    }
    public void enqueue(Item data){
        if(n==arr.length){
            resize(arr.length*2);
        }
        arr[tail++]=data;
        n++;
        if(tail== arr.length){
            tail=0;
        }
    }
    public Item dequeue(){
        if(n==0){
            throw new NoSuchElementException("Queue Underflow");
        }
        Item item=arr[head];
        arr[head++]=null;
        n--;
        if(head==arr.length){
            head=0;
        }
        if(n==arr.length/4){
            resize(arr.length/2);
        }
        return item;
    }
    public Iterator<Item> iterator(){
        return new ArrayIterator();
    }
    private class ArrayIterator implements Iterator<Item>{
        int i=head;
        public boolean hasNext(){
            return i<n;
        }
        public Item next(){
            return arr[i++];
        }
    }
}
