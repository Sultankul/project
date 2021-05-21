import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] array = {3, 4, 1, 5, 6, 7, 8, 2, 4};

        MyArrays.sort(array);

        for (int e : array) {
            System.out.print(e + " ");
        }

        System.out.println();


        Student[] students = {
                new Student("Bob", 3.3f,2000),
                new Student("Alice ", 4.0f,1999),
                new Student("Eve", 3.9f,2001)
        };

        MyArrays.sort(students, new MyCompareByName());

        for (Student student: students){
            System.out.print(student + " ");
        }

        System.out.println();

        MyArrays.sort(students, new MyCompareByGpa());

        for (Student gpa: students){
            System.out.print(gpa + " ");
        }

        System.out.println();

        MyArrays.sort(students, (first, second) -> {
            Student right = (Student)first;
            Student left = (Student)second;
            return Integer.compare(right.getBirthYear(), left.getBirthYear());
        });

        for (Student gpa: students){
            System.out.print(gpa + " ");
        }

        System.out.println();

        Rational[] rationals = {
                new Rational(1,2), new Rational(2,3), new Rational(4,5)
        };


        MyArrays.sort(rationals);
        for (Rational e: rationals){
            System.out.print(e + " ");
        }

        System.out.println();
    }
}
