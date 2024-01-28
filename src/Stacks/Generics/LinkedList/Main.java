package Stacks.Generics.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedGenericStacks<Integer> stack=new LinkedGenericStacks<>();
        System.out.println("Is Stack Empty:"+stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Is Stack Empty:"+stack.isEmpty());
        System.out.println("Stack size:"+stack.getSize());
        System.out.println("Popped:"+stack.pop());
        System.out.println("Popped:"+stack.pop());
    }
}
