package Students.src.BasicLevel;

import java.util.Scanner;

public class StudentKeyboardInput {
    public StudentKeyboardInput() {
    }

    public Student addStudent() {
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        try {
            System.out.print("Input student name: ");
            student.setName(sc.nextLine());
            System.out.print("Input student last name: ");
            student.setLastName(sc.nextLine());
            System.out.print("Input student gender: ");
            student.setGender(Gender.valueOf(sc.nextLine()));
            System.out.print("Input student ID: ");
            student.setId(Integer.parseInt(sc.nextLine()));
            System.out.print("Input student group name: ");
            student.setGroupName(sc.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
        return student;
    }

    @Override
    public String toString() {
        return "StudentKeyboardInput{}";
    }
}
