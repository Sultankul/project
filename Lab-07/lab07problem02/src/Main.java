import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Bob", 3.3f,2000),
                new Student("Alice ", 4.0f,1999),
                new Student("Eve", 3.9f,2001)
        };

        Arrays.sort(students, new CompareByName());

        for (Student student: students){
            System.out.print(student + " ");
        }

        System.out.println();

        Arrays.sort(students, new CompareByGpa());

        for (Student gpa: students){
            System.out.print(gpa + " ");
        }

        System.out.println();

        Arrays.sort(students, (first, second) -> Integer.compare(first.getBirthYear(), second.getBirthYear()));

        for (Student gpa: students){
            System.out.print(gpa + " ");
        }
    }
}
