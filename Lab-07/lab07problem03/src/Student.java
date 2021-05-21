
import java.util.Comparator;

class CompareByName implements Comparator<Student> {
    public int compare(Student first, Student second) {
        return first.getName().compareTo(second.getName());
    }
}

class CompareByGpa implements Comparator<Student>{
    public int compare(Student first, Student second){
        return Float.compare(first.getGpa(), second.getGpa());
    }
}

class MyCompareByGpa implements MyComparator{
    public int compare(Object first, Object second){
        Student right = (Student)first;
        Student left = (Student)second;
        return Float.compare(right.getGpa(), left.getGpa());
    }
}


class MyCompareByName implements MyComparator {
    public int compare(Object first, Object second) {
        Student right = (Student)first;
        Student left = (Student)second;
        return right.getName().compareTo(left.getName());
    }
}


public class Student {
    private String name;
    private float gpa;
    private int birthYear;

    public Student(String name, float gpa, int birthYear){
        this.name = name;
        this.gpa = gpa;
        this.birthYear = birthYear;
    }

    public String getName(){
        return name;
    }

    public float getGpa(){
        return gpa;
    }

    public int getBirthYear(){
        return birthYear;
    }

    public String toString(){
        return String.format("Student(%s, %.1f,%d)", name, gpa, birthYear);
    }
}
