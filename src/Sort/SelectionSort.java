package Sort;

import java.util.Arrays;


public class SelectionSort  {
    private static <T extends Comparable<T>>boolean less(T v, T w) {
        return v.compareTo(w) < 0;
        /*The compareTo method is a method defined in the Comparable interface in Java.
        It is used to compare two objects for the purpose of sorting.
        The method returns an integer value that indicates the relationship between the two objects being compared.
        Specifically:
        If the current object is less than the specified object, compareTo returns a negative integer.
        If the current object is equal to the specified object, compareTo returns 0.
        If the current object is greater than the specified object, compareTo returns a positive integer.*/
    }
    private static <T extends Comparable<T>> void swap(T[] a, int i, int j)
    {
        T swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    private static <T extends Comparable<T>> boolean isSorted(T[] a)
    {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
    public static <T extends Comparable<T>> void sort(T[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
        {
            int min = i;
            for (int j = i+1; j < N; j++)
                if (less(a[j], a[min]))
                    min = j;
            swap(a, i, min);
        }
    }
    public static void main(String[] args) {
        Integer[] arr={10,5,1,4,3,2};
        sort(arr);
        System.out.println(isSorted(arr));
        System.out.println(Arrays.toString(arr));
        String[] stringArr = {"banana", "apple", "orange", "grape", "kiwi"};
        sort(stringArr);
        System.out.println(isSorted(stringArr));
        System.out.println(Arrays.toString(stringArr));
    }
}
