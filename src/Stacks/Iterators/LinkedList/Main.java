package Stacks.Iterators.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedStack<Integer> stack=new LinkedStack<>();
        System.out.println("Is Stack Empty:"+stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Is Stack Empty:"+stack.isEmpty());
        System.out.println("Stack size:"+stack.getSize());
        for (int s : stack) {
            System.out.print(s+" ");
        }
        System.out.println();
        System.out.println("Popped:"+stack.pop());
        System.out.println("Popped:"+stack.pop());
        System.out.println("Stack size:"+stack.getSize());
    }
}
