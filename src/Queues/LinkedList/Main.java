package Queues.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedQueues  queues=new LinkedQueues();
        System.out.println("Queue isEmpty:"+queues.isEmpty());
        queues.enqueue("Naruto");
        queues.enqueue("Sasuke");
        queues.enqueue("Sakura");
        queues.items();
        System.out.println("Queue Size:"+queues.getSize());
        System.out.println("Dequeue:"+queues.dequeue());
        System.out.println("Dequeue:"+queues.dequeue());
        queues.items();
    }
}
