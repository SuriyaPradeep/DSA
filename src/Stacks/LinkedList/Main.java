package Stacks.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedStack stack=new LinkedStack();
        System.out.println("Is Stack Empty:"+stack.isEmpty());
        System.out.println("Popped:"+stack.pop());
        stack.push("Naruto");
        stack.push("Sasuke");
        stack.push("Sakura");
        stack.items();
        System.out.println("Is Stack Empty:"+stack.isEmpty());
        System.out.println("Stack size:"+stack.getSize());
        System.out.println("Popped:"+stack.pop());
        stack.items();
    }
}
