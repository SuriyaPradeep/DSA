package Stacks.Generics.Array;

import java.util.NoSuchElementException;

public class ArrayGenericStacks<Item> {
    private Item[] s;
    private int n;
    public ArrayGenericStacks(){
        this.n=0;
        s=(Item[]) new Object[1];
    }
    public boolean isEmpty(){
        return n==0;
    }
    public void push(Item data){
        if(n==s.length){
            resize(s.length*2);
        }
        s[n++]=data;
        //Same as
        //s[n]=data
        //n++;
    }
    public Item pop(){
        if(n==0){
            throw new NoSuchElementException("Stack underflow");
        }
        Item item=s[--n];
        //Same as
        //n--;
        //String item=s[n]
        s[n]=null;
        if(n>0 && n==s.length/4){
            resize(s.length/2);
        }
        return item;
    }
    public void resize(int length){
        Item[] copy = (Item[])new Object[length];
        if (n >= 0)
            System.arraycopy(s, 0, copy, 0, n);
        /*
        Parameters :
        source_arr : array to be copied from
        sourcePos : starting position in source array from where to copy
        dest_arr : array to be copied in
        destPos : starting position in destination array, where to copy in
        len : total no. of components to be copied.
         */
        s=copy;
    }
    public int getSize(){
        return n;
    }

}
