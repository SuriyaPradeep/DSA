package Sort.Comparator;

import java.util.ArrayList;

public class SystemSort {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 1));
        students.add(new Student("Bob", 2));
        students.add(new Student("Charlie", 1));

        // Sort students by name
        students.sort(Student.By_name);
        System.out.println("Sorted by name:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Sort students by section
        students.sort(Student.By_section);
        System.out.println("\nSorted by section:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
