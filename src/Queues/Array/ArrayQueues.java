package Queues.Array;

public class ArrayQueues {
    private String[] array;
    private int head, tail, size;

    public ArrayQueues() {
        this.array = new String[1];
        this.size = this.head = this.tail = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void enqueue(String data) {
        if (size == array.length) {
            resize(array.length * 2);
        }
        array[tail++] = data;
        if (tail == array.length) {
            tail = 0;
        }
        size++;
    }

    public String dequeue() {
        if (size == 0) {
            return "Queue is empty";
        }
        String item = array[head];
        array[head++] = null;
        if (head == array.length) {
            head = 0;
        }
        size--;
        if (size > 0 && size == array.length / 4) {
            resize(array.length / 2);
        }
        return item;
    }

    private void resize(int length) {
        String[] copy = new String[length];
        System.arraycopy(array, head, copy, 0, size);
        array = copy;
        head = 0;
        tail = size;
    }

    public void items() {
        for (int i = 0; i < size; i++) {
            int index = (head + i) % array.length;
            System.out.print(array[index] + " ");
        }
        System.out.println();
    }

}
