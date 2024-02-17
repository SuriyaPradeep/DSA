package PriorityQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayUnordered<T extends Comparable<T>> implements Iterable<T> {
    private  T[] pq;
    private  int size;
    public ArrayUnordered(){
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
    private void enqueue(T a){
        if(size==pq.length){
            resize(pq.length*2);
        }
        pq[size++]=a;
    }
    private boolean less(T a, T b){
        return a.compareTo(b)<0;
    }
    private void swap(int i,int j){
        T temp=pq[i];
        pq[i]=pq[j];
        pq[j]=temp;
    }
    private T dequeue(){
        if(size==0){
            throw new NoSuchElementException("Queue is Empty");
        }
        int max=0;
        for(int i=0;i<size;i++){
            if(less(pq[max],pq[i])){
                max=i;
            }
        }
        swap(max,size-1);
        T item=pq[--size];
        if(size== pq.length/4){
            resize(pq.length/2);
        }
        return item;
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
        ArrayUnordered<Integer> pq=new ArrayUnordered<>();
        pq.enqueue(10);
        pq.enqueue(5);
        pq.enqueue(26);
        for(Integer x:pq){
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println(pq.dequeue());
       System.out.println(pq.dequeue());
       System.out.println(pq.dequeue());
    }
}
