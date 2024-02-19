package PriorityQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayOrdered<T extends Comparable<T>> implements Iterable<T> {
    private  T[] pq;
    private  int size;
    public ArrayOrdered(){
        this.size=0;
        this.pq=(T[]) new Comparable[1];
    }
    private  void resize(int capacity){
        T[] cpyArr=(T[]) new Comparable[capacity];
        System.arraycopy(pq,0,cpyArr,0,size);
        pq=cpyArr;
    }
    private boolean isEmpty(){
        return size==0;
    }
    private int getSize(){
        return size;
    }
    private boolean less(T a, T b){
        return a.compareTo(b)<0;
    }
    private T dequeue(){
        if(size==0){
            throw new NoSuchElementException("Queue is Empty");
        }
        T item= pq[--size];
        if(size== pq.length/4){
            resize(pq.length/2);
        }
        return item;
    }
    private void enqueue(T x){
        if(size== pq.length){
            resize(pq.length*2);
        }
        int i=size-1;
        while (i>=0 && less(x,pq[i])){
            pq[i+1]=pq[i];
            i--;
        }
        pq[i+1]=x;
        size++;
    }
    public Iterator<T> iterator(){
        return new ArrayIterator();
    }
    private class ArrayIterator implements Iterator<T>{
        int i=0;
        public boolean hasNext(){
            return i<size;
        }
        public T next(){
            return pq[i++];
        }
    }

    public static void main(String[] args) {
        ArrayOrdered<Integer> pq=new ArrayOrdered<>();
        pq.enqueue(10);
        pq.enqueue(5);
        pq.enqueue(26);
        pq.enqueue(35);
        for(Integer x:pq){
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println(pq.dequeue());
        System.out.println(pq.dequeue());
        System.out.println(pq.dequeue());
    }
}
