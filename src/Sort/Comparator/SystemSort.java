package Sort.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SystemSort {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 1));
        students.add(new Student("Bob", 2));
        students.add(new Student("Charlie", 1));

        // Sort students by name
        Collections.sort(students, Student.By_name);
        System.out.println("Sorted by name:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Sort students by section
        Collections.sort(students, Student.By_section);
        System.out.println("\nSorted by section:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
