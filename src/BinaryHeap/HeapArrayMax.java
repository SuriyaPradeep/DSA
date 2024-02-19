package BinaryHeap;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class HeapArrayMax<T extends Comparable<T>> implements Iterable<T>{
    private T[] bh;
    private int size;
    public HeapArrayMax(){
        this.bh=(T[])new Comparable[2];
        this.size=0;
    }
    private int getSize(){
        return size;
    }
    private boolean isEmpty(){
        return size==0;
    }
    private void resize(int capacity){
        T[] cpyArr=(T[]) new Comparable[capacity];
        System.arraycopy(bh,1,cpyArr,1,size);
        bh=cpyArr;
    }
    private void swap(int i,int j){
        T temp=bh[i];
        bh[i]=bh[j];
        bh[j]=temp;
    }
    private boolean less(int a,int b){
        return bh[a].compareTo(bh[b])<0;
    }
    //K is key
    private void swim(int k){
        //Child's key becomes larger key than its parent's key.
        //If this condition is true exchange child and parent until order is maintained
        //Use while Insertion
        while (k>1 && less((k/2), k)) {//Parent less than child
            swap(k,k/2);//Swap parent and child
            k = k/2;//Make child pointer to parent index
        }
    }
    private void sink(int k){
        //Parent's key becomes smaller than one (or both) of its children's.
        // If condition is true then exchange parent with larger key in child of two repeat until order is maintained
        //Use while deletion
        while(2*k<=size){//Checks if child index is out of array or not
            int j=2*k;//Left child
            //Check Left or right Bigger
            if(j<size && less(j,j+1)){
                j++;
            }
            if(!less(k,j)){//Checks is the parent is larger than the child
                break;
            }
            swap(k,j);
            k=j;
        }
    }
    private void enqueue(T x){
        if(size==bh.length-1){
            resize(bh.length*2);
        }
        bh[++size]=x;
        swim(size);
    }
    private T dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is Empty");
        }
        T item=bh[1];
        swap(1,size--);
        sink(1);
        bh[size+1]=null;
        if(size>0 && size==(bh.length-1)/4){
            resize(bh.length/2);
        }
        return item;
    }
    //Check if the Array is Max Heap
    private boolean isMaxHeap(){
        //Checks if there is any null values in between values
        for (int i = 1; i <= size; i++) {
            if (bh[i] == null) return false;
        }
        //Checks if all the deleted values space are made null
        for (int i = size+1; i < bh.length; i++) {
            if (bh[i] != null) return false;
        }
        //Calls a Function to Check the order
        return isMaxHeapOrdered(1);
    }
    private boolean isMaxHeapOrdered(int k) {
        //It is a recursive function
        //Will return true if no error in ordering is found till k==size
        if (k > size) return true;
        //Checks if both child are smaller than the parent
        int left = 2*k;
        int right = 2*k + 1;
        if (left  <= size && less(k, left))  return false;
        if (right <= size && less(k, right)) return false;
        //Call the function recursively for the child's
        return isMaxHeapOrdered(left) && isMaxHeapOrdered(right);
    }
    public Iterator<T> iterator(){
        return new ArrayIterator();
    }
    private class ArrayIterator implements Iterator<T>{
        int i=1;
        public boolean hasNext(){
            return i<=size;
        }
        public T next(){
            return bh[i++];
        }
    }

    public static void main(String[] args) {
        HeapArrayMax<Integer> bh=new HeapArrayMax<>();
        bh.enqueue(10);
        bh.enqueue(5);
        bh.enqueue(26);
        bh.enqueue(35);
        for(int num:bh){
            System.out.print(num+" ");
        }
        System.out.println();
        System.out.println(bh.isMaxHeap());
        System.out.println(bh.dequeue());
        System.out.println(bh.dequeue());
        System.out.println(bh.dequeue());
        System.out.println(bh.dequeue());
        bh.enqueue(35);
        System.out.println(bh.dequeue());
    }
}
