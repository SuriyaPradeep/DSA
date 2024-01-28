package Queues.LinkedList;

public class LinkedQueues {
    static class Node{
        private String item;
        private Node next;
        Node(String data){
            this.item=data;
            this.next=null;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public LinkedQueues(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }
    public boolean isEmpty(){
        return head==null;
    }
    public void enqueue(String data){
        Node newnode=new Node(data);
        if(isEmpty()){
           head=newnode;
        } else{
            tail.next=newnode;
        }
        tail=newnode;
        size++;
    }
    public String dequeue(){
        if(isEmpty()){
            return "Queue is Empty";
        }
        String item=head.item;
        head=head.next;
        size--;
        return item;
    }

    public int getSize(){
        return size;
    }
    public void items(){
        Node current=head;
        while(current!=null){
            System.out.print(current.item+" ");
            current=current.next;
        }
        System.out.println();
    }

}
