package Sort.Comparator;

import java.util.Comparator;

public class Student {
    public final static  Comparator<Student> By_name=new byName();
    public final static Comparator<Student> By_section=new bySection();
    private final String name;
    private final int section;
    public Student(String name,int section){
        this.name=name;
        this.section=section;
    }
    public String getName() {
        return name;
    }

    public int getSection() {
        return section;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", section=" + section +
                '}';
    }
    private static class byName implements Comparator<Student>{
        public int compare(Student a,Student b){
            return a.name.compareTo(b.name);
        }
    }
    private static class bySection implements Comparator<Student>{
        public int compare(Student a,Student b){
            return a.section-b.section;
        }
    }
}
