import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter number of subjects: ");
            int subjects = sc.nextInt();

            int total = 0;
            System.out.println("Enter marks:");
            for (int j = 0; j < subjects; j++) {
                total += sc.nextInt();
            }
            sc.nextLine();
            students.add(new Student(name, total));
        }

        students.sort(Comparator.comparingInt(s -> s.totalMarks));

        System.out.println("\nSorted Students by Total Marks:");
        for (Student student : students) {
            System.out.println(student.name + " - Total Marks: " + student.totalMarks);
        }
    }
}