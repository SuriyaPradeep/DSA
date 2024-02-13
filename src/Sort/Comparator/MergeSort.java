package Sort.Comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort<T> {
    /*Comparator<T>: This represents a comparator that can compare objects of type T.
    <? super T>: This is a bounded wildcard that specifies that the comparator can compare objects of type T or any supertype of T.
    It allows for greater flexibility in using comparators.
     */
    public void sort(List<T> list, Comparator<? super T> c) {
        if (list == null || list.size() <= 1) {
            return;
        }
        mergerSort(list, 0, list.size() - 1, c);
    }

    private static <T> boolean less(Comparator<? super T> c, T a, T b) {
        return c.compare(a, b) < 0;
    }

    private void merge(List<T> list, int beg, int mid, int end, Comparator<? super T> c) {
        int n1 = mid - beg + 1;
        int n2 = end - mid;

        List<T> left = new ArrayList<>(list.subList(beg, mid + 1));
        List<T> right = new ArrayList<>(list.subList(mid + 1, end + 1));

        int i = 0, j = 0, k = beg;
        while (i < n1 && j < n2) {
            if (less(c, right.get(j), left.get(i))) {
                list.set(k++, right.get(j++));
            } else {
                list.set(k++, left.get(i++));
            }
        }
        while (i < n1) {
            list.set(k++, left.get(i++));
        }
        while (j < n2) {
            list.set(k++, right.get(j++));
        }
    }

    private void mergerSort(List<T> list, int beg, int end, Comparator<? super T> c) {
        if (beg < end) {
            int mid = (beg + end) / 2;
            mergerSort(list, beg, mid, c);
            mergerSort(list, mid + 1, end, c);
            merge(list, beg, mid, end, c);
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 1));
        students.add(new Student("Bob", 2));
        students.add(new Student("Charlie", 1));

        MergeSort<Student> mergeSort = new MergeSort<>();

        // Sort students by name
        mergeSort.sort(students, Student.By_name);
        System.out.println("Sorted by name:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Sort students by section
        mergeSort.sort(students, Student.By_section);
        System.out.println("\nSorted by section:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}