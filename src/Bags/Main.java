package Bags;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bag Using LinkedList(Stack)");
        LinkedList<Integer> bag1=new LinkedList<>();
        bag1.add(1);
        bag1.add(2);
        bag1.add(3);
        bag1.add(4);
        bag1.add(5);
        System.out.println("Bag 1 Size:"+bag1.getSize());
        System.out.println("Items in Bag 1");
        for(int item:bag1){
            System.out.print(item+" ");
        }
        System.out.println();
        System.out.println("Bag using Array(Queue)");
        Array<Integer> bag2=new Array<>();
        bag2.add(6);
        bag2.add(7);
        bag2.add(8);
        bag2.add(9);
        bag2.add(10);
        System.out.println("Bag 2 Size:"+bag2.getSize());
        System.out.println("Items in Bag 2");
        for(int item:bag2){
            System.out.print(item+" ");
        }
    }
}
