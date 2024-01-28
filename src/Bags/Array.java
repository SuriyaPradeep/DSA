package Bags;

import java.util.Iterator;

public class Array<Item> implements Iterable<Item>{
    private int head,n;
    private Item[] arr;
    public Array(){
        this.head=this.n=0;
        this.arr=(Item[]) new Object[1];
    }
    private void resize(int length){
        Item[] copy=(Item[]) new Object[length];
        System.arraycopy(arr,head,copy,0,n);
        arr=copy;
    }
    public void add(Item data){
        if(n== arr.length){
            resize(arr.length*2);
        }
        arr[ n++]=data;
    }
    public int getSize(){
        return n;
    }
    public Iterator<Item> iterator(){
        return new ArrayIterator();
    }
    private class ArrayIterator implements Iterator<Item>{
        int i=head;
        public boolean hasNext() {
            return i<n;
        }
        public Item next(){
            return arr[i++];

        }
    }
}
