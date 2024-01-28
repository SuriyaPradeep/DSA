package Queues.Array;

public class Main {
    public static void main(String[] args) {
        ArrayQueues queues = new ArrayQueues();
        System.out.println("Queue isEmpty:" + queues.isEmpty());
        queues.enqueue("Naruto");
        queues.enqueue("Sasuke");
        queues.enqueue("Sakura");
        queues.items();
        System.out.println("Queue Size:" + queues.getSize());
        System.out.println("Dequeue:" + queues.dequeue());
        System.out.println("Dequeue:" + queues.dequeue());
        queues.items();
    }
}
