package Queues.Iterator;

public class Main {
    public static void main(String[] args) {
        LinkedQueue<String> queueList=new LinkedQueue<>();
        System.out.println("Linked List");
        System.out.println("Queue isEmpty:"+queueList.isEmpty());
        queueList.enqueue("Naruto");
        queueList.enqueue("Sasuke");
        queueList.enqueue("Sakura");
        for(String  item:queueList){
            System.out.print(item+" ");
        }
        System.out.println();
        System.out.println("Queue Size:"+queueList.getSize());
        System.out.println("Dequeue:"+queueList.dequeue());
        System.out.println("Dequeue:"+queueList.dequeue());
        for(String  item:queueList){
            System.out.print(item+" ");
        }
        System.out.println();
        System.out.println("Array");
        ArrayQueue<String> queueArray=new ArrayQueue<>();
        System.out.println("Queue isEmpty:"+queueArray.isEmpty());
        queueArray.enqueue("Naruto");
        queueArray.enqueue("Sasuke");
        queueArray.enqueue("Sakura");
        for(String  item:queueArray){
            System.out.print(item+" ");
        }
        System.out.println();
        System.out.println("Queue Size:"+queueArray.getSize());
        System.out.println("Dequeue:"+queueArray.dequeue());
        System.out.println("Dequeue:"+queueArray.dequeue());
        for(String  item:queueArray){
            System.out.print(item+" ");
        }
    }
}
