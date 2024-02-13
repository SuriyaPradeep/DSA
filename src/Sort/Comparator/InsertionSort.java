package Sort.Comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InsertionSort {
    public static boolean less(Comparator c,Object a,Object b){
        return c.compare(a,b)<0;
    }
    public static void swap(Object[] a, int i, int j)
    {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    public static void sort(Object[] arr,Comparator c){
        int n=arr.length;
        for(int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if(less(c,arr[j],arr[j-1])){
                    swap(arr,j,j-1);
                }
            }
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
