package LinkedList;

public class LinkedList{
    //Maintains the linked list and performs its operations
    Node head;
    public LinkedList(){
        this.head=null;
    }
    public void insertAtStart(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
    }
    public void insertAtEnd(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            return;
        }
        Node last=head;
        while (last.next!=null){
            last=last.next;
        }
        last.next=newnode;
    }
    public void insert(int data,int pos){
        if(pos==1){
            insertAtStart(data);
            return;
        }
        Node current=head;
        Node prev=null;
        Node newnode=new Node(data);
        for(int i=0;i<pos-1;i++){
            prev=current;
            current=current.next;
        }
        if(prev!=null)
            prev.next=newnode;
        newnode.next=current;
    }
    public int Search(int key){
        Node current=head;
        int index=0;
        while (current!=null){
            if(current.data==key){
                return index;
            }
            current=current.next;
            index++;
        }
        return -1;
    }
    public void delete(int key){
        int index=Search(key);
        if(index==-1){
            System.out.println("Element not found in the List");
            return;
        } else if(index==0){
            head=head.next;
            return;
        }
        Node current=head;
        Node prev=null;
        for(int i=0;i<index;i++){
            prev=current;
            current=current.next;
        }
        if(prev!=null)
            prev.next=current.next;
    }
    public void display(){
        Node current=head;
        while (current!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
        System.out.println();
    }
}
