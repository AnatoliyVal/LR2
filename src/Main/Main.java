package Main;

import entities.Student;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Створення масиву студентів
        List<Student> students = createStudentsArray();

        System.out.println("=== Всі студенти ===");
        printAllStudents(students);

        System.out.println("\n=== Студенти факультету 'Комп'ютерні науки' ===");
        printStudentsByFaculty(students, "Комп'ютерні науки");

        System.out.println("\n=== Студенти, які народились після 2000 року ===");
        printStudentsBornAfterYear(students, 2000);

        System.out.println("\n=== Студенти групи 'КН-21-1' ===");
        printStudentsByGroup(students, "КН-21-1");
    }

    // Метод для створення масиву об'єктів Student
    public static List<Student> createStudentsArray() {
        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Іванов", "Іван", "Іванович",
                LocalDate.of(1999, 5, 15), "вул. Шевченка, 123", "+380501234567",
                "Комп'ютерні науки", 3, "КН-21-1"));

        students.add(new Student(2, "Петров", "Петро", "Петрович",
                LocalDate.of(2001, 8, 22), "вул. Франка, 45", "+380671234568",
                "Комп'ютерні науки", 2, "КН-22-2"));

        students.add(new Student(3, "Сидорова", "Марія", "Олексіївна",
                LocalDate.of(2002, 3, 10), "вул. Грушевського, 67", "+380631234569",
                "Економічний", 1, "ЕК-23-1"));

        students.add(new Student(4, "Коваленко", "Олексій", "Сергійович",
                LocalDate.of(1998, 12, 5), "вул. Лісова, 89", "+380501234570",
                "Комп'ютерні науки", 4, "КН-20-1"));

        students.add(new Student(5, "Мельник", "Анна", "Вікторівна",
                LocalDate.of(2003, 7, 18), "вул. Садова, 12", "+380671234571",
                "Економічний", 1, "ЕК-23-2"));

        return students;
    }

    // a) Список студентів заданого факультету
    public static void printStudentsByFaculty(List<Student> students, String faculty) {
        boolean found = false;
        for (Student student : students) {
            if (student.getFaculty().equalsIgnoreCase(faculty)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Студентів на факультеті '" + faculty + "' не знайдено.");
        }
    }

    // b) Список студентів, які народились після заданого року
    public static void printStudentsBornAfterYear(List<Student> students, int year) {
        boolean found = false;
        for (Student student : students) {
            if (student.getBirthDate().getYear() > year) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Студентів, які народились після " + year + " року, не знайдено.");
        }
    }

    // c) Список навчальної групи
    public static void printStudentsByGroup(List<Student> students, String group) {
        boolean found = false;
        for (Student student : students) {
            if (student.getGroup().equalsIgnoreCase(group)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Студентів у групі '" + group + "' не знайдено.");
        }
    }

    // Додатковий метод для виведення всіх студентів
    public static void printAllStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}