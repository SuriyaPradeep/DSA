package Sort.Comparator;

import java.util.Comparator;

public class Insertion {
    public static void sort(Object[] a, Comparator comparator)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
            for (int j = i; j > 0 && less(comparator, a[j], a[j-1]); j--)
                exch(a, j, j-1);
    }
    //Custom Defined Descending order
    static class IntegerDesceComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return b.compareTo(a);
        }
    }
    //Custom Defined Ascending order
    static class IntegerAsceComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return a.compareTo(b);
        }
    }
    private static boolean less(Comparator c, Object v, Object w)
    { return c.compare(v, w) < 0; }
    private static void exch(Object[] a, int i, int j)
    { Object swap = a[i]; a[i] = a[j]; a[j] = swap; }

    public static void main(String[] args) {
        Integer[] numbers={10,2,14,56,3,1};
        //Sort the array using a custom comparator descending
        sort(numbers, new IntegerDesceComparator());

        //Print the sorted array
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
        //Sort the array using a custom comparator ascending
        sort(numbers, new IntegerAsceComparator());

        //Print the sorted array
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
