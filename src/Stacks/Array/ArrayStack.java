package Stacks.Array;

public class ArrayStack {
    private String[] s;
    private int n;
    public ArrayStack(){
        this.s=new String[1];
        this.n=0;
    }
    public boolean isEmpty(){
        return n==0;
    }
    public void push(String data){
        if(n==s.length){
            resize(s.length*2);
        }
        s[n++]=data;
        //Same as
        //s[n]=data
        //n++;
    }
    public String pop(){
        if(n==0){
            return "Empty Stack";
        }
        String item=s[--n];
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
        String[] copy=new String[length];
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
    public void items(){
        for(int i=0;i<n;i++){
            System.out.print(s[i]+" ");
        }
        System.out.println();
    }
}
